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
@Table(name = "scanners")
@AllArgsConstructor
@NoArgsConstructor
public class ScannerDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private boolean isAvailableAutoGive;
    private String paperMaxFormat;
}
