package example.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDateDeal {

	public static void main(String[] args){
	//ʵ��һ��Date����date�����?ǰ��ϵͳʱ��(����) 
		Date date=new Date();
		System.out.println(date);
	//SimpleDateFormat������������ʱ���ʽ���ģ����������form������������ָ����ʱ���ʽ��ʽ��ʱ���,�ù��췽���Ĳ���Ϊ���õĸ�ʽ��ʱ��ĸ�ʽ
	//���õĸ�ʽ�У�ֻ����"A"~"z"��"a"~"z",�ı�����ʹ�õ���� (') ��������������н���
		SimpleDateFormat form1=new SimpleDateFormat("yyyy-MM-dd 'aa' HH:mm:ss");
		SimpleDateFormat form2=new SimpleDateFormat("�����ǽ���ĵ�DD��");
		SimpleDateFormat form3=new SimpleDateFormat("�����ǽ���MM�µĵ�W�ܵ�E");
	//form�����е�format()������������ȡ����ʱ�䰴����õĸ�ʽ��ʽ����format()������������ʽ��ʱ��ģ�
		String str1=form1.format(date);
		String str2=form2.format(date);
		String str3=form3.format(date);
		System.out.println("format1:"+str1);
		System.out.println("format2:"+str2);
		System.out.println("format3:"+str3);
		System.out.println("---------������Calendar���Ӧ��---------");
		
	//ѧ��ʹ��Calendar�࣬��ʵ�ʵ��д󲿷ֶ���ʹ��Calendar���������ڴ���
		Date dateCalendar=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(dateCalendar);
		System.out.println("ʹ��Calendar�������ڴ��?");
		System.out.println("������·�"+calendar.get(Calendar.MONTH));

		
	}
}
