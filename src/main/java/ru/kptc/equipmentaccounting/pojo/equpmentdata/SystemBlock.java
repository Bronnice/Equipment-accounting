package ru.kptc.equipmentaccounting.pojo.equpmentdata;

import lombok.Getter;

@Getter
public class SystemBlock extends EquipmentData{
    private final String processorModel;
    private final int coresCount;
    private final double clockFrequency;
    private final String ramType;
    private final double ramCapacity;
    private final int hddCapacity;

    public SystemBlock(byte floor, int room, String processorModel, int coresCount, double clockFrequency, String ramType, double ramCapacity, int hddCapacity) {
        super(floor, room);
        this.processorModel = processorModel;
        this.coresCount = coresCount;
        this.clockFrequency = clockFrequency;
        this.ramType = ramType;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }
}
