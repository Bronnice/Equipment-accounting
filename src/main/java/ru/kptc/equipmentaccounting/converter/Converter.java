package ru.kptc.equipmentaccounting.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kptc.equipmentaccounting.dao.EquipmentAtAddressDao;
import ru.kptc.equipmentaccounting.dao.EquipmentDao;
import ru.kptc.equipmentaccounting.pojo.Equipment;
import ru.kptc.equipmentaccounting.pojo.EquipmentAtAddress;
import ru.kptc.equipmentaccounting.pojo.EquipmentType;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Converter {
    public static Equipment equipmentDaoToPojo(EquipmentDao dao) {
        return new Equipment(
                dao.getModel(),
                dao.getInventoryNumber(),
                dao.getSerialNumber());
    }

    public static List<Equipment> equipmentDaoToPojo(List<EquipmentDao> dao) {
        return dao.stream().map(Converter::equipmentDaoToPojo).toList();
    }

    public static EquipmentAtAddress equipmentAtAddressDaoToPojo(EquipmentAtAddressDao dao) {
        return new EquipmentAtAddress(
                dao.getObjectCode(),
                dao.getAddress(),
                EquipmentType.valueOfByRusName(dao.getEquipmentType()),
                equipmentDaoToPojo(dao.getEquipmentList().stream().toList())
        );
    }

    public static List<EquipmentAtAddress> equipmentAtAddressDaoToPojo(List<EquipmentAtAddressDao> dao) {
        return dao.stream().map(Converter::equipmentAtAddressDaoToPojo).toList();
    }
}
