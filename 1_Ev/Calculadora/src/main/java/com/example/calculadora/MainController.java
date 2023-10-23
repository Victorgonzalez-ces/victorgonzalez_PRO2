package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private BorderPane borderCos;

    @FXML
    private BorderPane borderPow;

    @FXML
    private BorderPane borderRaiz;

    @FXML
    private BorderPane borderRegistro;

    @FXML
    private BorderPane borderSen;

    @FXML
    private BorderPane borderTan;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button boton0;

    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private Button boton3;

    @FXML
    private Button boton4;

    @FXML
    private Button boton5;

    @FXML
    private Button boton6;

    @FXML
    private Button boton7;

    @FXML
    private Button boton8;

    @FXML
    private Button boton9;

    @FXML
    private Button botonCientifica;

    @FXML
    private Button botonCos;

    @FXML
    private Button botonDividir;

    @FXML
    private Button botonIgual;

    @FXML
    private Button botonMas;

    @FXML
    private Button botonMenos;

    @FXML
    private Button botonPor;

    @FXML
    private Button botonPow;

    @FXML
    private Button botonRaiz;

    @FXML
    private Button botonRegistro;

    @FXML
    private Button botonSen;

    @FXML
    private Button botonTan;

    @FXML
    private GridPane panelGeneral;

    @FXML
    private TextField textoCalculadora;

    @FXML
    private TextArea textoRegistro;

    @FXML
    private HBox hBoxCos;

    @FXML
    private HBox hBoxPow;

    @FXML
    private HBox hBoxRegistro;

    @FXML
    private HBox hBoxSen;

    @FXML
    private HBox hBoxTan;

    @FXML
    private HBox hboxRaiz;
    private boolean isOperando=false;
    private int op1,op2,operacion;
    private int resultado = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        borderRegistro.setCenter(null);
        borderPow.setCenter(null);
        borderSen.setCenter(null);
        borderCos.setCenter(null);
        borderTan.setCenter(null);
        borderRaiz.setCenter(null);
    }

    private void acciones(){
        for (Node item: panelGeneral.getChildren()) {
            System.out.println(item);
            if (item instanceof Button){
                ((Button) item).setOnAction(this);
            }
        }
        botonCos.setOnAction(this);
        botonSen.setOnAction(this);
        botonTan.setOnAction(this);
        botonPow.setOnAction(this);
        botonRaiz.setOnAction(this);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==boton1 || actionEvent.getSource()==boton2 || actionEvent.getSource()==boton3 || actionEvent.getSource()==boton4 || actionEvent.getSource()==boton5 || actionEvent.getSource()==boton6 || actionEvent.getSource()==boton7 || actionEvent.getSource()==boton8 || actionEvent.getSource()==boton9 || actionEvent.getSource()==boton0){
            if (!isOperando){
                textoCalculadora.appendText(((Button)(actionEvent.getSource())).getText());
            }else{
                textoCalculadora.setText(((Button) (actionEvent.getSource())).getText());
                isOperando = false;
            }
        }else if (actionEvent.getSource()==botonMas || actionEvent.getSource()==botonMenos || actionEvent.getSource()==botonDividir || actionEvent.getSource()==botonPor || actionEvent.getSource()==botonCos || actionEvent.getSource()==botonSen || actionEvent.getSource()==botonTan || actionEvent.getSource()==botonPow || actionEvent.getSource()==botonRaiz){
            op1 = Integer.parseInt(textoCalculadora.getText());
            isOperando = true;
            textoCalculadora.setText("");
            operacion = 1;
            if (actionEvent.getSource()==botonMenos){
                operacion=2;
            } else if (actionEvent.getSource()==botonDividir) {
                operacion=4;
            } else if (actionEvent.getSource()==botonPor) {
                operacion=3;
            } else if (actionEvent.getSource()==botonCos) {
                resultado = (int) Math.tan(op1);
                textoCalculadora.setText(String.valueOf(Math.cos(op1)));
                textoRegistro.appendText(op1+" = "+resultado+"\n");
            } else if (actionEvent.getSource()==botonSen) {
                resultado = (int) Math.tan(op1);
                textoCalculadora.setText(String.valueOf(Math.sin(op1)));
                textoRegistro.appendText(op1+" = "+resultado+"\n");
            } else if (actionEvent.getSource()==botonTan) {
                resultado = (int) Math.tan(op1);
                textoCalculadora.setText(String.valueOf(Math.tan(op1)));
                textoRegistro.appendText(op1+" = "+resultado+"\n");
            } else if (actionEvent.getSource()==botonPow){
                operacion=5;
            } else if (actionEvent.getSource()==botonRaiz) {
                resultado = (int) Math.tan(op1);
                textoCalculadora.setText(String.valueOf(Math.sqrt(op1)));
                textoRegistro.appendText(op1+" = "+resultado+"\n");
            }
        } else if (actionEvent.getSource()==botonIgual) {
            op2 = Integer.parseInt(textoCalculadora.getText());
            switch (operacion){
                case 1:
                    resultado = op1 + op2;
                    textoRegistro.appendText(op1+" + "+op2+" = "+resultado+"\n");
                    break;
                case 2:
                    resultado = op1 - op2;
                    textoRegistro.appendText(op1+" - "+op2+" = "+resultado+"\n");
                    break;
                case 3:
                    resultado = op1 * op2;
                    textoRegistro.appendText(op1+" * "+op2+" = "+resultado+"\n");
                    break;
                case 4:
                    resultado = op1 / op2;
                    textoRegistro.appendText(op1+" / "+op2+" = "+resultado+"\n");
                    break;
                case 5:
                    resultado = (int)Math.pow(op1,op2);
                    textoRegistro.appendText(op1+" ^ "+op2+" = "+resultado+"\n");
            }
            textoCalculadora.setText(String.valueOf(resultado));
            isOperando=true;
        } else if (actionEvent.getSource()==botonCientifica) {
            if (borderCos.getCenter()==null){
                borderCos.setCenter(hBoxCos);
                borderTan.setCenter(hBoxTan);
                borderSen.setCenter(hBoxSen);
                borderPow.setCenter(hBoxPow);
                borderRaiz.setCenter(hboxRaiz);
            }else{
                borderCos.setCenter(null);
                borderTan.setCenter(null);
                borderSen.setCenter(null);
                borderRaiz.setCenter(null);
                borderPow.setCenter(null);
            }
        } else if (actionEvent.getSource()==botonBorrar) {
            textoCalculadora.setText("");
        } else if (actionEvent.getSource()==botonRegistro) {
            if (borderRegistro.getCenter()==null){
                borderRegistro.setCenter(hBoxRegistro);
            }else{
                borderRegistro.setCenter(null);
            }
        }
    }
}