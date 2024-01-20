/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Customer;

import dao.CustomerDao;
import dto.Customer;
import dto.ValidateError;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validation.RegisterValidtion;

/**
 *
 * @author USER
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterValidtion rv = new RegisterValidtion();
        rv.setUsername(req.getParameter("username"));
        rv.setPassword(req.getParameter("password"));
        rv.setName(req.getParameter("name"));
        rv.setEmail(req.getParameter("email"));
        rv.setDob(req.getParameter("dob"));
        rv.setPhoneNumber(req.getParameter("phoneNumber"));

        List<ValidateError> errors = rv.validate();

        if(errors.isEmpty()){
            System.out.println("Register success");
        }
        else{
            req.setAttribute("oldInput", rv);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Register.jsp").forward(req, resp);
    }
    
    
}
