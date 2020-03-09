package com.sysone.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class Utileria {
	public static List<String> getNextDays(int count) {
		List<String> nextDays = new LinkedList<String>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		
		
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date end = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);

		while (!gcal.getTime().after(end)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(format.format(d));
		}

		return nextDays;
	}
}
