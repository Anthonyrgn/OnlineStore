package com.jjuixyy.client.controller;

import com.jjuixyy.server.entity.Catalogue;
import com.jjuixyy.server.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkDetailsServlet", urlPatterns = ("/work-details"))
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Long id = Long.parseLong(req.getParameter("id"));

        Work work = null;

        for (Work work1 : Catalogue.listofWorks){
            if(id == work1.getId()){
                work = work1;
                break;
            }
        }

        out.println("<html><body>");
        out.println("<h1>Descriptif de l'oeuvre</h1>");
        out.println("Titre : " + work.getTitle() + "<br/>");
        out.println("Année de parution : " + work.getRelease() + " <br/>");
        out.println("Genre : " + work.getGenre() + " <br/>");
        out.println("Artiste principal " + work.getMainArtist().getName() + " <br/>");
        out.println("Resumé : " + work.getSummary() + "<br/>");
        out.println("</body></html>");
    }
}
