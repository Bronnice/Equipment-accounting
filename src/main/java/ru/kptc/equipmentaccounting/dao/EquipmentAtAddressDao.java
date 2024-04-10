package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "equipment_at_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EquipmentAtAddressDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private Integer objectCode;
    private String address;
    private String equipmentType;
    @OneToMany(mappedBy = "equipmentAtAddress")
    private Set<EquipmentDao> equipmentList;
}
