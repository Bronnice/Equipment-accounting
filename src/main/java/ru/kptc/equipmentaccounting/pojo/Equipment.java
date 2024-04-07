package ru.kptc.equipmentaccounting.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.kptc.equipmentaccounting.pojo.equpmentdata.EquipmentData;

@AllArgsConstructor
@Getter
public class Equipment {
    private final String model;
    private final String inventoryNumber;
    private final String serialNumber;
    @Setter
    private EquipmentData equipmentData;

    public Equipment(String model, String inventoryNumber, String serialNumber) {
        this(model, inventoryNumber, serialNumber, null);
    }
}
