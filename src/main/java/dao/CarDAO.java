package dao;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {

    //create
    void addProduct(Cars carsService) throws SQLException;

    //read
    List<Cars> getAllProduct() throws SQLException;

    //select
    Cars getByIdProduct(int idCar) throws SQLException;

    //update
    void updateProduct(Cars carsService) throws SQLException;

    //remove
    void removeProduct(Cars carsService) throws SQLException;
}
