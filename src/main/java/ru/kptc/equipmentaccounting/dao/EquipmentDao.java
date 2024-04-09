package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "equipment")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EquipmentDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String model;
    private String inventoryNumber;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name="equipmentAtAddressId", nullable=false)
    private EquipmentAtAddressDao equipmentAtAddress;
    @OneToOne(mappedBy = "equipment")
    private EquipmentDataDao equipmentData;
}
