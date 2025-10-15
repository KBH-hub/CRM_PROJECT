package com.crm.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date parseDate(String dateStr, String format){
		
		
		try {
			return new SimpleDateFormat(format).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatDate(Date date, String format){
		
		return new SimpleDateFormat(format).format(date);
		
	}
//	
//	public static Date 
//	
}
