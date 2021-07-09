package com.kgisl.batchfour;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO;
 
    public void init() {
        String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        String jdbcUsername = "root";
        String jdbcPassword = "";
 
        customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet called");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost called");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Customer newCustomer = new Gson().fromJson(requestData, Customer.class);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        System.out.println(newCustomer.getCustomerid()+" "+newCustomer.getCustomername());
 
        try {
            customerDAO.insertCustomer(newCustomer);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // response.sendRedirect("list");
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut called");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doDelete called");
    }
}
