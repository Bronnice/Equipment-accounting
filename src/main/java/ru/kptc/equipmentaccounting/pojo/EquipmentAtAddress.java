package ru.kptc.equipmentaccounting.pojo;

import java.util.List;

public class EquipmentAtAddress {
    private final Integer objectCode;
    private final String address;
    private final String equipmentType;
    private final List<Equipment> equipmentList;

    public EquipmentAtAddress(Integer objectCode, String address, EquipmentType equipmentType, List<Equipment> equipmentList) {
        this.objectCode = objectCode;
        this.address = address;
        this.equipmentType = equipmentType.getRusValue();
        this.equipmentList = equipmentList;
    }

    public void addNewEquipment(Equipment equipment) {
        this.equipmentList.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        this.equipmentList.remove(equipment);
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public Integer getObjectCode() {
        return objectCode;
    }

    public String getAddress() {
        return address;
    }

    public String getEquipmentType() {
        return equipmentType;
    }
}
