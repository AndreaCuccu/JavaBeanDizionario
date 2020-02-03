package mieibeans;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dizionario extends HttpServlet {               //classe per prendere il parametro di parola e significato.

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {   //metodo post da importare negli altri file .java
  
        String parola = req.getParameter("parola");             //prendere il parametro di parola.
        String significato = req.getParameter("significato");   //prendere il parametro di significato.

        AccessBean.aggiungiParola(parola, significato);         //metodo aggiungiparola importata dalla classe accessbean.java.
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");       //richiesta da inserire in index.jsp.
        rd.forward(req,res);        
    }
}