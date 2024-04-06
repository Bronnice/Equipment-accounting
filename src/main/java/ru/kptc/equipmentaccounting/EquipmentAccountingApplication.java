package ru.kptc.equipmentaccounting;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.kptc.equipmentaccounting.controller.MainPageController;

@SpringBootApplication
@ComponentScan(basePackageClasses={MainPageController.class})
public class EquipmentAccountingApplication {
    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }
}