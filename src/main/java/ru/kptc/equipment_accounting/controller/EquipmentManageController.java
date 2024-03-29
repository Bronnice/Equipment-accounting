package ru.kptc.equipment_accounting.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import ru.kptc.equipment_accounting.exception.ValidationException;
import ru.kptc.equipment_accounting.pojo.Equipment;
import ru.kptc.equipment_accounting.pojo.EquipmentAtAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EquipmentManageController {
    @Getter
    private EquipmentAtAddress selectedObject;
    private static final String ERROR_TITLE = "Ошибка!";
    @FXML
    public TableView<Equipment> secondTable;
    @FXML
    public TableColumn<Equipment, String> modelColumn;
    @FXML
    public TableColumn<Equipment, String> inventoryNumberColumn;
    @FXML
    public TableColumn<Equipment, String> serialNumberColumn;


    public void setSelectedObject(EquipmentAtAddress selectedObject) {
        this.selectedObject = selectedObject;

        // TODO: Удалить после приркучивания базы
        ObservableList<Equipment> chars = FXCollections.observableArrayList(
                getSelectedObject().getEquipmentList()
        );

        secondTable.setItems(chars);
    }

    @FXML
    protected void initialize() {
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        inventoryNumberColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryNumber"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
    }

    @FXML
    protected void deleteItem() {
        try {
            getSelectedObject().removeEquipment(secondTable.getSelectionModel().getSelectedItem());
        } catch (NullPointerException e) {
            showErrorWindow("Вы не выбрали элемент!");
        }

        reloadTable();
    }

    @FXML
    protected void addNewItem() {
        try {
            Equipment newEquipment = createNewEquipmentWithWindow();

            getSelectedObject()
                    .addNewEquipment(newEquipment);
        } catch (ValidationException e) {
            showErrorWindow(e.getMessage());
        }

        reloadTable();
    }

    private void reloadTable() {
        secondTable.setItems(FXCollections.observableArrayList(
                getSelectedObject().getEquipmentList()
        ));
    }

    private Equipment createNewEquipmentWithWindow() throws ValidationException {
        List<String> result = createAndShowNewEquipmentCreatingWindow();

        if (result.get(0).isEmpty()) {
            throw new ValidationException("Модель не может быть пустой!");
        }
        if (result.get(1).isEmpty()) {
            throw new ValidationException("Инвентарный номер не может быть пустой!");
        }
        if (result.get(2).isEmpty()) {
            throw new ValidationException("Серийный номер не может быть пустой!");
        }

        return new Equipment(result.get(0), result.get(1), result.get(2));
    }

    private List<String> createAndShowNewEquipmentCreatingWindow() {
        Dialog<List<String>> dialog = new Dialog<>();
        dialog.setTitle("Добавление нового оборудования");

        ButtonType createButtonType = new ButtonType("Создать", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField modelField = new TextField();
        TextField inventoryNumberField = new TextField();
        TextField serialNumberField = new TextField();

        grid.add(new Label("Модель:"), 0, 0);
        grid.add(modelField, 1, 0);
        grid.add(new Label("Инвентарный номер:"), 0, 1);
        grid.add(inventoryNumberField, 1, 1);
        grid.add(new Label("Серийный номер:"), 0, 2);
        grid.add(serialNumberField, 1, 2);

        Node createButton = dialog.getDialogPane().lookupButton(createButtonType);
        createButton.setDisable(true);

        modelField.textProperty().addListener((observable, oldValue, newValue) -> {
            createButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(modelField::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                return new ArrayList<>(List.of(modelField.getText(), inventoryNumberField.getText(), serialNumberField.getText()));
            }
            return null;
        });

        Optional<List<String>> result = dialog.showAndWait();

        if (result.isPresent()) {
            return result.get();
        }

        throw new RuntimeException("Ничего не выбрано!");
    }

    private void showErrorWindow(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(ERROR_TITLE);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
