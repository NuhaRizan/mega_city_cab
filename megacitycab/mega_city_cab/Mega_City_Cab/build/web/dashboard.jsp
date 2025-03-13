<%-- 
    Document   : dashboard
    Created on : Mar 10, 2025, 4:02:34 PM
    Author     : Nuha Rizan
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        h2, h3 {
            color: #333;
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
        .view-bookings {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #2ebf91;
            font-weight: bold;
            transition: 0.3s;
        }
        .view-bookings:hover {
            color: #259b76;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Dashboard</h2>
        
        <form action="BookingController" method="post">
            <h3>Add New Booking</h3>
            <input type="text" name="orderNumber" placeholder="Order Number" required>
            <input type="text" name="customerName" placeholder="Customer Name" required>
            <input type="text" name="address" placeholder="Address" required>
            <input type="text" name="telephone" placeholder="Telephone" required>
            <input type="text" name="destination" placeholder="Destination" required>
            <input type="submit" value="Add Booking">
        </form>

        <a href="BookingController" class="view-bookings">View All Bookings</a>
    </div>
</body>
</html>
