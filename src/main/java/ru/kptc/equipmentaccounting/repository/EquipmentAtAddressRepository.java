package ru.kptc.equipmentaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kptc.equipmentaccounting.dao.EquipmentAtAddressDao;

import java.util.List;

@Repository
public interface EquipmentAtAddressRepository extends JpaRepository<EquipmentAtAddressDao, Long> {
    List<EquipmentAtAddressDao> findAll();
}
