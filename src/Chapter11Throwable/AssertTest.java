package Chapter11Throwable;
/*
 * ����
 * */
public class AssertTest {
	public AssertTest(int i){
		//���������ͨ������������أ����е���ͨ��JVMֱ�Ӽ��أ�---------------����
		//���û����ʽ��˵�������Ķ���״̬���Ϳ������رգ�����
		//�����������ļ���-P496
		//this.getClass().getClassLoader().setDefaultAssertionStatus(true);
		
		//�������ö���֪�����------------------------�ҵ��죬����Ϊë��û�ã�����eclipse���л�����-ea
		this.getClass().getClassLoader().setPackageAssertionStatus("Chapter11", true);
		
		
		assert i>=0:"i>=0��������";
		if(i%3==0) System.out.println("ȡ��3Ϊ0");
		if(i%3==1) System.out.println("ȡ��3Ϊ1");
		if(i%3==2) System.out.println("ȡ��3Ϊ2");
	}
	
	public static void main(String[] args) {
		new AssertTest(-2);
	}
}
