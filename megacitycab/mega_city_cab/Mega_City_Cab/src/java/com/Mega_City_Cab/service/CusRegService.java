
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mega_City_Cab.service;


import com.Mega_City_Cab.dao.CusRegDAO;
import com.Mega_City_Cab.model.User;

public class CusRegService {
    private CusRegDAO CusRegDAO = new CusRegDAO();

    public boolean registerUser(User user) {
        return CusRegDAO.registerUser(user);
    }

    public User validateLogin(String username, String password) {
        return CusRegDAO.validateUser(username, password);
    }
}