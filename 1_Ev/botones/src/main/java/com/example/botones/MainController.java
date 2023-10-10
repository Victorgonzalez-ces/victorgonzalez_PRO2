package com.example.botones;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Tab botonesNormales;

    @FXML
    private Button botonGeneral;

    @FXML
    private Button botonImagen;

    @FXML
    private Button botonNormal;

    @FXML
    private Button botonURL;

    @FXML
    private Tab botonesCompuestos;

    @FXML
    private ToggleButton toggle1;

    @FXML
    private ToggleButton toggle2;

    @FXML
    private ToggleButton toggle3;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private RadioButton radiobutton1;

    @FXML
    private RadioButton radiobutton2;

    @FXML
    private RadioButton radiobutton3;

    @FXML
    private Button botonComprobar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        personalizarBotones();
    }

    private void acciones(){

        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonGeneral.setOnAction(this);
    }

    private void personalizarBotones(){
        botonImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("375.png"))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);


    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}

