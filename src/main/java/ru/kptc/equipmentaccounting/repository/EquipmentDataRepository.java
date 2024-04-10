package ru.kptc.equipmentaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kptc.equipmentaccounting.dao.EquipmentDataDao;

import java.util.Optional;

@Repository
public interface EquipmentDataRepository extends JpaRepository<EquipmentDataDao, Long> {
    Optional<EquipmentDataDao> findByEquipmentId(Long equipmentId);
}