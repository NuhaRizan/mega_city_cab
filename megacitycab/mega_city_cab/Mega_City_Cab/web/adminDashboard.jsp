<%-- 
    Document   : adminDashboard
    Created on : Mar 10, 2025, 4:18:47 PM
    Author     : Nuha Rizan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        h2, h3 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #2ebf91;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #f1f1f1;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            background: #2ebf91;
            color: white;
            border: none;
            cursor: pointer;
            transition: 0.3s;
        }
        input[type="submit"]:hover {
            background: #259b76;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Dashboard</h2>

        <h3>Bookings</h3>
        <table>
            <tr>
                <th>Order Number</th>
                <th>Customer Name</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Destination</th>
            </tr>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.orderNumber}</td>
                    <td>${booking.customerName}</td>
                    <td>${booking.address}</td>
                    <td>${booking.telephone}</td>
                    <td>${booking.destination}</td>
                </tr>
            </c:forEach>
        </table>

        <h3>Cars</h3>
        <table>
            <tr>
                <th>Car Model</th>
                <th>Car Number Plate</th>
                <th>Car Type</th>
            </tr>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.carModel}</td>
                    <td>${car.carNumberPlate}</td>
                    <td>${car.carType}</td>
                </tr>
            </c:forEach>
        </table>

        <h3>Drivers</h3>
        <table>
            <tr>
                <th>Driver Name</th>
                <th>Phone Number</th>
                <th>License Number</th>
            </tr>
            <c:forEach var="driver" items="${drivers}">
                <tr>
                    <td>${driver.driverName}</td>
                    <td>${driver.phoneNumber}</td>
                    <td>${driver.licenseNumber}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="form-container">
            <h3>Add New Car</h3>
            <form action="AdminDashboardController" method="post">
                <input type="text" name="carModel" placeholder="Car Model" required>
                <input type="text" name="carNumberPlate" placeholder="Car Number Plate" required>
                <input type="text" name="carType" placeholder="Car Type" required>
                <input type="submit" value="Add Car">
            </form>
        </div>

        <div class="form-container">
            <h3>Add New Driver</h3>
            <form action="AdminDashboardController" method="post">
                <input type="text" name="driverName" placeholder="Driver Name" required>
                <input type="text" name="phoneNumber" placeholder="Phone Number" required>
                <input type="text" name="licenseNumber" placeholder="License Number" required>
                <input type="submit" value="Add Driver">
            </form>
        </div>
    </div>
</body>
</html>
