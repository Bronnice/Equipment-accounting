package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kptc.equipmentaccounting.dao.EquipmentDataDao;
import ru.kptc.equipmentaccounting.dao.SystemBlockDao;
import ru.kptc.equipmentaccounting.service.EquipmentDataService;

@Controller
@RequiredArgsConstructor
public class EquipmentDataController {
    private final EquipmentDataService equipmentDataService;

    @GetMapping(value = "/fullData/{id}")
    public String mainPage(Model model, @PathVariable("id") Long equipmentId) {
        EquipmentDataDao equipmentData = equipmentDataService.getByEquipmentId(equipmentId).get();
        SystemBlockDao systemBlock = equipmentData.getSystemBlock();

        model.addAttribute("systemBlock", systemBlock);
        model.addAttribute("floor", equipmentData.getFloor());
        model.addAttribute("room", equipmentData.getRoom());
        return "equipmentData";
    }
}
