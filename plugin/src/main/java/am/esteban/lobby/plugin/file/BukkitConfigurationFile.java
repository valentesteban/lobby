package am.esteban.lobby.plugin.file;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class BukkitConfigurationFile
        extends YamlConfiguration {

    private final String fileName;
    private final Plugin plugin;
    private final File file;

    public BukkitConfigurationFile(Plugin plugin,
                                   File folder,
                                   String filename) {
        this.plugin = plugin;
        this.fileName = filename;
        this.file = new File(folder, fileName);
        this.createFile();
    }

    public BukkitConfigurationFile(Plugin plugin,
                                   String filename) {
        this(plugin, plugin.getDataFolder(), filename + ".yml");
    }

    public void createFile() {
        try {
            if (!file.exists()) {
                if (this.plugin.getResource(this.fileName) != null) {
                    this.plugin.saveResource(this.fileName, false);
                } else {
                    this.save(file);
                }
                this.load(file);
                return;
            }
            this.load(file);

            this.save(file);
        } catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public void reload() {
        try {
            load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public void save() {
        try {
            this.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
