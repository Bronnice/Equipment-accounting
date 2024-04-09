package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kptc.equipmentaccounting.service.EquipmentAtAddressService;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final EquipmentAtAddressService equipmentAtAddressService;

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("equipmentList", equipmentAtAddressService.getAllEquipment());
        return "mainPage";
    }

    @GetMapping("/redirect/{id}")
    public String redirectToEquipmentManage(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", id);
        return "redirect:/data/{id}";
    }
}