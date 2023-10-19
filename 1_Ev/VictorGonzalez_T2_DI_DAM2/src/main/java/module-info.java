module com.example.victorgonzalez_t2_di_dam2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.victorgonzalez_t2_di_dam2 to javafx.fxml;
    exports com.example.victorgonzalez_t2_di_dam2;
}