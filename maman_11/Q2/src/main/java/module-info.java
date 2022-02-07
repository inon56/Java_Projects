module com.example.maman_11_q2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maman_11_q2 to javafx.fxml;
    exports com.example.maman_11_q2;
}