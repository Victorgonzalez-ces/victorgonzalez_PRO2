package com.example.tema2_layouts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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

    }
}