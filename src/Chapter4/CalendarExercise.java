package Chapter4;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
 * 2017/1/16
 * 输出当前月份的日历
 * */

public class CalendarExercise {
	public void getCalendar(){
		//对象构造时的年月日
		GregorianCalendar d=new GregorianCalendar();
		System.out.println("现在是"+d.get(Calendar.YEAR)+"/"+d.get(Calendar.MONTH)+1+"/"+d.get(Calendar.DAY_OF_MONTH));
		int today=d.get(Calendar.DAY_OF_MONTH);
		int month=d.get(Calendar.MONTH);
		
		//将d设置为这个月的第一天
		d.set(Calendar.DAY_OF_MONTH,1);
		//得到这一天是星期几
		int weekday=d.get(Calendar.DAY_OF_WEEK);
		
		//设置不同地区的显示
		Locale.setDefault(Locale.US);
		//得到当前地区星期一的起始日
		int firstDayOfWeek=d.getFirstDayOfWeek();
		int intent=0;
		while(weekday!=firstDayOfWeek){
			intent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		
		//输出表示星期几名称的前几个字母
		String weekDayNames[]=new DateFormatSymbols().getShortWeekdays();
		do{
			System.out.printf("%4s",weekDayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}while(weekday!=firstDayOfWeek);
		System.out.println();
		
		//打印空格
		for(int i=0;i<intent;i++){
			System.out.println("    ");
		}
		
		d.set(Calendar.DAY_OF_MONTH,1);
		//输出日期 
		do{
			int day=d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);
			
			if(day==today){
				System.out.print("*");
			}else{
				System.out.print(" ");
			}
			
			//日期加一
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
			
			//换行
			if(weekday==firstDayOfWeek){
				System.out.println();
			}
				
		}while(d.get(Calendar.MONTH)==month);
		
		if(weekday!=firstDayOfWeek){
			System.out.println();
		}
	}
}
