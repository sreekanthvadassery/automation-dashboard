package com.company.dashboard.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220426
 * Date related Util methods
 */
public class DateUtils {
	
	/**
	 * @author 	: Sreekanth Vadassery
	 * @param format
	 * @return Current Date and Time in specified  format (Example formats : dd/MM/yyyy hh mm ss, hh mm ss)
	 * Date		: 20220426
	 */
	public static String getCurrentDateTime(String format){
		SimpleDateFormat sdfDate = new SimpleDateFormat(format);
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
}
