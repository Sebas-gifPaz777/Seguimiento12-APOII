package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.ChangeTurns;


public class Main {
	
	private static BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
	private static ChangeTurns ct= new ChangeTurns();
	private static  int numTurn=1;

	public static void main(String[]args) {
		
		try {
			menu();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void menu() throws IOException {
		boolean fin=false;
		
		while(!fin) {
			System.out.println("Escoja una opción:\n1:Dar turno\n2:Mostrar turno\n3:Pasar Turno\n4:Eliminar turno actual\n5:Salir");
			int ans=Integer.parseInt(br.readLine());
			
			switch(ans) {
			
			case 1:
				if(numTurn<=50) {
					boolean ok=ct.giveTurn(numTurn);
					numTurn++;
				}
				else
					System.out.println("No se puede agregar mas turnos");
			break;
			
			case 2:
				ct.showTurn();
			break;
			
			case 3:
				ct.nextTurn();
			break;
			
			case 4:
				ct.deleteTurn();
			break;
			
			case 5:
				fin=true;
			break;
			
			default:
				System.out.println("Esta opción no se encuentra vuelva a intentarlo");
			}
			//System.out.println("");
		}

	}
}
