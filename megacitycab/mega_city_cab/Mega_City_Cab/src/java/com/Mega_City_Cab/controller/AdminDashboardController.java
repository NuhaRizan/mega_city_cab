package com.Mega_City_Cab.controller;

import com.Mega_City_Cab.dao.BookingDAO;
import com.Mega_City_Cab.dao.CarDAO;
import com.Mega_City_Cab.dao.DriverDAO;
import com.Mega_City_Cab.model.Booking;
import com.Mega_City_Cab.model.Car;
import com.Mega_City_Cab.model.Driver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/auth") // Optional annotation for mapping
public class AdminDashboardController extends HttpServlet {
    private BookingDAO bookingDAO;
    private CarDAO carDAO;
    private DriverDAO driverDAO;

    public void init() {
        bookingDAO = new BookingDAO();
        carDAO = new CarDAO();
        driverDAO = new DriverDAO();
    }

    // Handle GET requests (view bookings, cars, and drivers)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookings = bookingDAO.getAllBookings();
        List<Car> cars = carDAO.getAllCars();
        List<Driver> drivers = driverDAO.getAllDrivers();

        request.setAttribute("bookings", bookings);
        request.setAttribute("cars", cars);
        request.setAttribute("drivers", drivers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST requests (add new car, driver)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carModel = request.getParameter("carModel");
        String carNumberPlate = request.getParameter("carNumberPlate");
        String carType = request.getParameter("carType");

        String driverName = request.getParameter("driverName");
        String phoneNumber = request.getParameter("phoneNumber");
        String licenseNumber = request.getParameter("licenseNumber");

        // Add new car
        if (carModel != null && !carModel.isEmpty()) {
            Car car = new Car();
            car.setCarModel(carModel);
            car.setCarNumberPlate(carNumberPlate);
            car.setCarType(carType);
            carDAO.addCar(car);
        }

        // Add new driver
        if (driverName != null && !driverName.isEmpty()) {
            Driver driver = new Driver();
            driver.setDriverName(driverName);
            driver.setPhoneNumber(phoneNumber);
            driver.setLicenseNumber(licenseNumber);
            driverDAO.addDriver(driver);
        }

        // Redirect to the admin dashboard
        response.sendRedirect("AdminDashboardController");
    }
}
