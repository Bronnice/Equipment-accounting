package ru.kptc.equipmentaccounting.pojo;

public enum EquipmentType {
    SCANNER("Сканер"),
    SYSTEM_BLOCK("Системный блок"),
    MONITOR("Монитор"),
    PRINTER("Принтер");

    private final String rusValue;

    public String getRusValue() {
        return rusValue;
    }

    EquipmentType(String rusValue) {
        this.rusValue = rusValue;
    }

    /**
     * Получить элемент енама оборудования по строке
     *
     * @param name название типа оборудования
     * @return элемент енама оборудования
     */
    public static EquipmentType valueOfByRusName(String name) {
        try {
             return valueOf(name);
        } catch (IllegalArgumentException e) {
            return switch (name) {
                case "Сканер" -> SCANNER;
                case "Системный блок" -> SYSTEM_BLOCK;
                case "Монитор" -> MONITOR;
                case "Принтер" -> PRINTER;
                default -> throw e;
            };
        }
    }
}
