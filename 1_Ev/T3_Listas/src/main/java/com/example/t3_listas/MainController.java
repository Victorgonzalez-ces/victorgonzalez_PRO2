package com.example.t3_listas;

import com.example.t3_listas.model.Pelicula;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.Optional;
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
        itemPregunta.setOnAction(this);
        itemWarning.setOnAction(this);
        itemSeleccion.setOnAction(this);
        itemTexto.setOnAction(this);
    }

    private void instancias(){
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(radioMenuHab,radioMenuDesHab);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==itemSalir){
            System.exit(0);
        } else if (actionEvent.getSource() == itemPregunta) {
            Alert dialogoPregunta = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType botonUno = new ButtonType("preguntar mas tarde");
            ButtonType botondos = new ButtonType("aplicar y esperar");
            dialogoPregunta.getButtonTypes().setAll(botonUno,botondos);
            Optional<ButtonType> boton = dialogoPregunta.showAndWait();
            if(boton.get()==botonUno){
                System.out.println("pulsado boton 1");
            } else if (boton.get() == botondos) {
                System.out.println("pulsado boton 2");
            }
        } else if (actionEvent.getSource() == itemSeleccion) {
            ArrayList<String> listaOpciones = new ArrayList<>();
            ObservableList<Pelicula> listaOpcionesObservable = FXCollections.observableArrayList();
            listaOpcionesObservable.addAll(new Pelicula("Titulo 1","Genero 1",1232),
                    new Pelicula("Titulo 2","Genero 2",1442));
            ChoiceDialog<Pelicula> dialogChoice = new ChoiceDialog<>(listaOpcionesObservable.get(0),listaOpcionesObservable);
            Optional<Pelicula> respuesta = dialogChoice.showAndWait();
            if (!respuesta.isPresent()){
                System.out.println(respuesta.get().getGenero());
            }else{
                Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
                alertaWarning.setHeaderText("Por favor introduce seleccion");
                alertaWarning.show();
            }
        } else if (actionEvent.getSource() == itemTexto) {
            TextInputDialog dialgoTexto = new TextInputDialog("Por favor introduce un dato");
            Optional<String> respuesta = dialgoTexto.showAndWait();

            if (respuesta.isPresent()){
                if (!respuesta.get().isEmpty()){
                    System.out.println(respuesta.get());
                }else{
                    System.out.println("Introducidos datos vacios");
                }
            }else{
                System.out.println("No hay datos");
            }
        }
    }


}