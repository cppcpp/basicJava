package Chapter13ConnectionInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		//Map��ʵ������HashMap����TreeMap��HashMapЧ�ʽϸߣ��������Ҫ��˳����ʣ�����HashMap
		//Ͱ��С----��װ����
		Map<Integer,String> maps=new HashMap<>(3, (float) 0.75);
		maps.put(1, "tom");
		maps.put(2, "jack");
		maps.put(3, "alice");
		
		System.out.println(maps);
		//Iterator������Ŀ
		for(Map.Entry<Integer,String> entry:maps.entrySet()){
			Integer key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);
		}
		
		
		//LinkedHashMap---����ӳ���
		//ʵ�֡��������ʹ�á�ԭ��-----
		Map<String,String> cache=new LinkedHashMap<String,String>(128, 0.75F, true){
			
			//��д�˷���---ÿ����������trueʱ�������һ������Ŀ���Ӷ���ʱɾ��eldest��Ŀ
			protected boolean removeEldestEntry(Map.Entry<String, String> eldest){
				return size()>100;
			}
		};
		
		//ͬ����ͼ
		Map<String,String> synMap=Collections.synchronizedMap(new HashMap<String,String>());
		
		//����ʱ�������
		Map<String,String> checkedMap= Collections.checkedMap(new HashMap<>(), String.class,String.class);
		
		
	}
}
