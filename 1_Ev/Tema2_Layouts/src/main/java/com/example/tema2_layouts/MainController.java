package com.example.tema2_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        personalizarBotones();
        acciones();
    }

    private void acciones() {
        botonIzquierda.setOnAction(this);
        botonCentro.setOnAction(this);
        botonDerecha.setOnAction(this);
        botonIzquierda.setOnMouseEntered(this);
    }

    private void personalizarBotones() {
        //boton izquierdo
        cambiarBoton(botonIzquierda,"flecha-izquierda.png");
        //boton centro
        cambiarBoton(botonCentro,"flecha-hacia-arriba.png");
        //boton derecho
        cambiarBoton(botonDerecha,"flecha-correcta.png");
    }

    private void cambiarBoton(Button boton, String image){
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(image))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("boton pulsado");
    }

}