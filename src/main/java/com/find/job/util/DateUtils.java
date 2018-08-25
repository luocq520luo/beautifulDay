package com.find.job.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
    //测试pr
    static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public final static String MONDAY = "星期一";
    public final static String TUESDAY = "星期二";
    public final static String WEDNESDAY = "星期三";
    public final static String THURSDAY = "星期四";
    public final static String FRIDAY = "星期五";
    public final static String SATURDAY = "星期六";
    public final static String SUNDAY = "星期日";

    public final static String WEEK_MONDAY = "周一";
    public final static String WEEK_TUESDAY = "周二";
    public final static String WEEK_WEDNESDAY = "周三";
    public final static String WEEK_THURSDAY = "周四";
    public final static String WEEK_FRIDAY = "周五";
    public final static String WEEK_SATURDAY = "周六";
    public final static String WEEK_SUNDAY = "周日";

    public final static String ZERO = "0";
    public final static String FIRST = "1";
    public final static String SECOND = "2";
    public final static String THIRD = "3";
    public final static String FOURTH = "4";
    public final static String FIFTH = "5";
    public final static String SIXTH = "6";
    public final static String SEVENTH = "7";
    public final static String EIGHTH = "8";
    public final static String NINTH = "9";
    public final static String TENTH = "10";
    public final static String ELEVENTH = "11";
    public final static String TWELFTH = "12";
    public final static String THIRTEENTH = "13";
    public final static String FOURTEENTH = "14";
    public final static String FIFTEENTH = "15";

