package model;

public class Turn {
	
	private int num;
	private int times;
	private Turn back;
	private Turn next;
	
	public Turn(int num) {
		this.num=num;
		times=0;
		
	}

	public int getTimes() {
		return times;
	}

	public int getNum() {
		return num;
	}
	
	public Turn getNext() {
		return next;
	}
	
	public void setNext(Turn newNode) {
		next=newNode;
	}
	
	public Turn getBack() {
		return back;
	}
	
	public void setBack(Turn newNode) {
		back=newNode;
	}
	public boolean addNode(int turn, Turn first) {
		
		if(next==first) {
			next= new Turn(turn);
			next.setNext(first);
			return true;
		}
		else
			return next.addNode(turn, first);
	}
	
	public void setTimes(int time) {
		times+=time;
	}
		
}
