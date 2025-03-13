package com.Mega_City_Cab.dao;

import com.Mega_City_Cab.model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mega_city_cab";
    private static final String USER = "root"; // Change these as needed
    private static final String PASSWORD = "password"; // Change these as needed

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new car to the database
    public void addCar(Car car) {
        String query = "INSERT INTO cars (car_model, car_number_plate, car_type) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, car.getCarModel());
            stmt.setString(2, car.getCarNumberPlate());
            stmt.setString(3, car.getCarType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all cars from the database
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM cars";
        
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setCarModel(rs.getString("car_model"));
                car.setCarNumberPlate(rs.getString("car_number_plate"));
                car.setCarType(rs.getString("car_type"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
