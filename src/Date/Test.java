package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 
 * java.util.Date
 * 
 * Calendar
 * */
public class Test {
	public static void main(String[] args) {
		
		Date date1=new Date();
		long now=System.currentTimeMillis();
		System.out.println("当前时间整数："+now);
		Date date2=new Date(now);
		
		System.out.println("返回格林威治的时间："+date2.toGMTString());
		//重新覆盖时间
		date2.setTime(232323232);
		//getTime返回整形的数
		System.out.println(date2.getTime());
		
		
		DateFormat dateFormat=new  SimpleDateFormat("yyyy-MM-dd hh-mm-ss,本年的第w周，本月的第W周");
		Date date=new Date(now);
		//Date--->String
		String string=dateFormat.format(date);
		System.out.println(string);
		
		try {
			//String-->Date
			Date date3=dateFormat.parse("2017-08-22 10-26-59,本年的第34周，本月的第4周");
			System.out.println(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Calendar calendar=new GregorianCalendar();
		calendar.set(2017, 3, 10);
		System.out.println("设置日历的年："+calendar.get(Calendar.YEAR));
		//覆盖
		calendar.setTime(new Date());
		Date date3=calendar.getTime();
		System.out.println(date3);
	}
}
