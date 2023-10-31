package com.example.t3_listas;

import com.example.t3_listas.model.Pelicula;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private MenuItem itemAlerta;

    @FXML
    private RadioMenuItem radioMenuHab;
    @FXML
    private RadioMenuItem radioMenuDesHab;

    @FXML
    private MenuItem itemPregunta;

    @FXML
    private MenuItem itemSalir;

    @FXML
    private MenuItem itemSeleccion;

    @FXML
    private MenuItem itemSimple;

    @FXML
    private MenuItem itemTexto;

    @FXML
    private MenuItem itemWarning;

    @FXML
    private MenuItem itemPersonalizado;

    @FXML
    private GridPane parteCentral;

    private ToggleGroup grupoHabilitar;

    private DialogoPersoController dialogoPersoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarMenu();
        acciones();
    }

    private void personalizarMenu() {
        itemSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("out.png"))));
        itemSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        itemSalir.setMnemonicParsing(true);

    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem) t1).getText().equalsIgnoreCase("habilitar")) {
                    parteCentral.setDisable(false);
                } else {
                    parteCentral.setDisable(true);
                }
            }
        });
        itemSalir.setOnAction(this);
        itemSimple.setOnAction(this);
        itemAlerta.setOnAction(this);
        itemWarning.setOnAction(this);
        itemSeleccion.setOnAction(this);
        itemPregunta.setOnAction(this);
        itemTexto.setOnAction(this);
        itemPersonalizado.setOnAction(this);
    }

    private void instancias() {
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(radioMenuHab, radioMenuDesHab);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == itemSalir) {
            System.exit(0);
        } else if (actionEvent.getSource() == itemSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de confirmacién simple");
            alertSimple.show();
        } else if (actionEvent.getSource() == itemWarning) {
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de warning");
            alertSimple.show();
        } else if (actionEvent.getSource() == itemAlerta) {
            Alert alertSimple = new Alert(Alert.AlertType.ERROR);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de error");
            alertSimple.show();
        } else if (actionEvent.getSource() == itemPregunta) {
            Alert dialgoPregunta = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType botonUno = new ButtonType("Preguntar mas tarde");
            ButtonType botonDos = new ButtonType("Aplicar y esperar");
            //dialgoPregunta.getButtonTypes().addAll(botonUno,botonDos, ButtonType.APPLY);
            dialgoPregunta.getButtonTypes().setAll(botonUno, botonDos, ButtonType.APPLY);

            Optional<ButtonType> boton = dialgoPregunta.showAndWait();
            if (boton.get() == ButtonType.OK) {
                System.out.println("Pulsado ok");
            } else if (boton.get() == ButtonType.CANCEL) {
                System.out.println("Pulsado cancelar");
            } else if (boton.get() == botonUno) {
                System.out.println("Pulsado boton uno");
            } else if (boton.get() == ButtonType.APPLY) {
                System.out.println("Pulsado aplicar");
            }

        } else if (actionEvent.getSource() == itemSeleccion) {
            // elemento seleccionado, lista
            ObservableList<Pelicula> listaOpcionesObservable
                    = FXCollections.observableArrayList();
            //listaOpcionesObservable.addAll("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4");
            listaOpcionesObservable.addAll(new Pelicula("Titulo 1", "Genero 1", 1233)
                    , new Pelicula("Titulo 1", "Genero 1", 1233));
            ChoiceDialog<Pelicula> dialogChoice = new ChoiceDialog<>(listaOpcionesObservable.get(0)
                    , listaOpcionesObservable);
            Optional<Pelicula> respuesta = dialogChoice.showAndWait();

            if (respuesta.isPresent()) {
                System.out.println(respuesta.get().getGenero());
            } else {
                Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
                alertaWarning.setHeaderText("Por favor introduce seleccion");
                alertaWarning.show();
            }
        } else if (actionEvent.getSource() == itemTexto) {
            TextInputDialog dialogoTexto = new TextInputDialog("Por favor introduce dato");
            Optional<String> respuesta = dialogoTexto.showAndWait();
            if (respuesta.isPresent()){
                if (!respuesta.get().isEmpty()){
                    System.out.println(respuesta.get());
                } else {
                    System.out.println("Introducidos datos vacios");
                }
            } else {
                System.out.println("Np hay datos");
            }

        } else if (actionEvent.getSource() == itemPersonalizado) {
            Dialog<Pelicula> dialogoPerso = new Dialog();
            dialogoPerso.setTitle("Cuadro personalizado");
            // VBOX
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogos-view.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                dialogoPersoController = loader.getController();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialogoPerso.getDialogPane().setContent(root);
            dialogoPerso.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CLOSE);
            dialogoPerso.setResultConverter(new Callback<ButtonType, Pelicula>() {
                @Override
                public Pelicula call(ButtonType buttonType) {
                    if (buttonType == ButtonType.APPLY) {
                        if (dialogoPersoController.isPelicula()){
                            return dialogoPersoController.getPelicula();
                        }
                    }
                    return null;
                }
            });
            Optional<Pelicula> respuesta =  dialogoPerso.showAndWait();
            System.out.println(respuesta.get().getTitulo());

        }

    }
}

