package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String newPassword = request.getParameter("newpassword");

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET password=? WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, username);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                request.setAttribute("message", "Password updated successfully");
            } else {
                request.setAttribute("message", "User not found");
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Database error");
        }

        RequestDispatcher rd = request.getRequestDispatcher("updatePassword.jsp");
        rd.forward(request, response);
    }
}