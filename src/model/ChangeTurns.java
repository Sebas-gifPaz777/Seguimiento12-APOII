package model;

public class ChangeTurns {
	
	public Turn first;
	public Turn last;
	public Turn temp;

	public boolean giveTurn(int turn) { 
	
		if(first==null) {
			first=new Turn(turn);
			last=first;
			first.setNext(first);
			first.setBack(first);
			temp=first;
		}	
		else {
			last.setNext(new Turn(turn));
			last.getNext().setNext(first);
			last.getNext().setBack(last);
			last=last.getNext();
			first.setBack(last);
		}
		return true;
		
	}

	public void showTurn() {
		if(temp==null) {
			System.out.println("No hay turnos por mostrar");
			System.out.println("");
		}
		else
			System.out.println(temp.getNum());
		
	}

	public void nextTurn() {
		if(temp.getTimes()==3)
			deleteTurn();
		else {
			temp.setTimes(1);
			temp=temp.getNext();
		}
			
		
	}

	public void deleteTurn() {
		if(temp.getNext()==temp) {
			first=null;
			temp=first;
			last=first;
		}
		else {
			temp.getBack().setNext(temp.getNext());
			temp.getNext().setBack(temp.getBack());
			temp=temp.getNext();
		}
	}

}
