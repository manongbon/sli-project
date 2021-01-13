package com.project;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.components.CommonUtil;
import com.components.ConfigFileProperty;
import com.components.DateFormatter;
import com.components.GenerateSchedule;
import com.components.PropertiesCache;
import com.models.Schedules;

public class App {
	private static final Scanner scanner = new Scanner(System.in);
	private static final ConfigFileProperty config = new ConfigFileProperty();

	private static String startDate;
	private static String endDate;
	private static GenerateSchedule generator = new GenerateSchedule();
	

	private static void readMain() throws Exception {
		try {
			do {
				System.out.print("Enter Target Start Date(Format : yyyy-mm-dd): ");
				startDate = scanner.nextLine();
			} while (!DateFormatter.getInstance().isValidDate(startDate));
			do {
				System.out.print("Enter Target Completion Date(Format : yyyy-mm-dd): ");
				endDate = scanner.nextLine();
			} while (!DateFormatter.getInstance().isValidDate(endDate));
			
		} catch (Exception e) {
			throw e;
		}
		assignTask();
	}

	private static void assignTask() throws Exception {
		int taskId;
		if (!CommonUtil.isNull(startDate) && !CommonUtil.isNull(endDate)) {
			taskId = PropertiesCache.getInstance().getStartTask();
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("# Project Plan for MC-Best");
			System.out.println(String.format("# Target Start Date: %s", DateFormatter.getInstance().convertDate(DateFormatter.getInstance().parseDate(startDate))));
			System.out.println(String.format("# Target Completion Date: %s", DateFormatter.getInstance().convertDate(DateFormatter.getInstance().parseDate(endDate))));
			System.out.println();
			System.out.println("# Project Tasks")	;
			System.out.println("Task-ID \t\t Start Date \t\t End Date \t\t Duration(Days)\t\tTask\t\t\tDependencies(Task-ID)");
			System.out.println("------- \t\t ---------- \t\t -------- \t\t -------------- \t--------------- \t-----------------------");
			
			List<Schedules> updSchedules = generator.getScheduleList().stream()
					.map(item -> {
						try {
							if(item.getTaskID() == 102) item.setStartDate(DateFormatter.getInstance().parseDate(startDate));
						} catch (Exception e) {
							return item;
						}
						return item;
					}).collect(Collectors.toList());
					
					
			for(Schedules item : updSchedules) {
				System.out.print(String.format("%s \t\t\t", item.getTaskID()));
				System.out.print(String.format("%s \t\t\t", DateFormatter.getInstance().convertDate(CommonUtil.getStartDate(item,updSchedules).getStartDate())));
				System.out.print(String.format("%s \t\t\t\t", DateFormatter.getInstance().convertDate(CommonUtil.getEndDate(item).getEndDate())));
				System.out.print(String.format("%s \t\t", item.getDuration()));
				System.out.print(String.format("%s %s", item.getTasks(),item.getTaskID() == 107 || item.getTaskID() == 109 ? "\t" : "\t\t"));
				System.out.print(String.format("%s", item.getDependencies().toString().replaceAll("\\[|\\]", "")));
				System.out.println();
			}
			System.out.println("---------------------------------------------------------------------------------------");
		} else {
			System.out.println("Must input start and end date for project plan.");
		}
	}

	public static void main(String[] args) {
		try {
			readMain();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
