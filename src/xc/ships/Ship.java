package xc.ships;

import xc.ships.types.Size;
import xc.ships.types.Type;

public class Ship {
    private int count; // Сколько товаров погружено
    private Size size;
    private Type type;

    public Ship(Type type, Size size) {
        this.size = size;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }


}
