module com.example.victor_gonzalez_dam2_2711 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;
    opens com.example.victor_gonzalez_dam2_2711 to javafx.fxml;
    exports com.example.victor_gonzalez_dam2_2711;
}