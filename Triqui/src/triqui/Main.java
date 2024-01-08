package triqui;

import java.util.Scanner;

public class Main { 
    
    public static void main(String args[]){
        //Creando un objeto tipo Scanner para leer
        Scanner inMain = new Scanner(System.in);
        
        //Declarando variables
        Boolean flagEleccion = false;
        int CRC = 0;
        
        //Inicio
        
        flagEleccion = true;
        while(flagEleccion){
        	borrarPantalla();
            System.out.println("----------------");
            System.out.println("-CHIQUISTRIQUIS-");
            System.out.println("----------------");
            System.out.println("1. Para comenzar");
            System.out.println("2. Para las reglas");
            System.out.println("3. Para cerrar");
            
            //Leer opción
            CRC = inMain.nextInt();
            
            //Elección de opción
            switch(CRC){
                case 1:
                	iniciarTriqui();
                    break;
                case 2:
                    mostrarReglas();
                    break;
                case 3:
                	System.out.println("Cerrado");
                	System.exit(0);
                    break;
                default:
                    System.out.println(" ");
                    break;
            }
        }
    }
    
  //Triqui
    static String matrizTriqui[][] = new String[3][3];
    
    public static void iniciarTriqui() {
    	Scanner inTriqui = new Scanner(System.in);
    	Boolean flagEleccionPunto = false, flagRepetirTriqui = false, ganadorOEmpate = false;
    	String turn = "-", Ganador = "-", GanadorG = "-";
    	int eleccionPunto = 0, acumuladorSeguirJugando = 0, seguirJugando = 0;
    	int T[] = new int[9];

    	flagRepetirTriqui = true;
    	while(flagRepetirTriqui) {
    		ganadorOEmpate = false;
    		for(int i = 0; i < 3; i++) {
        		for(int j = 0; j < 3; j++) {
        			matrizTriqui[i][j] = "-";
        		}
        	}
    		for(int i = 0; i < 9; i++) {
    			T[i] = 0;
    		}
        	for(int i = 1; i < 10; i++) {
        		if(i % 2 == 1) {
        			turn = "X";
        		}else {
        			turn = "O";
        		}
        		acumuladorSeguirJugando = 0;
        		for(int il = 1; il < 3; il++) {
        			if(il % 2 == 1) {
        				Ganador = "X";
        			}else {
        				Ganador = "O";
        			}
        			
        			//Posiciones
        			if(matrizTriqui[0][0] == Ganador & matrizTriqui[1][0] == Ganador & matrizTriqui[2][0] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[0][1] == Ganador & matrizTriqui[1][1] == Ganador & matrizTriqui[2][1] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[0][2] == Ganador & matrizTriqui[1][2] == Ganador & matrizTriqui[2][2] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[0][2] == Ganador & matrizTriqui[1][1] == Ganador & matrizTriqui[2][0] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[0][0] == Ganador & matrizTriqui[0][1] == Ganador & matrizTriqui[0][2] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[1][0] == Ganador & matrizTriqui[1][1] == Ganador & matrizTriqui[1][2] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[2][0] == Ganador & matrizTriqui[2][1] == Ganador & matrizTriqui[2][2] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else if(matrizTriqui[0][0] == Ganador & matrizTriqui[1][0] == Ganador & matrizTriqui[2][0] == Ganador) {
        				ganadorOEmpate = true;
        				GanadorG = Ganador;
        			}else {
        				acumuladorSeguirJugando += 1;
        			}
        		}
        		
        		if(acumuladorSeguirJugando == 2) {
        			borrarPantalla();
        			System.out.println("TURNO DEL JUGADOR " + turn);
        			mostrarTriqui();
            		eleccionPunto = inTriqui.nextInt();
            		
        			flagEleccionPunto = true;
        			while(flagEleccionPunto) {
        				if(eleccionPunto < 1 | eleccionPunto > 9 | eleccionPunto == T[0] | eleccionPunto == T[1] | eleccionPunto == T[2] | eleccionPunto == T[3] | eleccionPunto == T[4] | eleccionPunto == T[5] | eleccionPunto == T[6]  | eleccionPunto == T[7] | eleccionPunto == T[8]) {
        					borrarPantalla();
        					System.out.println("TURNO DEL JUGADOR " + turn);
        					mostrarTriqui();
        					eleccionPunto = inTriqui.nextInt();
        				}else {
        					flagEleccionPunto = false;
        				}
        			}
        			
        			switch(eleccionPunto) {
        			case 1:
        				T[0] = 1;
        				matrizTriqui[0][0] = turn;
        				break;
        			case 2:
        				T[1] = 2;
        				matrizTriqui[0][1] = turn;
        				break;
        			case 3:
        				T[2] = 3;
        				matrizTriqui[0][2] = turn;
        				break;
        			case 4:
        				T[3] = 4;
        				matrizTriqui[1][0] = turn;
        				break;
        			case 5:
        				T[4] = 5;
        				matrizTriqui[1][1] = turn;
        				break;
        			case 6:
        				T[5] = 6;
        				matrizTriqui[1][2] = turn;
        				break;
        			case 7:
        				T[6] = 7;
        				matrizTriqui[2][0] = turn;
        				break;
        			case 8:
        				T[7] = 8;
        				matrizTriqui[2][1] = turn;
        				break;
        			case 9:
        				T[8] = 9;
        				matrizTriqui[2][2] = turn;
        				break;
        			}
        		}
        	}
        	borrarPantalla();
        	System.out.println("-----------------" + "\n" + "Fin de la partida" + "\n" + "-----------------");
        	mostrarTriqui();
        	System.out.println(" ");
        	if(ganadorOEmpate) {
        		System.out.println("El ganador fue el jugador " + GanadorG);
        	}else {
        		System.out.println("Empate");
        	}
        	System.out.println("¿Quieres seguir jugando?" + "\n" + "1. Para seguir jugando" + "\n" + "2. Para salir");
        	seguirJugando = inTriqui.nextInt();
        	switch(seguirJugando) {
        	case 1:
        		flagRepetirTriqui = true;
        		break;
        	case 2:
        		System.out.println("Cerraste");
        		System.exit(0);
        		break;
        	default:
        		System.out.println("Cerraste");
        		System.exit(0);
        		break;
        	}
    	}
    }
    
    public static void mostrarTriqui() {
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			System.out.print("| " + matrizTriqui[i][j] + " |");
    		}
    		System.out.println(" ");
    	}
    }
    
    //Reglas triqui
    public static void mostrarReglas(){
        
        Scanner inReglas = new Scanner(System.in);
        
        int matrizReglas[][] = new int[3][3];
        int acumuladorReglas = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                acumuladorReglas++;
                matrizReglas[i][j] = acumuladorReglas;
            }
        }
        
        System.out.println("-----------------------");
        System.out.println("-REGLAS CHIQUISTRIQUIS-");
        System.out.println("-----------------------");
        System.out.println("Siempre comenzara el turno el Jugador X");
        System.out.println("Dependiendo de donde quieras colocar tu turno deberás de usar números como en el siguiente ejemplo");
        System.out.println("No puedes colocar un turno en una casilla ya utilizada");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("| " + matrizReglas[i][j] + " |");
            }
            System.out.println(" ");
        }
        System.out.print("Enter para continuar: ");
        String enterReglas = inReglas.nextLine();
    }
    
    //borrarPantalla() colocará 50 lineas en blanco
    public static void borrarPantalla() {
    	for(int i = 1; i <= 50; i++) {
    		System.out.println(" ");
    	}
    }
}