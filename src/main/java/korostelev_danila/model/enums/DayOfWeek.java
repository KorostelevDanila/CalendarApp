package korostelev_danila.model.enums;

public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public DayOfWeek next() {
        int newIndex = this.ordinal() + 1;
        if (newIndex > 6) {
            newIndex = 0;
        }
        return values()[newIndex];
    }
}
