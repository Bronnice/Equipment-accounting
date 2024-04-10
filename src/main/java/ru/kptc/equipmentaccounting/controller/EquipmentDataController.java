package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kptc.equipmentaccounting.dao.*;
import ru.kptc.equipmentaccounting.service.EquipmentDataService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EquipmentDataController {
    private final EquipmentDataService equipmentDataService;

    @GetMapping(value = "/fullData/{id}")
    public String mainPage(Model model, @PathVariable("id") Long equipmentId) {
        Optional<EquipmentDataDao> optionalEquipmentData = equipmentDataService.getByEquipmentId(equipmentId);

        if(optionalEquipmentData.isEmpty()){
            throw new IllegalArgumentException("Equipment not found");
        }

        EquipmentDataDao equipmentData = optionalEquipmentData.get();
        SystemBlockDao systemBlock = equipmentData.getSystemBlock();
        PrinterDao printer = equipmentData.getPrinter();
        MonitorDao monitor = equipmentData.getMonitor();
        ScannerDao scanner = equipmentData.getScanner();


        model.addAttribute("floor", equipmentData.getFloor());
        model.addAttribute("room", equipmentData.getRoom());

        if (systemBlock != null) {
            model.addAttribute("systemBlock", systemBlock);
            return "equipmentDataSystemBlock";
        } else if (printer != null) {
            model.addAttribute("printer", printer);
            return "equipmentDataPrinter";
        } else if (monitor != null) {
            model.addAttribute("monitor", monitor);
            return "equipmentDataMonitor";
        } else if (scanner != null) {
            model.addAttribute("scanner", scanner);
            return "equipmentDataScanner";
        }

        throw new IllegalArgumentException("Equipment not found");
    }
}
