package com.example.pizzeria;

import com.example.pizzeria.model.Pedido;
import com.example.pizzeria.model.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private BorderPane bordeGeneral;

    @FXML
    private MenuItem itemRealizar;

    @FXML
    private MenuItem itemServir;

    @FXML
    private MenuItem itemCaja;

    @FXML
    private TextArea areaPedidos;

    @FXML
    private VBox parteCentral;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textTelefono;

    @FXML
    private HBox hboxRadios;

    @FXML
    private RadioButton radioFamiliar;

    @FXML
    private RadioButton radioMediana;

    @FXML
    private RadioButton radioPequena;

    private ToggleGroup radioGrupo;
    @FXML
    private HBox parteBaja;

    @FXML
    private Button botonRealizar;

    @FXML
    private Button botonServir;

    @FXML
    private ComboBox<String> comboPizzas;

    private ObservableList<String> listaNombrePizzas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        itemRealizar.setOnAction(this);
        itemServir.setOnAction(this);
        itemCaja.setOnAction(this);
        botonRealizar.setOnAction(this);
        botonServir.setOnAction(this);

    }

    private void instancias() {
        listaNombrePizzas = FXCollections.observableArrayList();
        listaNombrePizzas.addAll("Barbacoa", "Hawaiana", "Jamon y queso", "4 Quesos");
        comboPizzas.setItems(listaNombrePizzas);
        radioGrupo = new ToggleGroup();
        radioGrupo.getToggles().addAll(radioFamiliar, radioMediana, radioPequena);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonRealizar) {
            if (!textNombre.getText().isEmpty() &&
                    !textTelefono.getText().isEmpty() &&
                    radioGrupo.getSelectedToggle() != null &&
                    comboPizzas.getSelectionModel().getSelectedIndex() != -1) {
                Pizza pizza = new Pizza(comboPizzas.getSelectionModel().getSelectedItem(), radioGrupo.getSelectedToggle().toString(), calcularPrecio(comboPizzas.getValue(), radioGrupo.getSelectedToggle().toString()));
                Pedido pedido = new Pedido(1, textNombre.getText(), textTelefono.getText(), pizza);
                areaPedidos.appendText(pedido.getId() + " " + pedido.getNombre() + " " + pedido.getPizza().getNombre());
                textNombre.setText("");
                textTelefono.setText("");
                radioGrupo.selectToggle(null);
                comboPizzas.getSelectionModel().select(-1);
                System.out.println(pizza.getPrecio());
                System.out.println(comboPizzas.getSelectionModel().getSelectedItem() );
                System.out.println(radioGrupo.getSelectedToggle().getProperties().toString());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Faltan datos");
                alert.show();
            }
        }
    }

    public int calcularPrecio(String tipo, String tamanio) {
        if (tipo.equalsIgnoreCase("Barbacoa")) {
            if (tamanio.equalsIgnoreCase("Familiar")) {
                return 15;
            } else if (tamanio.equalsIgnoreCase("Mediana")) {
                return 12;
            } else if (tamanio.equalsIgnoreCase("Pequeña")) {
                return 7;
            }
        } else if (tipo.equalsIgnoreCase("Hawaiana")) {
            if (tamanio.equalsIgnoreCase("Familiar")) {
                return 13;
            } else if (tamanio.equalsIgnoreCase("Mediana")) {
                return 10;
            } else if (tamanio.equalsIgnoreCase("Pequeña")) {
                return 5;
            }
        } else if (tipo.equalsIgnoreCase("Jamon y queso")) {
            if (tamanio.equalsIgnoreCase("Familiar")) {
                return 10;
            } else if (tamanio.equalsIgnoreCase("Mediana")) {
                return 8;
            } else if (tamanio.equalsIgnoreCase("Pequeña")) {
                return 4;
            }
        } else {
            if (tamanio.equalsIgnoreCase("Familiar")) {
                return 17;
            } else if (tamanio.equalsIgnoreCase("Mediana")) {
                return 13;
            } else if (tamanio.equalsIgnoreCase("Pequeña")) {
                return 8;
            }
        }
        return 0;
    }
}