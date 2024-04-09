package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "monitor")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private double diagonal;
    private String resolution;
}
