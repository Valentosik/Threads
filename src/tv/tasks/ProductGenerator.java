package tv.tasks;

import tv.WareHouse;
import tv.product.Product;
import tv.product.type.Size;

import java.util.Random;

public class ProductGenerator implements Runnable {

    private WareHouse wareHouse;
    private String threadName;

    public ProductGenerator(WareHouse wareHouse, String threadName) {
        this.wareHouse = wareHouse;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true) {
            if (wareHouse.getCurrentSize() < 90) {
                Thread.currentThread().setName("Generate product" +  threadName);
                wareHouse.add(new Product());
                System.out.println("current size" + wareHouse.getCurrentSize());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)]; // Зачекировать
    }


}
