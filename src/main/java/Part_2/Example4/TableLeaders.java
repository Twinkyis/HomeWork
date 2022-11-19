package Part_2.Example4;

import dao.CarService;
import dao.Cars;
import java.sql.SQLException;
import java.util.List;

public class TableLeaders extends Thread{

    public void run () {

        try {
            Car.concurrencyControl.latch2.await();

            CarService carService = new CarService();
            List<Cars> d = carService.getAllProduct();
            System.out.println(d);

        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
