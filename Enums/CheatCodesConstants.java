package io.github.some_example_name.Enums;

public enum CheatCodesConstants {
    TIME_EATER("Time Eater", "decreases game time by 60s"),
    LEVEL_BOOSTER("Level Booster", "increases level by 1"),
    HEART_DAHANDE("Heart Dahande", "increases hp by 1"),
    KERM_DASHTAN("Kerm Dashtan", "transfer player to a boss fight"),
    HESOYAM("Hesoyam", "makes player immortal");
    final String name;
    final String description;

    CheatCodesConstants(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
