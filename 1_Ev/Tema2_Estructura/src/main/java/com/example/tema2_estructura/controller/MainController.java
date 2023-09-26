package com.example.tema2_estructura.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonPulsar;
    @FXML
    private Button botonSacar;
    @FXML
    private TextField textoNombre;
    @FXML
    private Label texto1;
    private ArrayList<String> personas;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        //se ejecuta cuando se ejecuta el loader.load()
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = textoNombre.getText();
                if (textoNombre.getText().length()>0){
                    personas.add(textoNombre.getText());
                    textoNombre.clear();
                }else{
                    texto1.setText("Porfavor introduzca algun dato");
                }
            }
        });

        botonSacar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (personas.size()==0){
                    texto1.setText("No hay usuarios");
                }else{
                    int random = (int)(Math.random()*personas.size());
                    texto1.setText("El usuario seleccionado es: "+ personas.get(random));
                }
            }
        });
    }
    public void instancias(){
        personas = new ArrayList<>();
    }
}
