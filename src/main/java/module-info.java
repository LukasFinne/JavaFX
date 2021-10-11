module se.iths.javafx.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.javafx.javafx to javafx.fxml;
    exports se.iths.javafx.javafx;
}