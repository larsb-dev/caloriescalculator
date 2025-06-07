package main;

public enum ActivityLevel {
    SEDENTARY(1.2, new String[] {"low"}),
    LIGHTLY_ACTIVE(1.375, new String[] {"light"}),
    MODERATELY_ACTIVE(1.55, new String[] {"moderate"}),
    VERY_ACTIVE(1.725, new String[] {"high"});

    private final double multiplier;
    private final String[] aliases;

    ActivityLevel(double multiplier, String[] aliases) {
        this.multiplier = multiplier;
        this.aliases = aliases;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String[] getAliases() {
        return aliases;
    }
}