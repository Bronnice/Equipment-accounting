package ru.kptc.equipment_accounting.pojo;

public class Equipment {
    private final String model;
    private final String inventoryNumber;
    private final String serialNumber;

    public Equipment(String model, String inventoryNumber, String serialNumber) {
        this.model = model;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
