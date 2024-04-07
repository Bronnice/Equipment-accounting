package ru.kptc.equipmentaccounting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kptc.equipmentaccounting.converter.Converter;
import ru.kptc.equipmentaccounting.pojo.EquipmentAtAddress;
import ru.kptc.equipmentaccounting.repository.EquipmentAtAddressRepository;
import ru.kptc.equipmentaccounting.repository.EquipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipmentAtAddressService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentAtAddressRepository equipmentAtAddressRepository;

    public List<EquipmentAtAddress> getAllEquipment() {
        log.info("Get all equipment");
        return Converter.equipmentAtAddressDaoToPojo(equipmentAtAddressRepository.findAll());
    }
}
