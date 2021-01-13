package com.components;

import java.util.Calendar;
import java.util.List;

import com.models.Schedules;

public class CommonUtil {

	public static boolean isNull(Object obj) {
		return (obj == null || "".equals(String.valueOf(obj))) ? true : false;
	}

	public static Schedules getEndDate(Schedules schedule) throws Exception {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(schedule.getStartDate());
		String newDate = null;
		if (schedule.getDependencies().isEmpty()) {
			int ctr = 1;
			do {
				calendar.add(Calendar.DATE, 1);
				schedule.setEndDate(DateFormatter.getInstance()
						.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
				ctr++;
			} while (ctr <= schedule.getDuration());

		} else {
		
			if (schedule.getTaskID() == 103) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 106) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 104) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 110) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 105) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 107) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 109) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			} else if (schedule.getTaskID() == 108) {
				int ctr = 1;
				do {
					calendar.add(Calendar.DATE, 1);
					schedule.setEndDate(DateFormatter.getInstance()
							.parseDate(DateFormatter.getInstance().getDateFormat().format(calendar.getTime())));
					ctr++;
				} while (ctr <= schedule.getDuration());
			}
		}
		return schedule;
	}

	public static Schedules getStartDate(Schedules schedule, List<Schedules> sched) throws Exception {
		if (schedule.getDependencies().isEmpty()) {
			schedule.setStartDate(DateFormatter.getInstance()
					.parseDate(DateFormatter.getInstance().getDateFormat().format(schedule.getStartDate())));
		} else {
			if (schedule.getTaskID() == 103) {
				schedule.setStartDate(sched.get(0).getEndDate());
			} else if (schedule.getTaskID() == 106) {
				schedule.setStartDate(sched.get(1).getEndDate());
			} else if (schedule.getTaskID() == 104) {
				schedule.setStartDate(sched.get(2).getStartDate());
			} else if (schedule.getTaskID() == 110) {
				schedule.setStartDate(sched.get(3).getEndDate());
			} else if (schedule.getTaskID() == 105) {
				schedule.setStartDate(sched.get(4).getStartDate());
			} else if (schedule.getTaskID() == 107) {
				schedule.setStartDate(sched.get(5).getEndDate());
			} else if (schedule.getTaskID() == 109) {
				schedule.setStartDate(sched.get(6).getEndDate());
			} else if (schedule.getTaskID() == 108) {
				schedule.setStartDate(sched.get(7).getEndDate());
			}

		}

		return schedule;
	}

}
