package com.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;

public class DateFormatter {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat dateFormat = new SimpleDateFormat("MMM-dd");  
	
	private static class LazyHolder {
		private static final DateFormatter INSTANCE = new DateFormatter();
	}
	
	public static DateFormatter getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	
	public static boolean isValidDate(String date) {
		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static LocalDate parsedDate(String date) throws Exception {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
	}
	
	public Date parseDate(String date) throws Exception {
		return sdf.parse(date);
	}
	public Date formatDate(Date date) throws Exception {
		return sdf.parse(sdf.format(date));
	}
	
	public static SimpleDateFormat getDateFormat() {
		return sdf;
	}
	
	public String convertDate(Date date) {
		return dateFormat.format(date);
	}
}
