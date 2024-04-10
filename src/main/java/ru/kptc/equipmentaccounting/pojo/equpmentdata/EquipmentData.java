package ru.kptc.equipmentaccounting.pojo.equpmentdata;

import lombok.Getter;

@Getter
public abstract class EquipmentData {
    protected final byte floor;
    protected final int room;

    protected EquipmentData(byte floor, int room) {
        this.floor = floor;
        this.room = room;
    }
}
