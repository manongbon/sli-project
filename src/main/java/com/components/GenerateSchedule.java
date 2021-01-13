package com.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.models.Schedules;

public class GenerateSchedule {

	private List<Schedules> scheduleList;

	public GenerateSchedule() {
		scheduleList = new ArrayList<Schedules>(Arrays.asList(
				new Schedules(102, null, null, Byte.parseByte("5"), "Project Initiation",
						new ArrayList<Integer>()),
				new Schedules(103, null, null, Byte.parseByte("10"), "Analysis Rquirements",
						new ArrayList<Integer>(Arrays.asList(102))),
				new Schedules(106, null, null, Byte.parseByte("5"), "Prepare Test Scripts",
						new ArrayList<Integer>(Arrays.asList(102, 103))),
				new Schedules(104, null, null, Byte.parseByte("10"), "Design \t\t",
						new ArrayList<Integer>(Arrays.asList(102, 103))),
				new Schedules(110, null, null, Byte.parseByte("4"), "Infra Setup \t",
						new ArrayList<Integer>(Arrays.asList(102, 103, 104))),
				new Schedules(105, null, null, Byte.parseByte("30"), "Programming \t",
						new ArrayList<Integer>(Arrays.asList(102, 103, 104))),
				new Schedules(107, null, null, Byte.parseByte("8"), "Integration and Testing",
						new ArrayList<Integer>(Arrays.asList(102, 103, 104, 105, 106, 110))),
				new Schedules(109, null, null, Byte.parseByte("6"), "User Training and Testing",
						new ArrayList<Integer>(Arrays.asList(102, 103, 104, 105, 106, 107))),
				new Schedules(108, null, null, Byte.parseByte("3"), "Production Deployment",
						new ArrayList<Integer>(Arrays.asList(102, 103, 104, 105, 106, 107, 109)))));
	}

	public List<Schedules> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedules> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	
	

}
