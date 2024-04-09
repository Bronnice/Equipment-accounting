package ru.kptc.equipmentaccounting.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "equipment_data")
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDataDao {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private byte floor;
    private int room;
    @OneToOne
    @JoinColumn(name="equipmentId")
    private EquipmentDao equipment;
    @OneToOne
    @JoinColumn(name="monitorId")
    private MonitorDao monitor;
    @OneToOne
    @JoinColumn(name="printerId")
    private PrinterDao printer;
    @OneToOne
    @JoinColumn(name="scannerId")
    private ScannerDao scanner;
    @OneToOne
    @JoinColumn(name="systemBlockId")
    private SystemBlockDao systemBlock;
}
