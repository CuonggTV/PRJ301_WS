/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.ServiceDao;
import dto.ValidateError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validation.ServiceValidation;

/**
 *
 * @author PC
 */
public class CreateServiceController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        
        ServiceValidation sv = new ServiceValidation();
        sv.setName(req.getParameter("name"));
        sv.setDetails(req.getParameter("details"));
        sv.setMinimumWeight(Float.parseFloat(req.getParameter("weightMinimum")));
        sv.setMinimumWeight(Float.parseFloat(req.getParameter("weightMaximum")));
        
         List<ValidateError> errors = sv.validate();

        if(errors.isEmpty()){
            req.setAttribute("result",ServiceDao.createService(sv));
        }
        else{
            req.setAttribute("oldInput", sv);
            req.setAttribute("errors", errors);
            req.setAttribute("result",false);
        }
        req.getRequestDispatcher("/JSP/Admin/CreateService.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/JSP/Admin/CreateService.jsp").forward(req, resp);
    }
    
}
