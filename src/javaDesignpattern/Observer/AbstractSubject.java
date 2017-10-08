package javaDesignpattern.Observer;

import java.util.Vector;

public abstract class AbstractSubject implements Subject{
	private Vector<Observer> observers=new Vector<>();
	
	@Override
	public void add(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	//通知所有的观察者
	public void notifyAllObservers() {
		for(Observer observer:observers){
			
			observer.update();
		}
	}

}
