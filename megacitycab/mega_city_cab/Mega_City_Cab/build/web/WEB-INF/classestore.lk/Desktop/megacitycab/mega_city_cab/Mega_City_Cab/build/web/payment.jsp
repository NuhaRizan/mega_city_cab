<%-- 
    Document   : payment
    Created on : Mar 13, 2025, 12:40:55 AM
    Author     : Nuha Rizan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .payment-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            box-sizing: border-box;
        }

        .payment-container h1 {
            text-align: center;
            color: #333;
        }

        label {
            font-size: 14px;
            font-weight: bold;
            color: #555;
            margin-bottom: 5px;
            display: block;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="payment-container">
        <h1>Payment Form</h1>
        <form action="PaymentServlet" method="post">
            <label for="bookingId">Booking ID:</label>
            <input type="text" id="bookingId" name="bookingId" required><br><br>

            <label for="customerName">Customer Name:</label>
            <input type="text" id="customerName" name="customerName" required><br><br>

            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required><br><br>

            <label for="paymentMethod">Payment Method:</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Cash">Cash</option>
            </select><br><br>

            <input type="submit" value="Submit Payment">
        </form>

        <!-- Error message placeholder -->
        <div class="error-message"></div>
    </div>
</body>
</html>
