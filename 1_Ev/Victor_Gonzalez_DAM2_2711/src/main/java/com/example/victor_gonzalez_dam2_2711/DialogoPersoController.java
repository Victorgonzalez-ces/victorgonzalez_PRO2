package com.example.victor_gonzalez_dam2_2711;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPersoController implements Initializable {

    @FXML
    private TextArea textoEquipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textoEquipo.appendText("");
    }
}
