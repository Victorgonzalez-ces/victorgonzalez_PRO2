package logica;

import model.Carton;
import model.Jugador;

import java.util.ArrayList;

public class Bingo {

    private ArrayList<Jugador> jugadores;

    public Bingo() {
        jugadores = new ArrayList<>();
    }
    //metodo para ingresar jugador al juego
    public void ingresarJugador(Jugador jug){
        if (existeJugador(jug)){
            System.out.println("Lo sentimos el jugador ingresado ya existe");
        }else{
            jugadores.add(jug);
            System.out.println("jugador ingresado al juego");
        }
    }

    //metodo para saber si existe jugador ya en el juego
    public boolean existeJugador(Jugador jugador){
        for (Jugador item:jugadores) {
            if (item.getDni().equalsIgnoreCase(jugador.getDni())){
                return true;
            }
        }
        return false;
    }

    public void comprarCartones(String dn, int num){
        boolean aux = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getDni().equalsIgnoreCase(dn)){
                for (int j = 0; j < num; j++) {
                    if (jugadores.get(i).getCartera()>=1){
                        jugadores.get(i).getCartones().add(new Carton(i));
                        jugadores.get(i).setCartera(jugadores.get(i).getCartera()-1);
                        System.out.println("Carton "+(j+1)+" comprado");
                        aux = true;
                    }else{
                        aux = false;
                    }
                }
            }else{
                System.out.println("Lo sentimos, el dni del jugador ingresado no se encuentra en el sistema");
            }
        }
        if (!aux){
            System.out.println("Lo sentimos, no dispone de suficiente dinero para comprar más cartones");
        }
    }
    public Jugador iniciarJuego(){
        Carton cartonPremiado = new Carton(777);
        int contador = 0;
        boolean aux = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCartones().get(i).getNumeros()[i]==cartonPremiado.getNumeros()[i]){
                System.out.printf("Numero %d acertado en el cartón con id %d del jugador = %s",cartonPremiado.getNumeros()[i],jugadores.get(i).getCartones().get(i).getId(),jugadores.get(i).getNombre());
                contador++;
                if (contador==10){
                    aux=true;
                    return jugadores.get(i);
                }
            }
        }
        return null;
    }
}
