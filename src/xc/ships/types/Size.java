package xc.ships.types;

public enum Size {
    SMALL(10), MIDDLE(50), LARDGE(100);

    private int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
