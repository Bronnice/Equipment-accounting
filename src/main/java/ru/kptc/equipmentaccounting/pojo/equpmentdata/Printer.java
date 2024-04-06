package ru.kptc.equipmentaccounting.pojo.equpmentdata;

import lombok.Getter;

@Getter
public class Printer extends EquipmentData{
    private final String printColor;
    private final String printMaxFormat;

    public Printer(byte floor, int room, String printColor, String printMaxFormat) {
        super(floor, room);
        this.printColor = printColor;
        this.printMaxFormat = printMaxFormat;
    }
}
