package tv;

import tv.product.Product;
import tv.product.type.Size;
import xc.Tunnel;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private List<Product> store;
    private int maxSize = 120;
    private int minSize = 0;
    private int currentSize = 0;

    public WareHouse() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Product element) {
        try {
            if (currentSize < maxSize) {
                notifyAll();
                store.add(element);
                String info = String.format("The product add in the storehouse:" + Thread.currentThread().getName());
                System.out.println(info);
                currentSize++;
            } else {
                System.out.println(store.size() + "There is no place for product's " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Product get() {
        try {

            if (currentSize > minSize) {
                Product a = store.remove(store.size() - 1);
                currentSize--;
                return a;
            }

            wait();
            System.out.println("No product's in storeHouse");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
