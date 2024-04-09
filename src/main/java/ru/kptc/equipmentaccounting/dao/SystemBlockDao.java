package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "system_block")
@AllArgsConstructor
@NoArgsConstructor
public class SystemBlockDao{
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String processorModel;
    private int coresCount;
    private double clockFrequency;
    private String ramType;
    private double ramCapacity;
    private int hddCapacity;
}
