/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.Certificate.CertificateDAO;
import pe.Certificate.CertificateDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null || action.equals("login") ||  action.equals("list")) {

            CertificateDAO dao = new CertificateDAO();
            List<CertificateDTO> list = dao.getAllCertificate();

            request.setAttribute("list", list);
            request.getRequestDispatcher("certificates.jsp").forward(request, response);

        } else if (action.equals("details")) {

            String id = request.getParameter("id");
            CertificateDAO dao = new CertificateDAO();
            CertificateDTO c = dao.getDetail(id);

            request.setAttribute("detail", c);
            request.getRequestDispatcher("detail.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            String id = request.getParameter("id");
            CertificateDAO dao = new CertificateDAO();
            dao.delete(id);
            response.sendRedirect("MainController");
        } else if (action.equals("create")) {

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String issuer = request.getParameter("issuer");
            String issuedate = request.getParameter("issuedate");

            CertificateDAO dao = new CertificateDAO();
            dao.create(id, name, issuer, issuedate);

            response.sendRedirect("MainController");
        } else if (action.equals("edit")) {

            String id = request.getParameter("id");
            CertificateDAO dao = new CertificateDAO();
            CertificateDTO c = dao.getDetail(id);

            request.setAttribute("detailc", c);
            request.getRequestDispatcher("edit.jsp").forward(request, response);

        } else if (action.equals("update")) {

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String issuer = request.getParameter("issuer");
            String issuedatte = request.getParameter("issuedate");

            CertificateDAO dao = new CertificateDAO();
            dao.update(id, name, issuer, issuedatte);

            response.sendRedirect("MainController");
        } else if (action.equals("createPage")) {
            CertificateDAO dao = new CertificateDAO();
            int newId = dao.getMaxCertificateId() + 1; // Tự động tăng ID

            request.setAttribute("newId", newId); // Gửi ID mới sang JSP
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else if (action.equals("search")) {
            String keyword = request.getParameter("keyword");
            
            if (keyword == null) {
                keyword = "";
            }
            
            CertificateDAO dao = new CertificateDAO();
            List<CertificateDTO> list = dao.search(keyword);
            request.setAttribute("keyword", keyword);
            request.setAttribute("list", list);
            request.getRequestDispatcher("certificates.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Lấy session hiện tại (không tạo mới)

        if (session == null || session.getAttribute("usersession") == null) {
            response.sendRedirect("login.jsp"); // Chặn truy cập nếu chưa đăng nhập
            return;
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Lấy session hiện tại (không tạo mới)

        if (session == null || session.getAttribute("usersession") == null) {
            response.sendRedirect("login.jsp"); // Chặn truy cập nếu chưa đăng nhập
            return;
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
