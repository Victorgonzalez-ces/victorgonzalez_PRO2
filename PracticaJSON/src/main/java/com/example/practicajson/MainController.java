package com.example.practicajson;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private BorderPane bordeGeneral;

    @FXML
    private TableColumn<?, ?> columnaDeporte;

    @FXML
    private TableColumn<?, ?> columnaID;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private ComboBox<String> comboDeporte;
    private ObservableList<String> listaCombo;

    @FXML
    private ListView<LigasJSON> listViewLigas;

    @FXML
    private MenuItem menuAlerta;

    @FXML
    private MenuItem menuPersonalizado;

    @FXML
    private MenuItem menuPregunta;

    @FXML
    private MenuItem menuSalir;

    @FXML
    private MenuItem menuSeleccion;

    @FXML
    private MenuItem menuSimple;

    @FXML
    private MenuItem menuTexto;

    @FXML
    private MenuItem menuWarn;

    @FXML
    private RadioMenuItem radioDeshabilitar;

    @FXML
    private RadioMenuItem radioHabilitar;
    private ToggleGroup grupoRadios;

    @FXML
    private Spinner<String> spinnerID;
    private SpinnerValueFactory listaSpinner;

    @FXML
    private Button botonRellenar;
    @FXML
    private TableView<LigasJSON> tablaLigas;

    private DialogoPersoController dialogoPersoController;
    private ObservableList<LigasJSON> listaListViewLigas;
    private FilteredList<LigasJSON> listaFiltrada;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        setTablaDatos();
        personalizarMenu();
        acciones();
    }

    private void setTablaDatos(){
        columnaID.setCellValueFactory(new PropertyValueFactory<>("idLeague"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("strLeague"));
        columnaDeporte.setCellValueFactory(new PropertyValueFactory<>("strSport"));
    }
    private void obtenerLigas(){
        try {
            listaListViewLigas.clear();
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_leagues.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null){
                stringBuffer.append(linea);
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray ligas = jsonObject.getJSONArray("leagues");
            for (int i = 0; i < ligas.length(); i++) {
                JSONObject liga = ligas.getJSONObject(i);
                Gson gson = new Gson();
                LigasJSON ligasJSON = gson.fromJson(liga.toString(),LigasJSON.class);
                System.out.println("Nombre: "+ligasJSON.getStrLeague());
                listaListViewLigas.add(ligasJSON);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void acciones() {
        menuSalir.setOnAction(this);
        botonRellenar.setOnAction(this);
        menuSimple.setOnAction(this);
        menuAlerta.setOnAction(this);
        menuWarn.setOnAction(this);
        menuSeleccion.setOnAction(this);
        menuPregunta.setOnAction(this);
        menuTexto.setOnAction(this);
        menuPersonalizado.setOnAction(this);
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem)t1).getText().equalsIgnoreCase("Habilitar")){
                    bordeGeneral.setDisable(false);
                    tablaLigas.setDisable(false);
                }else{
                    bordeGeneral.setDisable(true);
                    tablaLigas.setDisable(true);
                }
            }
        });
    }

    private void instancias() {
        //instanciamos comboBox y introducimos datos
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Soccer","Motorsport","Ice Hockey","Basketball","American Football");
        comboDeporte.setItems(listaCombo);

        //instanciamos spinner y introducimos datos
        ObservableList listaOpciones = FXCollections.observableArrayList();
        listaOpciones.addAll("0","4340","4380","4400");
        listaSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(listaOpciones);
        spinnerID.setValueFactory(listaSpinner);

        //instanciamos la lista general y la metemos en la listview y en la tableview
        listaListViewLigas = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList<>(listaListViewLigas);
        tablaLigas.setItems(listaFiltrada);
        listViewLigas.setItems(listaFiltrada);
        //metemos radios en un grupo
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioHabilitar,radioDeshabilitar);

    }


    private void personalizarMenu(){
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("salida.png"))));
        menuSalir.setText("");
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonRellenar){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    obtenerLigas();
                }
            });
        } else if (actionEvent.getSource() == menuSalir) {
            System.exit(0);
        } else if (actionEvent.getSource() == menuSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuadro simple de alerta");
            alertSimple.setHeaderText("Cabecera de cuadro simple");
            alertSimple.setContentText("Información de cuadro simple");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuAlerta) {
            Alert alertAlerta = new Alert(Alert.AlertType.WARNING);
            alertAlerta.setHeaderText("Este es el cuadro de alerta");
            alertAlerta.setContentText("Cuadro de alerta para lo que necesites");
        } else if (actionEvent.getSource() == menuPersonalizado) {
            Dialog<LigasJSON> dialogoLiga = new Dialog<>();
            dialogoLiga.setTitle("Dialogo de nueva liga");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialogoPerso-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
                dialogoPersoController = fxmlLoader.getController();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialogoLiga.getDialogPane().setContent(root);
            dialogoLiga.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY,ButtonType.CLOSE);
            dialogoLiga.setResultConverter(new Callback<ButtonType, LigasJSON>() {
                @Override
                public LigasJSON call(ButtonType buttonType) {
                    if (buttonType == ButtonType.APPLY){
                        if (dialogoPersoController.isLiga()){
                            return dialogoPersoController.getLiga();
                        }
                    }
                    return null;
                }
            });
            Optional<LigasJSON> ligasJ = dialogoLiga.showAndWait();
            System.out.println(ligasJ.get().getStrSport());
        }
    }

}