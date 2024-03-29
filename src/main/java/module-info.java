module ru.kptc.equipmentaccounting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires static lombok;

    opens ru.kptc.equipment_accounting to javafx.fxml;
    exports ru.kptc.equipment_accounting;
    exports ru.kptc.equipment_accounting.pojo;
    exports ru.kptc.equipment_accounting.controller;
    opens ru.kptc.equipment_accounting.controller to javafx.fxml;
    opens ru.kptc.equipment_accounting.pojo to javafx.fxml;
}