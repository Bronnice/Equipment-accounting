package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/{}/saveData")
    public ResponseEntity<String> saveData(@RequestBody EquipmentDataDto dataDto) {
        try {
            equipmentDataService.saveData(dataDto);
            return ResponseEntity.ok("Данные успешно сохранены");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Произошла ошибка при сохранении данных");
        }
    }
}
