package prec1;

public class Main {

	public static void main(String[] args) {
		Object obj = new Object();
		//obj �ν��Ͻ��� toString ��� ���
		//���� ȣ���ϳ� �ν��Ͻ� �̸��� �����ϳ� ����� ����
		
		System.out.println(obj.toString());
		System.out.println(obj);

		Integer i = 100;
		//toString�� ����� �����ϰ� �ִ� ��������
		//100�Դϴ�.
		System.out.println(i.toString());
		System.out.println(i);
		
		//���� Ŭ���� Ÿ���� ������ ������
		//���� Ŭ���� Ÿ���� �ν��Ͻ� ������ ������ �� �ִ�.
		Object str = "Hello World";
		//��¸� �� ���� ����ȯ ���� ����ص� �˴ϴ�.
		//toString()�� Object�� ������ �����Ƿ�
		//ȣ�� �� �� �ֱ� �����Դϴ�.
		System.out.println(str);
		//Object Ÿ���� ������ ����� ���� �����ϰ�� �Ʒ��� ���� ������ �ڷ������� ���� ����ȯ�ؼ� ���
		String ismi = (String)str;
		//for(int j=0;i<ismi.length(); j=j+1)
		
	}

}
