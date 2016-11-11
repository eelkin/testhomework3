/*
Copyright (c) 2016 Christy Smith
Campus Box 7915, Elon University, Elon, NC 27244

Copyright (c) 2016 Evan Elkin
Campus Box 7947, Elon University, Elon, NC 27244

Copyright (c) 2016 Breslin Wiley
Campus Box 7947, Elon University, Elon, NC 27244
*/
package controller;

import model.Calculator;
import model.FutureValueCalculator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
      HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        
      
        String url = "/index.jsp";
        
      String action = request.getParameter("action");
        
      if (action == null) {
        action = "join";
      }
        
      if (action.equals("join")) {
        url = "/index.jsp";
      }
      else if (action.equals("add")) {
        String amount = request.getParameter("amount");
        String rate = request.getParameter("rate");
        String years = request.getParameter("years");
        
        /*
        Cookie cookie = new Cookie("productCode", "8601");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        cookie.setPath("/");
        */
        
        session.setAttribute("years", years);
        session.setAttribute("rate", rate);
        session.setAttribute("amount",amount);
        session.setMaxInactiveInterval(-1);
        
        double investmentAmount = Integer.parseInt(amount);
        double yearlyInterestRate = Integer.parseInt(rate);
        int numberOfYears = Integer.parseInt(years);
        
        Calculator calculator = new Calculator(investmentAmount,
          yearlyInterestRate, numberOfYears);    
        request.setAttribute("calculator", calculator);
        
        Calculator[] calculators = new Calculator[numberOfYears];
        for(int i = 0; i < numberOfYears; i++) {
            calculators[i] = new Calculator(investmentAmount, yearlyInterestRate, i+1);
        }
        request.setAttribute("calculators", calculators);
        
        url = "/thanks.jsp";
        }
        
      getServletContext().getRequestDispatcher(url)
        .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, 
      HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

}

