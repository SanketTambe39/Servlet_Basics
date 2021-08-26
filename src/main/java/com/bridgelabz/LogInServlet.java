package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Testing",
        urlPatterns = {"/LogInServlet"},
        initParams = {
                @WebInitParam(name = "pwd" , value = "123")
        }
)

public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        boolean isTrueName = Pattern.compile("^[A-Z]{1}[A-z a-z]{2,}$").matcher(user).matches();
        String password = getServletConfig().getInitParameter("pwd");

        if (isTrueName && password.equals(pwd)){
            req.setAttribute("user",user);
            req.getRequestDispatcher("Success.jsp").forward(req,resp);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Please Enter Write Inputs.</font>");
            rd.include(req,resp);
        }
    }
}
