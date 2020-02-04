package mieibeans;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.lang.String;

public class AccessBean {
  
    String parola;
    Connection connection;
    static String dbPath;
    static String databaseURL;
    String[] elenco;

    String significato;

    public AccessBean(String databaseURL){
        
    }

    public AccessBean(){
        
    }
    public void setParola(String p){
        parola = p;
    }
    public String getParola(){
        try {
            StringBuilder ulList = new StringBuilder();
            ulList.append("<select name=\"parola\">");
            connection = DriverManager.getConnection(databaseURL);
            Statement st = connection.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM Words WHERE 'Parola' = 'parola' ");
            while (result.next()) {
                String p = result.getString("parola");
                return p;
                }
            }
            catch (SQLException ex) {
            ex.printStackTrace();
            return "Errore, la parola da te cercata non è all'interno del dizionario!";
        }
        return parola;
    }


    public String getSignificato(){
        try {
            connection = DriverManager.getConnection(databaseURL);
            Statement st = connection.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM Words WHERE 'Significato'='significato' ");
            while (result.next()) {
                significato = result.getString("parola");
            }
            System.out.println("return significato: " + significato);
            return significato;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Errore, parola non trovata nel dizionario";
        } 
    }

    public static void aggiungiParola(String parola, String significato){
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            Statement st = connection.createStatement(); 
            String s = "INSERT INTO Dizionario (parola, significato) VALUES ('" + parola + "','" + significato + "');";
            st.execute(s);
            System.out.println("Parola inserita nel db");
        } catch (SQLException ex) {
            System.out.println("Errore nell'aggiunta della parola nel db!");
            ex.printStackTrace();
        }    
    }
}