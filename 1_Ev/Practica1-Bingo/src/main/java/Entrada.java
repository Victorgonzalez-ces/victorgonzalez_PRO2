import logica.Bingo;
import model.Carton;
import model.Jugador;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = null;
        int o = 0;
        Bingo bingo = new Bingo();
        //menu
        do {
            scanner = new Scanner(System.in);
            System.out.println(" 1. Crear jugador: pidiendo los datos de nombre y saldo inicial\n" +
                    " 2. Comprar cartón: pidiendo dni y número de cartones a comprar \n" +
                    " 3. Iniciar juego \n" +
                    " 4. Salir");
            o = scanner.nextInt();
            switch (o){
                case 1:
                    System.out.println("ha elegido la opción crear nuevo jugador");
                    System.out.println("introduzca su nombre");
                    String nomb = scanner.next();
                    System.out.println("introduzca su dni");
                    String dni = scanner.next();
                    System.out.println("introduce su saldo a ingresar al juego");
                    int saldo = scanner.nextInt();
                    bingo.ingresarJugador(new Jugador(nomb,dni,saldo));
                    break;
                case 2:
                    System.out.println("ha elegido la opción comprar cartones");
                    System.out.println("introduzca su dni para comprar cartones");
                    dni = scanner.next();
                    System.out.println("introduzca el número de cartones que desea comprar");
                    int num = scanner.nextInt();
                    bingo.comprarCartones(dni,num);
                    break;
                case 3:
                    System.out.println("Iniciando juego...");
                    System.out.println("el jugador ganador es: "+bingo.iniciarJuego().getNombre());
                    break;
                case 4:
                    System.out.println("cerrando partida...");
                    break;
                default:
                    System.out.println("lo sentimos, introduzca un número válido");
            }
        }while(o!=4);
    }
}
