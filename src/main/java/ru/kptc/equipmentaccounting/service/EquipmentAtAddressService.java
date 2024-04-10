package ru.kptc.equipmentaccounting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kptc.equipmentaccounting.dao.EquipmentAtAddressDao;
import ru.kptc.equipmentaccounting.repository.EquipmentAtAddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipmentAtAddressService {
    private final EquipmentAtAddressRepository equipmentAtAddressRepository;

    public List<EquipmentAtAddressDao> getAllEquipment() {
        return equipmentAtAddressRepository.findAll();
    }
    public EquipmentAtAddressDao getEquipmentById(Long id) {
        return equipmentAtAddressRepository.findById(id).orElse(null);
    }
}
