package date_time;

import java.util.Calendar;
import java.util.TimeZone;

public class MyDate {
    public static void main(String[] args){

        Calendar calendar = Calendar.getInstance();//获取当前系统时间的calendar对象
        System.out.println("calendar对象："+calendar);
        //java.util.GregorianCalendar[time=1555595923447,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="GMT+08:00",offset=28800000,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=3,WEEK_OF_YEAR=16,WEEK_OF_MONTH=3,DAY_OF_MONTH=18,DAY_OF_YEAR=108,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=9,HOUR_OF_DAY=21,MINUTE=58,SECOND=43,MILLISECOND=447,ZONE_OFFSET=28800000,DST_OFFSET=0]
        //java.util.GregorianCalendar[name=value,name=value,...]  Jason串

        calendar.set(Calendar.YEAR,2015);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONDAY);//从0开始数的
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("年："+year);
        System.out.println("月："+month);
        System.out.println("日："+day);

        TimeZone td1 = TimeZone.getDefault();
        System.out.println(td1.getID()+"—"+td1.getDisplayName());

        TimeZone td = calendar.getTimeZone();
        System.out.println(td.getID()+"—"+td.getDisplayName());




    }

}
