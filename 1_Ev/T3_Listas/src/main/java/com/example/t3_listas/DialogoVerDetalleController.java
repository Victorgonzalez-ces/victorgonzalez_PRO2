package com.example.t3_listas;

import com.example.t3_listas.model.PeliculaJSON;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoVerDetalleController implements Initializable {
    @FXML
    private Text tituloDialog;

    @FXML
    private ImageView imagenDialog;

    @FXML
    private Text descripcionDialog;

    @FXML
    private Text votos;

    @FXML
    private Text media;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public Text getTituloDialog() {
        return tituloDialog;
    }

    public void setTituloDialog(Text tituloDialog) {
        this.tituloDialog = tituloDialog;
    }

    public ImageView getImagenDialog() {
        return imagenDialog;
    }

    public void setImagenDialog(ImageView imagenDialog) {
        this.imagenDialog = imagenDialog;
    }

    public Text getDescripcionDialog() {
        return descripcionDialog;
    }

    public void setDescripcionDialog(Text descripcionDialog) {
        this.descripcionDialog = descripcionDialog;
    }

    public Text getVotos() {
        return votos;
    }

    public void setVotos(Text votos) {
        this.votos = votos;
    }

    public Text getMedia() {
        return media;
    }

    public void setMedia(Text media) {
        this.media = media;
    }

    public void setPeliculaData(PeliculaJSON peliculaJSON){
        imagenDialog.setImage(new Image(peliculaJSON.getBackdrop_path()));
        tituloDialog.setText(peliculaJSON.getTitle());
        descripcionDialog.setText(peliculaJSON.getOverview());
    }
}
