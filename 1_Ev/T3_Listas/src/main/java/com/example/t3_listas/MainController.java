package com.example.t3_listas;

import com.example.t3_listas.model.Pelicula;
import com.example.t3_listas.model.PeliculaJSON;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
import javafx.scene.layout.BorderPane;
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
    private BorderPane parteCentral;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private ChoiceBox<Pelicula> choice;

    private ObservableList<String> listaCombo;
    private ObservableList<Pelicula> listaChoice;

    private ObservableList<Pelicula> listaListView;
    @FXML
    private Spinner<Integer> spinner;

    private SpinnerValueFactory listaSpinner;
    @FXML
    private ListView<Pelicula> listView;

    @FXML
    private Button botonFiltrar;
    private ToggleGroup grupoHabilitar;

    @FXML
    private MenuItem itemAgregar;

    @FXML
    private MenuItem itemBorrar;
    private DialogoPersoController dialogoPersoController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        obtenerPeliculas();
        personalizarMenu();
        acciones();
    }

    private void obtenerPeliculas() {
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=es-ES&page=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine())!=null){
                stringBuffer.append(linea);
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadosPeliculas = jsonObject.getJSONArray("results");
            for (int i = 0; i < resultadosPeliculas.length(); i++) {
                JSONObject pelicula = resultadosPeliculas.getJSONObject(i);
                String titulo = pelicula.getString("original_title");

                Gson gson = new Gson();
                PeliculaJSON peliculaJSON = gson.fromJson(pelicula.toString(), PeliculaJSON.class);
                System.out.println(peliculaJSON.getTitle());
            }



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        botonFiltrar.setOnAction(this);
        itemAgregar.setOnAction(this);
        itemBorrar.setOnAction(this);
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
            }

        });
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pelicula>() {
            @Override
            public void changed(ObservableValue<? extends Pelicula> observableValue, Pelicula pelicula, Pelicula t1) {
                System.out.println(pelicula.getTitulo());
            }
        });
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                System.out.println(t1);
            }
        });
        System.out.println( combo.getSelectionModel().getSelectedItem());
    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Terror","Comedia","Intriga","Infantil");
        combo.setItems(listaCombo);
        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll(new Pelicula("Pelicla1","terror",1876),
        new Pelicula("Pelicla2","comedia",1996),
        new Pelicula("Pelicla3","infantil",1986),
        new Pelicula("Pelicla4","terror",2000));
        choice.setItems(listaChoice);
        listView.setItems(listaChoice);
        listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,5,5);
        //ObservableList listaOpcines = FXCollections.observableArrayList();
        /*listaOpcines.addAll("Opción 1","Opción 2","Opción 3" )
        listaSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(listaOpcines);*/
        spinner.setValueFactory(listaSpinner);
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(radioMenuHab, radioMenuDesHab);
        listaListView = FXCollections.observableArrayList();
        listaListView.addAll(new Pelicula("p1","genero1",1953),
            new Pelicula("p2","genero2",1953)
            );
        listView.setItems(listaListView);
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
        } else if (actionEvent.getSource() == botonFiltrar) {

            //combo.getItems().get(1);
            if (combo.getSelectionModel().getSelectedIndex() != -1
                    && choice.getSelectionModel().getSelectedIndex() != -1
                    && listView.getSelectionModel().getSelectedIndex() != -1) {
                System.out.println(combo.getSelectionModel().getSelectedItem());
                System.out.println(choice.getSelectionModel().getSelectedItem().getGenero());
                System.out.println(listView.getSelectionModel().getSelectedItem().getTitulo());
                System.out.println(spinner.getValue());
            }else{
                System.out.println("No hay nada seleccionado");
            }
        } else if (actionEvent.getSource() == itemAgregar) {
            listaListView.add(new Pelicula("Nueva","genero4",2000));
            listView.refresh();
        } else if (actionEvent.getSource() == itemBorrar) {
            if (listView.getSelectionModel().getSelectedIndex()>-1){
                listaListView.remove(listView.getSelectionModel().getSelectedIndex());
                listView.refresh();
                listView.getSelectionModel().select(-1);
            }else{
                Alert aviso = new Alert(Alert.AlertType.WARNING);
                aviso.setHeaderText("No hay elemento seleccionado");
                aviso.show();
            }
        }

    }
}

