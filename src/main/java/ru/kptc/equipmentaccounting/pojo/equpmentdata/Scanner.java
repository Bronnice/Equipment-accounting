package ru.kptc.equipmentaccounting.pojo.equpmentdata;

import lombok.Getter;

@Getter
public class Scanner extends EquipmentData {
    private final boolean isAvailableAutoGive;
    private final String paperMaxFormat;

    public Scanner(byte floor, int room, boolean isAvailableAutoGive, String paperMaxFormat) {
        super(floor, room);
        this.isAvailableAutoGive = isAvailableAutoGive;
        this.paperMaxFormat = paperMaxFormat;
    }
}
