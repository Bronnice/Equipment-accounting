package ru.kptc.equipmentaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kptc.equipmentaccounting.converter.Converter;
import ru.kptc.equipmentaccounting.pojo.Equipment;
import ru.kptc.equipmentaccounting.repository.EquipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipmentByEquipmentAtAddressId(Long id) {
        return Converter.equipmentDaoToPojo(equipmentRepository.findAllByEquipmentAtAddressId(id));
    }
}
