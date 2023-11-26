package com.example.practicajson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPersoController implements Initializable {

    @FXML
    private TextField textFieldNombre, textFieldPass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Parte grafica");
    }
    public boolean isLiga(){
        if (textFieldNombre.getText().isEmpty() || textFieldPass.getText().isEmpty()){
            return false;
        }
        return true;
    }
    public LigasJSON getLiga(){
        return new LigasJSON(textFieldNombre.getText(),"ejemplo");
    }


}