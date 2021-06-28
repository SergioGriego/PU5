package sample.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;

public class Login {

    public void c(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../newton.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
        Main.stage.setTitle("Interpolación de Newton");
    }
    public void ca(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../lagrange.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
        Main.stage.setTitle("Interpolación de Lagrange");
    }
}
