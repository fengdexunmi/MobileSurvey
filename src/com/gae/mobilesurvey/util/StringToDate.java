package com.gae.mobilesurvey.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static Date convertDate(String string, String format) {
		Date date = null;
		try {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		date = simpleDateFormat.parse(string);
		} catch (Exception ex) {
		}
		return date;
		}
}
