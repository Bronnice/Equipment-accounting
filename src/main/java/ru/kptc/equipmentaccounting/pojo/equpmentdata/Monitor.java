package ru.kptc.equipmentaccounting.pojo.equpmentdata;

import lombok.Getter;

@Getter
public class Monitor extends EquipmentData{
    private final double diagonal;
    private final String resolution;

    public Monitor(byte floor, int room, double diagonal, String resolution) {
        super(floor, room);
        this.diagonal = diagonal;
        this.resolution = resolution;
    }
}
