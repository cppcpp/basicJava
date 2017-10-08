package Chapter4;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
 * 2017/1/16
 * �����ǰ�·ݵ�����
 * */

public class CalendarExercise {
	public void getCalendar(){
		//������ʱ��������
		GregorianCalendar d=new GregorianCalendar();
		System.out.println("������"+d.get(Calendar.YEAR)+"/"+d.get(Calendar.MONTH)+1+"/"+d.get(Calendar.DAY_OF_MONTH));
		int today=d.get(Calendar.DAY_OF_MONTH);
		int month=d.get(Calendar.MONTH);
		
		//��d����Ϊ����µĵ�һ��
		d.set(Calendar.DAY_OF_MONTH,1);
		//�õ���һ�������ڼ�
		int weekday=d.get(Calendar.DAY_OF_WEEK);
		
		//���ò�ͬ��������ʾ
		Locale.setDefault(Locale.US);
		//�õ���ǰ��������һ����ʼ��
		int firstDayOfWeek=d.getFirstDayOfWeek();
		int intent=0;
		while(weekday!=firstDayOfWeek){
			intent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		
		//�����ʾ���ڼ����Ƶ�ǰ������ĸ
		String weekDayNames[]=new DateFormatSymbols().getShortWeekdays();
		do{
			System.out.printf("%4s",weekDayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}while(weekday!=firstDayOfWeek);
		System.out.println();
		
		//��ӡ�ո�
		for(int i=0;i<intent;i++){
			System.out.println("    ");
		}
		
		d.set(Calendar.DAY_OF_MONTH,1);
		//������� 
		do{
			int day=d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);
			
			if(day==today){
				System.out.print("*");
			}else{
				System.out.print(" ");
			}
			
			//���ڼ�һ
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
			
			//����
			if(weekday==firstDayOfWeek){
				System.out.println();
			}
				
		}while(d.get(Calendar.MONTH)==month);
		
		if(weekday!=firstDayOfWeek){
			System.out.println();
		}
	}
}
