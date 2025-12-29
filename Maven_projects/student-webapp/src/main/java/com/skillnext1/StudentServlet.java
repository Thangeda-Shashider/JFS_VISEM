package com.skillnext1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Student Servlet is WORKING</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        int sem = Integer.parseInt(req.getParameter("sem"));
        String dept = req.getParameter("dept");

        Student student = new Student();
        student.setName(name);
        student.setSem(sem);
        student.setDept(dept);

        StudentDAO.save(student);

        res.sendRedirect("success.jsp");
    }
}
