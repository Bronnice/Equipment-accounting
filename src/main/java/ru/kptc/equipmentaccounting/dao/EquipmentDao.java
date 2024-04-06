package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "equipment")
public class EquipmentDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String model;
    private String inventoryNumber;
    private String serialNumber;

    public EquipmentDao() {
    }

    public EquipmentDao(Long id, String model, String inventoryNumber, String serialNumber) {
        this.id = id;
        this.model = model;
        this.inventoryNumber = inventoryNumber;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
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
