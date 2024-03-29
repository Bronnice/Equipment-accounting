package ru.kptc.equipment_accounting.pojo;

public enum EquipmentType {
    SCANNER("Сканнер"),
    SYSTEM_BLOCK("Системный блок"),
    MONITOR("Монитор"),
    PRINTER("Принетр");

    private final String rusValue;

    public String getRusValue() {
        return rusValue;
    }

    EquipmentType(String rusValue) {
        this.rusValue = rusValue;
    }

    /**
     * Получить элемент енама оборудвания по строке
     *
     * @param name название типа оборудования
     * @return элемент енама оборудования
     */
    public static EquipmentType valueOfByRusName(String name) {
        try {
             return valueOf(name);
        } catch (IllegalArgumentException e) {
            return switch (name) {
                case "Сканнер" -> SCANNER;
                case "Системный блок" -> SYSTEM_BLOCK;
                case "Монитор" -> MONITOR;
                case "Принетр" -> PRINTER;
                default -> throw e;
            };
        }
    }
}
