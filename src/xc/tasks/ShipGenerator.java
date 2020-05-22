package xc.tasks;

import xc.Tunnel;
import xc.ships.Ship;
import xc.ships.types.Size;
import xc.ships.types.Type;

import java.util.Random;

public class ShipGenerator implements Runnable {

    private Tunnel tunnel;
    private int shipCount;


    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }


    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Generate ship");
            count++;
            tunnel.add(new Ship(getRandomType(), getRandomSize()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)]; // Зачекировать
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)]; // Зачекировать
    }
}
