package com.example.victor_gonzalez_dam2_2711;

import com.google.gson.Gson;
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
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private MenuItem itemSalir;

    @FXML
    private MenuItem itemVerDetalle;

    @FXML
    private ImageView imagenEquipo;

    @FXML
    private Label nombreEquipo;
    @FXML
    private ListView<PaisJSON> listViewPaises;

    private ObservableList<PaisJSON> listaListViewPaises;

    @FXML
    private ListView<EquipoJSON> listViewEquipos;
    private ObservableList<EquipoJSON> listaListViewEquipo;

    @FXML
    private Button botonFiltrar;

    private DialogoPersoController dialogoPersoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
        obtenerPaises();
    }

    private void acciones() {
        botonFiltrar.setOnAction(this);
        itemSalir.setOnAction(this);
        itemVerDetalle.setOnAction(this);
    }

    private void instancias() {
        listaListViewPaises = FXCollections.observableArrayList();
        listViewPaises.setItems(listaListViewPaises);

        listaListViewEquipo = FXCollections.observableArrayList();
        listViewEquipos.setItems(listaListViewEquipo);
    }
    private void obtenerPaises(){
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_countries.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null){
                stringBuffer.append(linea);
            }
            JSONObject object = new JSONObject(stringBuffer.toString());
            JSONArray countries = object.getJSONArray("countries");
            for (int i = 0; i < countries.length(); i++) {
                JSONObject name_en = countries.getJSONObject(i);

                PaisJSON paisJSON = new PaisJSON(name_en.getString("name_en"));
                listaListViewPaises.add(paisJSON);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void obtenerEquipos(String nombre_pais){
        try {
            listaListViewEquipo.clear();
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Soccer&c="+nombre_pais);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null){
                stringBuffer.append(linea);
            }
            JSONObject object = new JSONObject(stringBuffer.toString());
            JSONArray teams = object.getJSONArray("teams");
            for (int i = 0; i < teams.length(); i++) {
                JSONObject nombre_Equipo = teams.getJSONObject(i);
                EquipoJSON equipoJSON = new EquipoJSON(nombre_Equipo.getString("strTeam"),nombre_Equipo.getString("strTeamBadge"));
                if (equipoJSON.strTeam != null){
                    listaListViewEquipo.add(equipoJSON);
                }else{
                    equipoJSON.strTeam = "";
                }

            }
            listViewEquipos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EquipoJSON>() {
                @Override
                public void changed(ObservableValue<? extends EquipoJSON> observableValue, EquipoJSON equipoJSON, EquipoJSON t1) {
                    imagenEquipo = new ImageView(new Image(t1.strTeamBadge));
                    nombreEquipo.setText(t1.strTeam);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == itemSalir){
            /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.getButtonTypes().addAll(ButtonType.CLOSE,ButtonType.CANCEL);

            Optional<ButtonType> botones = alert.showAndWait();

            if (botones.get() == ButtonType.CLOSE){
                System.exit(0);
            }*/
            System.exit(0);

        } else if (actionEvent.getSource() == botonFiltrar) {
            if (listViewPaises.getSelectionModel().getSelectedIndex() != -1){
                String paisSeleccionado = listViewPaises.getSelectionModel().getSelectedItem().getNombre_en();
                obtenerEquipos(paisSeleccionado);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Porfavor seleccione un pais para poder mostrar sus equipos");
                alert.show();
            }
        } else if (actionEvent.getSource() == itemVerDetalle) {
            Dialog dialog = new Dialog();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogo-view"));
            Parent root = null;
            try {
                root = loader.load();
                dialogoPersoController = loader.getController();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialog.getDialogPane().setContent(root);
            dialog.show();
        }
    }
}