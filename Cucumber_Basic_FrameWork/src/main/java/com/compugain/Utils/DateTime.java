package com.compugain.Utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
public class DateTime {
	private static Logger logger = Logger.getLogger(DateTime.class);

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ymdhmsTime() throws Exception {
		String ymdhmsTime = null;
		DateFormat ymdhms = new SimpleDateFormat("HH-mm-ss_dd-MM-yy");
		Date date = new Date();
		ymdhmsTime = ymdhms.format(date);
		return (ymdhmsTime);
	}
	/**
	 *  returns a string with HH:mm:ss format
	 * @return
	 * @throws Exception
	 */
	public String hmsTime() throws Exception {
		String hmsTime = null;
		DateFormat hms = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		hmsTime = hms.format(date);
		return (hmsTime);
	}

	/**
	 *  timeDifference method is used to get the time difference between two passed parameters
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public double timeDifference(String startTime, String endTime)
	{

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date time1;
		Date time2;
		double diffTime = 0;
		try {
			time1 = dateFormat.parse(startTime);
			time2 = dateFormat.parse(endTime);
			long t1 = time1.getTime();
			long t2 = time2.getTime();
			diffTime = (Math.abs(t2 - t1) / 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("The Time Difference value is"+((double) diffTime));
		return ((double) diffTime);
	}

	/**
	 * yyyyMMDDHHmmssTime is used to set the String in yyyyMMDDHHmmssTime format
	 * @return
	 * @throws Exception
	 */
	public String yyyyMMDDHHmmssTime(){
		String ymdhmsTime = null;
		try
		{
			DateFormat ymdhms = new SimpleDateFormat("yyyyMMDDHHmmss");
			Date date = new Date();
			ymdhmsTime = ymdhms.format(date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return (ymdhmsTime);

	}
	public String HHMMDDMMyyTime() throws Exception {
		String ymdhmsTime = null;
		DateFormat ymdhms = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		Date date = new Date();
		ymdhmsTime = ymdhms.format(date);
		return (ymdhmsTime);
	}

	public static String videoDateFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy h:mm a");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Date date = new Date();
		long t=date.getTime();
		Date date1 = new Date(t + (-1 * ONE_MINUTE_IN_MILLIS));
		logger.info("Date Format After subtracting two minutes is"+dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	public static String videodate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Date date = new Date();
		long t=date.getTime();
		Date date1 = new Date(t + (-1 * ONE_MINUTE_IN_MILLIS));
		logger.info("Date Format After subtracting two minutes is"+dateFormat.format(date1));
		return dateFormat.format(date1);
	}

	public static ArrayList<String> videoDateFormatArray()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:mm a");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Date date = new Date();
		long t=date.getTime();
		ArrayList<String> datearray= new ArrayList<String>();
		for(int i=-3;i<2;i++)
		{
			Date date1 = new Date(t + (i * ONE_MINUTE_IN_MILLIS));
			datearray.add(dateFormat.format(date1));
			logger.info("Date values after"+i+"value is" +dateFormat.format(date1));
		}
		return datearray;
	}
	/**
	 * APR 28,2015
	 * @return
	 */
	public static String dateFormat()
	{
	   SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Date date = new Date();
		long t=date.getTime();
		Date date1 = new Date(t + (-1 * ONE_MINUTE_IN_MILLIS));
		logger.info("Date Format After subtracting two minutes is"+dateFormat.format(date1));
		return dateFormat.format(date1);
		
		}
	
	public static String dateFormatbyCurrentDate()
	{
	   SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Date date = new Date();
		long t=date.getTime();
		//Date date1 = new Date(t + (-1 * ONE_MINUTE_IN_MILLIS));
		logger.info("Date Format After subtracting two minutes is"+dateFormat.format(date));
		return dateFormat.format(date);
		
		}
	public static String dateFormatbyPreviousDate()
	{
		final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
		logger.info("Date Format of Previous day: "+prevDate);
		return prevDate;
		
		}
	
	public static String dayDateFormat(String language)
	{
		Date date = new Date();
		Locale locallanguage = null;
		if(language.equalsIgnoreCase("en"))
			locallanguage=Locale.ENGLISH;
		if(language.equalsIgnoreCase("fr"))
			locallanguage=Locale.FRENCH;
				DateFormat formatter = new SimpleDateFormat("EEEE M/d",locallanguage);
		logger.info("Language is"+language);
		logger.info("Date value is"+formatter.format(date));   
		return formatter.format(date);
	}

	public static String monthFormat(String language)
	{
		Locale locallanguage = null;
		if(language.equalsIgnoreCase("en"))
		{
			locallanguage=Locale.ENGLISH;
		}
		if(language.equalsIgnoreCase("fr"))
		{
			locallanguage=Locale.FRENCH;
		}

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("MMMM yyyy",locallanguage);
		logger.info("Date Value in Format is"+formatter.format(date));
		return formatter.format(date);
	}


	public static List<String> weekFormat(String language)
	{
		Locale locallanguage = null;
		if(language.equalsIgnoreCase("en"))
		{
			locallanguage=Locale.ENGLISH;
		}
		if(language.equalsIgnoreCase("fr"))
		{
			locallanguage=Locale.FRENCH;
		}
		DateFormatSymbols symbols = new DateFormatSymbols(locallanguage);
		String[] dayNames = symbols.getShortWeekdays();
		logger.info("length is"+dayNames.length);
		for (String s : dayNames) { 
			logger.info("value are"+s+"\n");
		}
		List<String> dayslist = new ArrayList<String>(Arrays.asList(dayNames));
		dayslist.remove(0);
		logger.info("day list size is"+dayslist.size());
		return dayslist;
	}

	public static String dayFormat()
	{
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("d");
		return formatter.format(date);

	}

	public static String yyyyMMDD()
	{
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		logger.info("date Format is"+formatter.format(date));
		return formatter.format(date);
	}

	public static Map<String,String>  yyyyMMDDMAP()
	{
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		Map<String,String> datemap= new HashMap<String, String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
		String currDate = dateFormat.format(date.getTime());
		String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
		String nextDatewithAddedDay = dateFormat.format(date.getTime() + MILLIS_IN_DAY+ MILLIS_IN_DAY);
		datemap.put("currentdate", currDate);
		datemap.put("previousdate", prevDate);
		datemap.put("nextdate", nextDate);
		datemap.put("nextDatewithAddedDay", nextDate);
		logger.info("Previous date: " + prevDate);
		logger.info("Currnent date: " + currDate);
		logger.info("Next date: " + nextDate);
		logger.info("nextDatewithAddedDay: " + nextDatewithAddedDay);
		
		return datemap;
	}

	public static String addHoursToSystemTime(int hours)
	{
		Date date = new Date();
		Date newdate=DateUtils.addHours(date, hours);
		DateFormat formatter = new SimpleDateFormat("h:mm a");
		logger.info("new time is"+formatter.format(newdate));
		return formatter.format(newdate);
	}

	public static String addMinutesToSystemTime(int minutes)
	{
		Date date = new Date();
		Date newdate=DateUtils.addMinutes(date,minutes);
		DateFormat formatter = new SimpleDateFormat("h:mm a");
		logger.info("new time is"+formatter.format(newdate));
		return formatter.format(newdate);
	}

	public static String addDaysToSystemTime(int days)
	{
		Date date = new Date();
		Date newdate=DateUtils.addDays(date, days);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		logger.info("new time is"+formatter.format(newdate));
		return formatter.format(newdate);
	}
	
	public static String addDaysToSystemTimeMMDDYYYY(int days)
	{
		Date date = new Date();
		Date newdate=DateUtils.addDays(date, days);
		DateFormat formatter = new SimpleDateFormat("MMM d, YYYY",Locale.ENGLISH);
		logger.info("new time is"+formatter.format(newdate));
		return formatter.format(newdate);
	}

	public int timeDifferenceMMddyyyyHHmm(String startTime, String endTime)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		String start = dateFormat.format(new Date(startTime));
		String end =   dateFormat.format(new Date(endTime));
		
		Date time1 = null;
		Date time2 = null;
		try {
			time1 = dateFormat.parse(start);
			time2 = dateFormat.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		int diifValue = time1.compareTo(time2);
		logger.info("The Time difference"+diifValue);
		return diifValue;
	}


	public  Date toDate(String dateTime) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy h:mm a");
		Date date = dateFormat.parse(dateTime);
		logger.info("The value for the date Object is"+dateFormat.format(date));
		logger.info("The value for the Object is"+date);
		return date;
	}

	public static String addDaysToSystemDate(int days){
		Date date = new Date();
		Date newdate=DateUtils.addDays(date, days);
		DateFormat formatter = new SimpleDateFormat("M/d/yy");
		logger.info("new time is"+formatter.format(newdate));
		logger.info("new time is"+formatter.format(newdate));
		return formatter.format(newdate);
	}
	
	public static String daymonthyear()
	{
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("d-MMMM-yyyy",Locale.ENGLISH);
		logger.info("date Format is"+formatter.format(date));
		return formatter.format(date);
	}

	

}
