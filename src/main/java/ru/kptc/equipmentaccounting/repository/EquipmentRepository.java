package ru.kptc.equipmentaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kptc.equipmentaccounting.dao.EquipmentDao;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentDao, Long>{
    List<EquipmentDao> findAllByEquipmentAtAddressId(Long equipmentAtAddressId);

    @Override
    void deleteById(Long id);

    EquipmentDao save(EquipmentDao equipmentDao);
}
