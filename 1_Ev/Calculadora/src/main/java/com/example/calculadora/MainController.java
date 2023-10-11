package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private GridPane panelGeneral;
    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private Button boton3;

    @FXML
    private Button boton4;

    @FXML
    private Button boton5;

    @FXML
    private Button boton6;

    @FXML
    private Button boton7;

    @FXML
    private Button boton8;

    @FXML
    private Button boton9;

    @FXML
    private Button boton0;

    @FXML
    private Button botonMas;

    @FXML
    private Button botonMenos;

    @FXML
    private Button botonPor;

    @FXML
    private Button botonDividir;

    @FXML
    private Button botonIgual;

    @FXML
    private TextField textoCalculadora;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void acciones(){}
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==boton1 || actionEvent.getSource()==boton2){
            textoCalculadora.setText(((Button) (actionEvent.getSource())).getText());
        }
    }
}