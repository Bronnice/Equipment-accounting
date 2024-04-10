package ru.kptc.equipmentaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kptc.equipmentaccounting.dao.EquipmentDataDao;
import ru.kptc.equipmentaccounting.repository.EquipmentDataRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentDataService {
    private final EquipmentDataRepository repository;

    public Optional<EquipmentDataDao> getByEquipmentId(Long equipmentId) {
        return repository.findByEquipmentId(equipmentId);
    }

    public void save(EquipmentDataDao equipmentData) {
        repository.save(equipmentData);
    }
}
