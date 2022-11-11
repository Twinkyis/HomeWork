package dao;

import B_logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService extends Util implements CarDAO {

    Connection connection = getConnection();


    @Override
    public void addProduct(Cars carsService) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO CAR (IDCAR, NAMECAR, TOTALTIME) VALUE (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, carsService.getidCar());
            preparedStatement.setString(2, carsService.getNameCar());
            preparedStatement.setInt(3, carsService.getTotalTime());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public List<Cars> getAllProduct() throws SQLException {

        List <Cars> s = new ArrayList<>();

        String sql = "SELECT * FROM CAR";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cars Cars = new Cars();

                Cars.setidCar(resultSet.getInt("idCar"));
                Cars.setnameCar(resultSet.getString("NameCar"));
                Cars.setTotalTime(resultSet.getInt("TotalTime"));

                s.add(Cars);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return s;
    }

    @Override
    public Cars getByIdProduct(int idCar) throws SQLException {

        String sql = "SELECT IDCAR, NAMECAR, TOTALTIME FROM CAR WHERE (IDCAR=?)";

        PreparedStatement preparedStatement = null;

        Cars carsService = new Cars();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCar);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            carsService.setidCar(resultSet.getInt("idCar"));
            carsService.setnameCar(resultSet.getString("NameCar"));
            carsService.setTotalTime(resultSet.getInt("TotalTime"));

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return carsService;
    }

    @Override
    public void updateProduct(Cars carsService) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE CAR SET NAMECAR = ?, TOTALTIME = ? where IDCAR = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, carsService.getidCar());
            preparedStatement.setString(2, carsService.getNameCar());
            preparedStatement.setInt(3, carsService.getTotalTime());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void removeProduct(Cars carsService) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM CAR WHERE IDCAR = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, carsService.getidCar());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }

    public void closeConnectionProduct () throws SQLException{

        if (connection != null) {
            connection.close();
        }
    }


}
