package com.example.botones;

import com.example.botones.model.MetodoPago;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class MainController implements Initializable, EventHandler<ActionEvent>, ChangeListener<Toggle> {

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

    private ToggleGroup grupoToggle;

    private ToggleGroup grupoRadio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarGrupoToggle();
        acciones();
        personalizarBotones();
    }

    private void configurarGrupoToggle() {
        grupoToggle.getToggles().addAll(toggle2,toggle3);
        radiobutton1.setUserData(new MetodoPago(1,"Pago Tarjeta","Aceptadas: visa, mastercard, Tarjeta1"));
        radiobutton2.setUserData(new MetodoPago(2,"Pago Paypal","Login necesario en la plataforma"));
        radiobutton3.setUserData(new MetodoPago(3,"Pago Transferencia","Banco aceptado BBVA"));
        grupoRadio.getToggles().addAll(radiobutton1,radiobutton2,radiobutton3);
    }

    private void acciones(){
        grupoRadio.selectedToggleProperty().addListener(this);
        toggle1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean old, Boolean newValue) {
                if (newValue){
                    System.out.println("elemento seleccionado");
                }else{
                    System.out.println("elemento deseleccionado");
                }
            }
        });

        grupoToggle.selectedToggleProperty().addListener(this);
        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonGeneral.setOnAction(this);
        botonComprobar.setOnAction(this);
    }

    private void personalizarBotones(){
        String[] toggleUrl = new String[]{"https://cdn-icons-png.flaticon.com/512/443/443045.png","https://i.pinimg.com/originals/1c/ed/ec/1cedece6e9acb40aa238147139ee6e9e.png"};
        toggle1.setBackground(null);
        toggle1.setBorder(null);
        botonImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("375.png"))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);
        ImageView imageToggle = new ImageView();
        toggle1.setGraphic(imageToggle);
        imageToggle.imageProperty()
                .bind(Bindings.when(toggle1.selectedProperty())
                        .then(new Image(toggleUrl[1]))
                        .otherwise(new Image(toggleUrl[0])));


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar){
            System.out.println("Elemento seleccionado: ");
            System.out.println(((ToggleButton)grupoToggle.getSelectedToggle()).getText());
            grupoRadio.selectToggle(null);
        }else{
            System.out.println("No hay seleccion en el grupo");
        }
    }
    private void instancias(){
        grupoToggle = new ToggleGroup();
        grupoRadio = new ToggleGroup();
    }

    @Override
    public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
        if (t1 instanceof RadioButton){
            System.out.println();
            switch (((MetodoPago)t1.getUserData()).getId()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } else if (t1 instanceof ToggleButton) {
            System.out.println("Grupo toggles");
        }
    }
}