//    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//
//    private static final SimpleDateFormat curtimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//
//    private static final SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");


    public static Date getFirstDayOfWeek(Date today) {
        DateTime dateTime = new DateTime(today);
        dateTime = dateTime.withDayOfWeek(1);
        Date date = dateTime.toDate();
        date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
        return date;
    }

    public static Date getSubtractDate(Date subDate, Integer subtractHours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(subDate);
        calendar.set(Calendar.HOUR, subtractHours);
        return calendar.getTime();
    }

    public static Date getLastDayOfWeek(Date today) {
        DateTime dateTime = new DateTime(today);
        dateTime = dateTime.withDayOfWeek(7);
        Date date = dateTime.toDate();
        date = getEndOfDay(date);
        return date;
    }

    public static Date getEndOfDay(Date date) {
        return org.apache.commons.lang3.time.DateUtils.addMilliseconds(org.apache.commons.lang3.time.DateUtils.ceiling(date, Calendar.DATE), -1);
    }

    public static Date concatDateAndSqlTime(Date date, Time time) {
        if (date == null || time == null) {
            return null;
        }
        try {
            String dateTimeStr = DateFormatUtils.ISO_DATE_FORMAT.format(date) + DateFormatUtils.ISO_TIME_FORMAT.format(time);
            return DateFormatUtils.ISO_DATETIME_FORMAT.parse(dateTimeStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Time createSqlTime(Date date) {
        if (date == null) {
            return null;
        }
        return Time.valueOf(DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(date));
    }

    public static boolean equals(Date d1, Date d2) {
        if (d1 == d2) {
            return true;
        }
        if (d1 != null && d2 != null) {
            return d1.getTime() == d2.getTime();
        }
        return false;
    }

    public static boolean greatEquals(Date d1, Date d2) {
        if (d1 == d2) {
            return true;
        }
        if (d1 != null && d2 != null) {
            return d1.getTime() >= d2.getTime();
        }
        return false;
    }

    public static boolean great(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() > d2.getTime();
        }
        return false;
    }

    public static boolean lessEquals(Date d1, Date d2) {
        if (d1 == d2) {
            return true;
        }
        if (d1 != null && d2 != null) {
            return d1.getTime() <= d2.getTime();
        }
        return false;
    }

    public static boolean less(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() < d2.getTime();
        }
        return false;
    }

    public static long dateDiffInMinutes(Date d1, Date d2) {
        int factor = 1000 * 60;
        return (d1.getTime() - d2.getTime() + 1000) / factor;
    }

    public static long dateDiffInSeconds(Date d1, Date d2) {
        int factor = 1000;
        return (d1.getTime() - d2.getTime() + 1000) / factor;
    }

    public static long dateDiffInHours(Date d1, Date d2) {
        int factor = 1000 * 60 * 60;
        return (d1.getTime() - d2.getTime() + 1000) / factor;
    }

    public static long dateDiffInDays(Date d1, Date d2) {
        int factor = 1000 * 60 * 60 * 24;
        return (d1.getTime() - d2.getTime() + 1000) / factor;
    }

    public static int getWeekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        return weekOfMonth;
    }

    public static int getMothOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public static String getStringNow() {
        Date now = org.apache.commons.lang3.time.DateUtils.truncate(new Date(), Calendar.HOUR);
        String strNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
        return strNow;
    }

    /**
     * 获得当前日期时间
     * <p/>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String currentDatetime() {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return datetimeFormat.format(new Date());
    }

    /**
     * 格式化日期时间
     * <p/>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String formatDatetime(Date date) {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return datetimeFormat.format(date);
    }

    /**
     * 获得当前日期
     * <p/>
     * 日期格式yyyy-MM-dd
     *
     * @return
     */
    public static String currentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    /**
     * 格式化日期
     * <p/>
     * 日期格式yyyy-MM-dd
     *
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * 格式化日期
     * <p/>
     * 日期格式yyyy/MM/dd
     *
     * @return
     */
    public static String formatDateSlashSplit(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    /**
     * 获得当前时间
     * <p/>
     * 时间格式HH:mm:ss
     *
     * @return
     */
    public static String currentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }

    /**
     * 格式化时间
     * <p/>
     * 时间格式HH:mm:ss
     *
     * @return
     */
    public static String formatTime(Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(date);
    }

    /**
     * 格式化时间
     * <p/>
     * 时间格式HH:mm
     *
     * @return
     */
    public static String formatHourMinute(Date date) {
        SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");
        return hourMinuteFormat.format(date);
    }


    /**
     * 将字符串日期时间转换成java.util.Date类型
     * <p/>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     *
     * @param datetime
     * @return
     */
    public static Date parseDatetime(String datetime) throws ParseException {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return datetimeFormat.parse(datetime);
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p/>
     * 日期时间格式yyyy-MM-dd
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(date);
    }


    /**
     * 将字符串日期转换成java.util.Date类型
     * <p/>
     * 时间格式 HH:mm:ss
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseTime(String time) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.parse(time);
    }

    public static String currentTimeStr() {
        SimpleDateFormat curtimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return curtimeFormat.format(new Date());
    }

    /**
     * 获取日期当月的第一天日期
     * <p/>
     * 时间格式 yyyy-MM-dd
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfMonthFromStrDate(String date) {
        return date.substring(0, 8) + "01";
    }

    /**
     * 得到两个日期之间相差的天数
     *
     * @param newDate 大的日期
     * @param oldDate 小的日期
     * @return newDate-oldDate相差的天数
     */
    public static int daysBetweenDates(Date newDate, Date oldDate) {
        int days = 0;
        Calendar calendarOld = Calendar.getInstance();
        Calendar calendarNew = Calendar.getInstance();
        calendarOld.setTime(oldDate);
        calendarNew.setTime(newDate);
        int oldDay = calendarOld.get(Calendar.DAY_OF_YEAR);
        int newYear = calendarNew.get(Calendar.YEAR);
        int oldYear = calendarOld.get(Calendar.YEAR);
        while (newYear > oldYear) {
            calendarOld.set(Calendar.MONTH, 11);
            calendarOld.set(Calendar.DATE, 31);
            days = days + calendarOld.get(Calendar.DAY_OF_YEAR);
            oldYear = oldYear + 1;
            calendarOld.set(Calendar.YEAR, oldYear);
        }
        int newDay = calendarNew.get(Calendar.DAY_OF_YEAR);
        days = days + newDay - oldDay;
        return days;
    }

    public static String getWeek(Date date) {
        String[] weeks = {DateUtils.SUNDAY, DateUtils.MONDAY, DateUtils.TUESDAY, DateUtils.WEDNESDAY, DateUtils.THURSDAY, DateUtils.FRIDAY, DateUtils.SATURDAY};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    public static boolean isDayOff(Date day) {
        boolean flag = false;
        String week = DateUtils.getWeek(day);
        if (week.equals(DateUtils.SATURDAY) || week.equals(DateUtils.SUNDAY)) {
            flag = true;
        }
        return flag;
    }

    public static String getWeekDay(Date date) {
        String[] weeks = {DateUtils.WEEK_SUNDAY, DateUtils.WEEK_MONDAY, DateUtils.WEEK_TUESDAY, DateUtils.WEEK_WEDNESDAY, DateUtils.WEEK_THURSDAY, DateUtils.WEEK_FRIDAY, DateUtils.WEEK_SATURDAY};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 对象转日期时间
     *
     * @param object
     * @return
     */
    public static Date string2Datetime(Object object) {
        Date datetime = null;
        try {
            if (object == null || "".equals(object)) {
                return null;
            }
            datetime = parseDatetime(object.toString());
        } catch (ParseException e) {
            throw new RuntimeException("Invalid time format.", e);
        }
        return datetime;
    }

    /**
     * 对象转日期
     *
     * @param object
     * @return
     */
    public static Date string2Date(Object object) {
        Date datetime = null;
        try {
            if (object == null || "".equals(object)) {
                return null;
            }
            datetime = parseDate(object.toString());
        } catch (ParseException e) {
            throw new RuntimeException("Invalid time format.", e);
        }
        return datetime;
    }

    /**
     * 日期格式转字符串
     *
     * @param datetime 日期时间
     * @param type     转换的格式
     * @return
     */
    public static String datetime2String(Date datetime, String type) {
        String formatResult = null;
        if (datetime == null) {
            return null;
        }
        if ("yyyy-MM-dd".equals(type)) {
            formatResult = formatDate(datetime);
        } else if ("yyyy-MM-dd HH:mm:ss".equals(type)) {
            formatResult = formatDatetime(datetime);
        } else if ("HH:mm:ss".equals(type)) {
            formatResult = formatTime(datetime);
        } else if ("HH:mm".equals(type)) {
            formatResult = formatHourMinute(datetime);
        }
        return formatResult;
    }

    public static List<Date> getDateIntervalOfDates(Date beginDate, Date endDate) {
        List<Date> allDate = new ArrayList<Date>();
        if (null != beginDate && null != endDate) {
            if (beginDate.before(endDate)) {
                allDate.add(beginDate);
                Calendar cal = Calendar.getInstance();
                boolean isContinue = true;
                cal.setTime(beginDate);
                while (isContinue) {
                    if (cal.getTime().before(endDate)) {
                        cal.add(Calendar.DATE, 1);
                        allDate.add(cal.getTime());
                    } else {
                        break;
                    }
                }
            } else if (beginDate.equals(endDate)) {
                allDate.add(beginDate);
            } else {
                logger.error("getDateIntervalRecord >>>>> begin date bigger than end date");
            }

        }
        return allDate;
    }

    /**
     * 获取两个时间段交集
     *
     * @return
     */
    public static Interval intersection(Date innerStartDateTime, Date innerEndDateTime, Date outerOnDutyDateTime, Date outerOffDutyDateTime) {
        Interval holidayOvertimeInterval = null;
        if (greatEquals(outerOnDutyDateTime, innerEndDateTime) || greatEquals(innerStartDateTime, outerOffDutyDateTime)) {
            return null;
        }
        if (greatEquals(outerOnDutyDateTime, innerStartDateTime) && greatEquals(innerEndDateTime, outerOffDutyDateTime)) {
            if (outerOnDutyDateTime.before(outerOffDutyDateTime)) {
                holidayOvertimeInterval = new Interval(new DateTime(outerOnDutyDateTime), new DateTime(outerOffDutyDateTime));
            }
        } else if (greatEquals(innerStartDateTime, outerOnDutyDateTime) && greatEquals(outerOffDutyDateTime, innerEndDateTime)) {
            if (innerStartDateTime.before(innerEndDateTime)) {
                holidayOvertimeInterval = new Interval(new DateTime(innerStartDateTime), new DateTime
                        (innerEndDateTime));
            }
        } else if (greatEquals(outerOnDutyDateTime, innerStartDateTime) && greatEquals(innerEndDateTime
                , outerOnDutyDateTime)) {
            if (outerOnDutyDateTime.before(innerEndDateTime)) {
                holidayOvertimeInterval = new Interval(new DateTime(outerOnDutyDateTime), new DateTime
                        (innerEndDateTime));
            }
        } else if (greatEquals(outerOffDutyDateTime, innerStartDateTime) && greatEquals(innerEndDateTime
                , outerOffDutyDateTime)) {
            if (innerStartDateTime.before(outerOffDutyDateTime)) {
                holidayOvertimeInterval = new Interval(new DateTime(innerStartDateTime), new DateTime
                        (outerOffDutyDateTime));
            }
        }
        if (null != holidayOvertimeInterval && holidayOvertimeInterval.toDuration().getStandardMinutes() <= 0) {
            holidayOvertimeInterval = null;
        }
        return holidayOvertimeInterval;
    }


    /**
     * 获取当日的开始时间
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当日的结束时间
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取当日的结束时间
     */
    public static Date getEndTimeOfDayWithoutMillisecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date newDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static Date newDate(int year, int month, int day, int hour, int mintues, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, mintues, seconds);
        return calendar.getTime();
    }

    public static Date getBeginDate() {
        String beginDateValue = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Date beginDate = new Date();
        try {
            beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(beginDateValue);
        } catch (ParseException e) {
            logger.error("dailyPaperNotify BeginDate error", e);
        }
        return beginDate;
    }

    public static Date getEndDate() {
        String endDateValue = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 23:59:59";
        Date endDate = new Date();
        try {
            endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDateValue);
        } catch (ParseException e) {
            logger.error("dailyPaperNotify EndDate error", e);
        }
        return endDate;
    }

    /**
     * 格式化时间
     * <p>
     * 时间格式MM月dd日
     *
     * @return
     */
    public static String formatMonthDay(Date date) {
        SimpleDateFormat monthDayFormat = new SimpleDateFormat("MM月dd日");
        return monthDayFormat.format(date);
    }

    public static Date addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}
