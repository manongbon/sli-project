package com.components;

import java.util.UUID;

public class PropertiesCache {
	private int startTask;
	
	private PropertiesCache() {
		setStartTask(102);
	}

	private static class LazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	public int getStartTask() {
		return startTask;
	}

	public void setStartTask(int startTask) {
		this.startTask = startTask;
	}

	

}
