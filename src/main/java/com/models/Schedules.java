package com.models;

import java.util.Date;
import java.util.List;

import com.components.CommonUtil;

public class Schedules {

	private int taskID;
	private Date startDate;
	private Date endDate;
	private byte duration;
	private String tasks;
	private List<Integer> dependencies;
	
	
	
	
	public Schedules(int taskID, Date startDate, Date endDate, byte duration, String tasks,
			List<Integer> dependencies) {
		super();
		this.taskID = taskID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.tasks = tasks;
		this.dependencies = dependencies;
	}
	
	
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public byte getDuration() {
		return duration;
	}
	public void setDuration(byte duration) {
		this.duration = duration;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	
	public List<Integer> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<Integer> dependencies) {
		this.dependencies = dependencies;
	}
	public boolean isValid() {
		return (!CommonUtil.isNull(this.startDate) && !CommonUtil.isNull(this.endDate)
				&& !CommonUtil.isNull(this.tasks) && CommonUtil.isNull(this.duration)) ? true : false;
	}
	
	
	
}
