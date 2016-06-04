package com.agreeya.chhs.util;

/**
 * @author amit.sharma
 *
 */
public class Constants {
	/* check for the uniqueness in DB */
	public static final String EXIST = "exist";
	public static final String NOT_EXIST = "notexist";

	// Authentication Constants
	public static final int SUBSCRIBER_SESSIONID_LENGTH = 25;

	/**
	 *  error type from web service
	 *
	 */
	public enum ErrorType {
		ERROR, EXCEPTION, WARNING
	};

	public static final String CHHS_LOGGER_QUEUE = "CHHS_LOGGER_QUEUE";

	/* Universal */
	public static final String TRUE = "true";
	
	public static final String CASEID = "CASE-";

	// Application Logging Flag
	public static final String CHHS_APPLICATION_LOG = "application.logging";

	// HHS API url
	public static final String HHS_API_URL = "hhs.api.url";
	public static final String HHS_API_NODATA = "No Facilities found";

	public static final String FALSE = "false";

	// 
	/**
	 * User status in user 
	 *
	 */
	public enum UserStatusType {
		ACTIVE, INACTIVE, INCOMPLETE
	}

	/**
	 * day of week
	 *
	 */
	public enum DayOfWeek {

		SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

		private int day;

		DayOfWeek(int day) {
			this.day = day;
		}

		public int getDay() {
			return day;
		}

		public static int fromString(String day) {
			int retValue = 0;
			if (day != null) {
				String upperDay = day.toUpperCase();
				switch (upperDay) {
				case "SUNDAY":
					retValue = DayOfWeek.SUNDAY.getDay();
					break;
				case "MONDAY":
					retValue = DayOfWeek.MONDAY.getDay();
					break;
				case "TUESDAY":
					retValue = DayOfWeek.TUESDAY.getDay();
					break;
				case "WEDNESDAY":
					retValue = DayOfWeek.WEDNESDAY.getDay();
					break;
				case "THURSDAY":
					retValue = DayOfWeek.THURSDAY.getDay();
					break;
				case "FRIDAY":
					retValue = DayOfWeek.FRIDAY.getDay();
					break;
				case "SATURDAY":
					retValue = DayOfWeek.SATURDAY.getDay();
					break;
				default:
					break;
				}
			}
			return retValue;
		}
	}

}
