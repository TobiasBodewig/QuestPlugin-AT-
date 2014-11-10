package de.philippTobias.questPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

public enum Settings {

	TEST("de.test");

	public static FileConfiguration customConfig = null;
	public static File customConfigFile = null;

	public static void reloadCustomConfig(QuestPlugin plugin) {
		if (customConfigFile == null) {
			customConfigFile = new File(plugin.getDataFolder(), "customConfig.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

		// Schaut nach den Standardwerten in der jar
		Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(plugin.getResource("customConfig.yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {}
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
		if (!customConfigFile.exists()) {
			saveCustomConfig();
		}
		for (Settings s : Settings.values()) {
			s.setValue(customConfig.get(s.getPath()));
		}
	}

	private static void saveCustomConfig() {
		if (customConfig == null || customConfigFile == null) {
			return;
		}
		try {
			customConfig.save(customConfigFile);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
					"Konfiguration konnte nicht nach " + customConfigFile + " geschrieben werden.", ex);
		}
	}

	protected String path;
	protected Object value;

	Settings(String path) {
		this.path = path;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getPath() {
		return path;
	}

	public boolean asBoolean() {
		return (Boolean) value;
	}

	public double asDouble() {
		return ((Number) value).doubleValue();
	}

	public float asFloat() {
		return ((Number) value).floatValue();
	}

	public int asInt() {
		if (value instanceof String) {
			return Integer.parseInt(value.toString());
		}
		return ((Number) value).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<String> asList() {
		if (!(value instanceof List)) {
			value = Lists.newArrayList(value);
		}
		return (List<String>) value;
	}

	public long asLong() {
		return ((Number) value).longValue();
	}

	public String asString() {
		return value.toString();
	}

}
