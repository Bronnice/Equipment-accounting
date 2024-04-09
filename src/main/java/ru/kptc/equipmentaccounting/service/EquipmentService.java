package ru.kptc.equipmentaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kptc.equipmentaccounting.dao.EquipmentDao;
import ru.kptc.equipmentaccounting.repository.EquipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public List<EquipmentDao> getAllEquipmentByEquipmentAtAddressId(Long id) {
        return equipmentRepository.findAllByEquipmentAtAddressId(id);
    }

    public void deleteEquipmentById(Long id) {
        equipmentRepository.deleteById(id);
    }

    public void saveEquipment(EquipmentDao equipmentDao) {
        equipmentRepository.save(equipmentDao);
    }
}
