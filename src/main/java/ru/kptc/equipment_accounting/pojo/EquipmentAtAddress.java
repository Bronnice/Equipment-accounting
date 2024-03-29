package ru.kptc.equipment_accounting.pojo;

import lombok.Getter;

import java.util.List;

public class EquipmentAtAddress {
    private final Integer objectCode;
    @Getter
    private final String address;
    @Getter
    private final String equipmentType;
    @Getter
    private List<Equipment> equipmentList;

    public EquipmentAtAddress(Integer objectCode, String address, EquipmentType equipmentType, List<Equipment> equipmentList) {
        this.objectCode = objectCode;
        this.address = address;
        this.equipmentType = equipmentType.getRusValue();
        this.equipmentList = equipmentList;
    }

    public int getObjectCode() {
        return objectCode;
    }

    public void addNewEquipment(Equipment equipment) {
        this.equipmentList.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        this.equipmentList.remove(equipment);
    }
}
