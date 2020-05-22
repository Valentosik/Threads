package tv.product.type;

public enum Size {
    SMALL(10), MIDDLE(30), LARGE(50);

    private int value;

    Size(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
