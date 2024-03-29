package ru.kptc.equipment_accounting.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.kptc.equipment_accounting.EquipmentAccountingApplication;
import ru.kptc.equipment_accounting.pojo.Equipment;
import ru.kptc.equipment_accounting.pojo.EquipmentAtAddress;
import ru.kptc.equipment_accounting.pojo.EquipmentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPageController {
    private List<EquipmentAtAddress> equipmentAtAddressList;
    @FXML
    public TableView<EquipmentAtAddress> mainTable;
    @FXML
    public TableColumn<EquipmentAtAddress, Integer> objectCodeColumn;
    @FXML
    public TableColumn<EquipmentAtAddress, String> addressColumn;
    @FXML
    public TableColumn<EquipmentAtAddress, String> equipmentTypeColumn;


    @FXML
    protected void initialize() {
        // TODO: Удалить после приркучивания базы
        equipmentAtAddressList = List.of(
                new EquipmentAtAddress(1, "Кострома", EquipmentType.MONITOR, new ArrayList<>(List.of(new Equipment("test1", "112345", "112345")))),
                new EquipmentAtAddress(1, "Кострома", EquipmentType.PRINTER, new ArrayList<>(List.of(new Equipment("test2", "212345", "212345")))),
                new EquipmentAtAddress(1, "Кострома", EquipmentType.SCANNER, new ArrayList<>(List.of(new Equipment("test3", "312345", "312345")))),
                new EquipmentAtAddress(1, "Кострома", EquipmentType.SYSTEM_BLOCK, new ArrayList<>(List.of(new Equipment("test4", "412345", "412345"))))
        );


        ObservableList<EquipmentAtAddress> equipmentAtAddresses = FXCollections.observableArrayList(equipmentAtAddressList);

        objectCodeColumn.setCellValueFactory(new PropertyValueFactory<>("objectCode"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        equipmentTypeColumn.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));

        mainTable.setItems(equipmentAtAddresses);
    }

    @FXML
    public void clickItem(MouseEvent event) {
        EquipmentAtAddress selectedObject = null;

        if (event.getClickCount() == 2) {
            try {
                selectedObject = mainTable.getSelectionModel().getSelectedItem();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (selectedObject == null) {
                return;
            }

            // Создание нового окна "Список оборудования"
            try {
                createEquipmentManageWindow(selectedObject);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createEquipmentManageWindow (EquipmentAtAddress selectedObject) throws IOException {
        Stage dialogStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(EquipmentAccountingApplication.class.getResource("equipment-manage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        EquipmentManageController equipmentManageController = fxmlLoader.getController();

        equipmentManageController.setSelectedObject(selectedObject);

        dialogStage.setTitle("Список оборудования");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);

        dialogStage.show();
    }
}