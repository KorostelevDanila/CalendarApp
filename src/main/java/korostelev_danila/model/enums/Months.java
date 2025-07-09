package korostelev_danila.model.enums;

public enum Months {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public Months next() {
        int newIndex = this.ordinal() + 1;
        if (newIndex > 11) {
            newIndex = 0;
        }
        return values()[newIndex];
    }
}
