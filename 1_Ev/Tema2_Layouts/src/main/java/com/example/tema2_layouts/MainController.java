package com.example.tema2_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private BorderPane borderGeneral;

    @FXML
    private Button botonIzquierda;

    @FXML
    private Button botonCentro;

    @FXML
    private Button botonDerecha;

    @FXML
    private HBox parteIzquierda;

    @FXML
    private HBox parteDerecha;

    @FXML
    private HBox parteSuperior;

    @FXML
    private GridPane parteInferior;
    private DropShadow dp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borderGeneral.setLeft(null);
        personalizarBotones();
        acciones();
        instancias();
    }

    private void acciones() {
        botonIzquierda.setOnAction(this);
        botonCentro.setOnAction(this);
        botonDerecha.setOnAction(this);
        botonIzquierda.setOnMouseEntered(new manejoRaton());
        botonIzquierda.setOnMouseExited(new manejoRaton());
        botonDerecha.setOnMouseEntered(new manejoRaton());
        botonDerecha.setOnMouseExited(new manejoRaton());
        botonCentro.setOnMouseEntered(new manejoRaton());
        botonCentro.setOnMouseExited(new manejoRaton());
    }

    private void personalizarBotones() {

        //boton izquierdo
        cambiarBoton(botonIzquierda, "flecha-izquierda.png");
        botonIzquierda.setEffect(instancias());
        //boton centro
        cambiarBoton(botonCentro, "flecha-hacia-arriba.png");
        botonCentro.setEffect(instancias());
        //boton derecho
        cambiarBoton(botonDerecha, "flecha-correcta.png");
        botonDerecha.setEffect(instancias());
    }

    private void cambiarBoton(Button boton, String image) {
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(image))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonCentro) {
            if (borderGeneral.getCenter() == null){
                borderGeneral.setCenter(parteSuperior);
            }else{
                borderGeneral.setCenter(parteSuperior);
            }
        } else if (actionEvent.getSource() == botonDerecha) {
            System.out.println("Pulsado boton derecha");
            if (borderGeneral.getRight() == null) {
                borderGeneral.setRight(parteDerecha);
            }else{
                borderGeneral.setRight(parteDerecha);
            }
        } else if (actionEvent.getSource() == botonIzquierda) {
            if (borderGeneral.getLeft() == null) {
                borderGeneral.setLeft(parteIzquierda);
            }else {
                borderGeneral.setLeft(null);
            }
        }




    }
    private DropShadow instancias(){
        dp = new DropShadow();
        return dp;
    }

    public class manejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if((Button)(mouseEvent.getSource()) == null){

            }
        }
    }
}