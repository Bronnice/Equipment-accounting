package ru.kptc.equipment_accounting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EquipmentAccountingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EquipmentAccountingApplication.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 765);
        stage.setTitle("Главная");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}