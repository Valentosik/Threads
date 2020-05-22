package tv.product;

import xc.ships.types.Size;

public class Product {
    private int count;
    private Size size;

    public Product(Size size) {
        this.size = size;
    }

    public Product() {

    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheck() {
        if (count >= size.getValue()) {
            return false;
        }
        return true;
    }

    public int getCount() {
        return count;
    }

    public Size getSize() {
        return size;
    }
}
