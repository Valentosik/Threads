package tv.tasks;

import tv.WareHouse;
import tv.product.Product;

public class Loaders implements Runnable {


    private WareHouse wareHouse;
    private String threadName;

    public Loaders(WareHouse wareHouse, String threadName) {
        this.wareHouse = wareHouse;
        this.threadName = threadName;
    }





    @Override
    public void run() {
        while (true) {
            if (wareHouse.getCurrentSize() > 80) {
                Thread.currentThread().setName("Generate product" +  threadName);
                Product a = wareHouse.get();
                a = null;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
