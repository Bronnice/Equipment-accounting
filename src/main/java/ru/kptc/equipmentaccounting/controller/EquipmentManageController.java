package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kptc.equipmentaccounting.service.EquipmentService;

@Controller("/data")
@RequiredArgsConstructor
public class EquipmentManageController {
    private final EquipmentService equipmentService;

    @GetMapping(value = "/{:id}")
    public String getEquipmentData(@PathVariable Long id, Model model) {
        model.addAttribute("equipmentList", equipmentService.getAllEquipmentByEquipmentAtAddressId(id));
        return "equipmentManage";
    }
}
