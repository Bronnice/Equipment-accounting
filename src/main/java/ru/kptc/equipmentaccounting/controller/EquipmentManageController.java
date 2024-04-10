package ru.kptc.equipmentaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kptc.equipmentaccounting.dao.EquipmentAtAddressDao;
import ru.kptc.equipmentaccounting.dao.EquipmentDao;
import ru.kptc.equipmentaccounting.service.EquipmentAtAddressService;
import ru.kptc.equipmentaccounting.service.EquipmentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EquipmentManageController {
    private final EquipmentService equipmentService;
    private final EquipmentAtAddressService equipmentAtAddressService;

    @GetMapping(value = "/data/{id}")
    public String getEquipmentData(@PathVariable(value = "id") Long id, Model model) {
        List<EquipmentDao> equipmentDaoList = equipmentService.getAllEquipmentByEquipmentAtAddressId(id);
        model.addAttribute("equipmentList", equipmentDaoList);
        if (!equipmentDaoList.isEmpty()) {
            model.addAttribute("equipmentAtAddressId", equipmentDaoList.get(0).getEquipmentAtAddress().getId());
        }
        return "equipmentManage";
    }

    @PostMapping("/equipment/{equipmentAdAddressId}/create")
    public String createEquipment(@RequestParam("model") String model,
                                  @RequestParam("inventoryNumber") String inventoryNumber,
                                  @RequestParam("serialNumber") String serialNumber,
                                  @PathVariable Long equipmentAdAddressId) {
        // Создаем новый элемент оборудования с полученными данными
        EquipmentDao newEquipment = new EquipmentDao();
        newEquipment.setModel(model);
        newEquipment.setInventoryNumber(inventoryNumber);
        newEquipment.setSerialNumber(serialNumber);

        EquipmentAtAddressDao equipmentAtAddress = equipmentAtAddressService.getEquipmentById(equipmentAdAddressId);

        newEquipment.setEquipmentAtAddress(equipmentAtAddress);

        // Сохраняем новый элемент оборудования в базе данных
        equipmentService.saveEquipment(newEquipment);

        return "redirect:/data/{equipmentAdAddressId}";
    }

    // Метод для обработки POST-запроса на удаление элемента оборудования по его ID
    @PostMapping(value = "/equipment/{equipmentAdAddressId}/delete/{id}")
    public String deleteEquipment(@PathVariable("equipmentAdAddressId") Long equipmentAdAddressId, @PathVariable("id") Long id) {
        equipmentService.deleteEquipmentById(id);
        return "redirect:/data/{equipmentAdAddressId}";
    }
}
