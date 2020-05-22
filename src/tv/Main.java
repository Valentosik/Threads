package tv;

import tv.tasks.Loaders;
import tv.tasks.ProductGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        WareHouse wareHouse = new WareHouse();
        ProductGenerator productGenerator = new ProductGenerator(wareHouse, "Generator");
        ProductGenerator productGenerator2 = new ProductGenerator(wareHouse, "Generator2");
        Loaders loaders1 = new Loaders(wareHouse, "loader1");
        Loaders loaders2 = new Loaders(wareHouse, "loader2");

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(productGenerator);
        service.execute(productGenerator2);
        service.execute(loaders1);
        service.execute(loaders2);
        service.shutdown();
    }
}
