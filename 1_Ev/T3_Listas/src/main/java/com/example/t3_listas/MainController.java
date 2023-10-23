package com.example.t3_listas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private MenuItem itemSalir;

    @FXML
    private RadioMenuItem radioMenuHab;

    @FXML
    private RadioMenuItem radioMenuDesHab;

    @FXML
    private MenuItem itemSimple;

    @FXML
    private MenuItem itemAlerta;

    @FXML
    private MenuItem itemWarning;

    @FXML
    private MenuItem itemPregunta;

    @FXML
    private MenuItem itemTexto;

    @FXML
    private MenuItem itemSeleccion;

    @FXML
    private GridPane parteCentral;

    private ToggleGroup grupoHabilitar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarMenu();
        acciones();
    }

    private void personalizarMenu() {
        itemSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("out.png"))));
        itemSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.CONTROL_DOWN));
        itemSalir.setMnemonicParsing(true);
    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println();
                if (((RadioMenuItem)t1).getText().equalsIgnoreCase("habilitar")){
                    parteCentral.setDisable(false);
                }else{
                    parteCentral.setDisable(true);
                }
            }
        });
        itemSalir.setOnAction(this);
    }

    private void instancias(){
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(radioMenuHab,radioMenuDesHab);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==itemSalir){
            System.exit(0);
        }
    }
}