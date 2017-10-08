package Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import Chapter13ConnectionInterface.PriorityQueueTest;

public class PriprityQueueTest {
	
	public static void  printQueue(Queue queue){
		while(queue.peek()!=null)
			System.out.print(queue.remove()+"  ");
		System.out.println();
	}
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(2,34,7,9,3,65,86,45,2);
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(list);
		
		//为什么打印不一样？？？？？
		System.out.println(priorityQueue);
		PriprityQueueTest.printQueue(priorityQueue);
		
		//倒序
		PriorityQueue priorityQueue2=new PriorityQueue<>(list.size(), Collections.reverseOrder());
		priorityQueue2.addAll(list);
		PriprityQueueTest.printQueue(priorityQueue2);
		
	}
}
