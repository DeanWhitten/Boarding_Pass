module com.example.boarding_pass {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.boarding_pass to javafx.fxml;
    exports com.example.boarding_pass;
}