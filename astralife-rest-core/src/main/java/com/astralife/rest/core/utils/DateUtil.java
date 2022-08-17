package com.astralife.rest.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static synchronized String toStringWithMiliSecond(Date date) {
		if (date == null)
			return null;
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		return dateFormat.format(date);
	}

	public static synchronized String toStringUiWithMiliSecond(Date date) {
		if (date == null)
			return null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dateFormat.format(date);
	}

	public static synchronized String toStringWithMiliSecondYyyyMmDd(Date date) {
		if (date == null)
			return null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static synchronized String toStringUi(Date date) {
		if (date == null)
			return null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
}
