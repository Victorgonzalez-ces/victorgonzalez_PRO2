package com.example.victorgonzalez_t2_di_dam2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private Button anadirCarrito;

    @FXML
    private Button verCarrito;

    @FXML
    private ToggleButton toggleOnOff;

    @FXML
    private BorderPane bordeBotones;

    @FXML
    private TextField textoNombre;

    @FXML
    private TextField textoCategoria;

    @FXML
    private TextField textoPrecio;

    @FXML
    private TextArea textoArea;

    @FXML
    private BorderPane bordeTexto;
    @FXML
    private RadioButton radioPuntual;

    @FXML
    private RadioButton radioRecurrente;
    private ToggleGroup grupoRadios;

    private String nombre,categoria,textoRadios;
    private int precio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBoton();
        acciones();
        bordeTexto.setBottom(null);
        bordeBotones.setLeft(null);
        bordeBotones.setCenter(null);
    }
    private void acciones(){
        toggleOnOff.setOnAction(this);
        radioPuntual.setOnAction(this);
        radioRecurrente.setOnAction(this);
        grupoRadios.getToggles().addAll(radioPuntual,radioRecurrente);
        for (Node item: bordeBotones.getChildren()) {
            if (item instanceof Button){
                ((Button) item).setOnAction(this);
            }
        }
    }

    private void instancias(){
        grupoRadios = new ToggleGroup();
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == anadirCarrito){
            nombre = textoNombre.getText();
            categoria = textoCategoria.getText();
            precio = Integer.parseInt(textoPrecio.getText());
            grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                    if(t1.isSelected()){
                        textoRadios = t1.toString();
                    }
                }
            });
            textoArea.appendText("Nombre: "+nombre+"\nCategoria: "+categoria+"\nPrecio: "+precio+"\nTipo de compra: "+textoRadios+"\n/////////////////////\n");
            textoNombre.setText("");
            textoCategoria.setText("");
            textoPrecio.setText("");
        }
        if (actionEvent.getSource()==verCarrito){
            if (bordeTexto.getBottom()==null){
                bordeTexto.setBottom(textoArea);
            }else{
                bordeTexto.setBottom(null);
            }
        }
    }

    private void personalizarBoton(){
        cambiarBoton(anadirCarrito,"add.png");
        toggleOnOff.setBorder(null);
        toggleOnOff.setText("");
        toggleOnOff.setBackground(null);
        toggleOnOff.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                toggleOnOff.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("apagar.png"))));
                if (t1){
                    toggleOnOff.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("encender.png"))));
                    bordeBotones.setCenter(verCarrito);
                    bordeBotones.setLeft(anadirCarrito);
                }else{
                    bordeBotones.setCenter(null);
                    bordeBotones.setLeft(null);
                }
            }
        });
    }
    private void cambiarBoton(Button boton, String imagen){
        boton.setText("");
        boton.setBorder(null);
        boton.setBackground(null);
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(imagen))));
    }


}