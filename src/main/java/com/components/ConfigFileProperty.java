package com.components;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFileProperty {

	private final String configFileName = "config.properties";
	private static InputStream inputStream;
	private Properties prop;

	public ConfigFileProperty() {
		ClassLoader loader = this.getClass().getClassLoader();
		inputStream = loader.getResourceAsStream(configFileName);
	}

	public String getTaskID() throws Exception {
		String taskID;
		try {
			prop = new Properties();
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException(
						String.format("Config file %s could not be found", this.configFileName));
			}
			taskID = prop.getProperty("task-id");
		} catch (Exception e) {
			throw e;
		}
		return taskID;

	}

	public void setTaskID(String id, Properties prop) throws Exception {
		try (OutputStream outStream = new FileOutputStream(configFileName)) {
			prop.setProperty("task-id", id);
			prop.store(outStream, null);
		} catch (Exception e) {
			throw e;
		}
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
	
}
