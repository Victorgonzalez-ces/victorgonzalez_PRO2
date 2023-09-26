module com.example.tema2_estructura {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.tema2_estructura to javafx.fxml;
    exports com.example.tema2_estructura;
    exports com.example.tema2_estructura.controller;
    opens com.example.tema2_estructura.controller to javafx.fxml;
}