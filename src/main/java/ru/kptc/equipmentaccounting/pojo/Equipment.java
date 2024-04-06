package ru.kptc.equipmentaccounting.pojo;

import lombok.Setter;
import ru.kptc.equipmentaccounting.pojo.equpmentdata.EquipmentData;

public class Equipment {
    private final String model;
    private final String inventoryNumber;
    private final String serialNumber;
    @Setter
    private EquipmentData equipmentData;

    public Equipment(String model, String inventoryNumber, String serialNumber, EquipmentData equipmentData) {
        this.model = model;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
        this.equipmentData = equipmentData;
    }

    public Equipment(String model, String inventoryNumber, String serialNumber) {
        this(model, inventoryNumber, serialNumber, null);
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

    public EquipmentData getEquipmentData() {
        return equipmentData;
    }
}
