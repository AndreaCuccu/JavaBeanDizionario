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
            ResultSet result = st.executeQuery("SELECT * FROM Words WHERE 'parola' = parola");
            while (result.next()) {
                significato = result.getString("parola");
            }
            System.out.println("significato: " + significato);
            return significato;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Errore, parola non trovata nel dizionario";
        } 
    }

    public static void eliminaParola(String parola){
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            Statement st = connection.createStatement(); 
            String s = "DELETE 'parola' INTO Words WHERE 'parola' = parola";
            st.execute(s);
            System.out.println("Parola eliminata correttamente dal db");
        } catch (SQLException ex) {
            System.out.println("Errore nella cancellazione della parola dal db, riprova");
            ex.printStackTrace();
        }    
    }
    public static void aggiungiParola(String parola, String significato){
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            Statement st = connection.createStatement(); 
            String s = "INSERT INTO Dizionario (parola, significato) VALUES ('" + parola + "','" + significato + "');";
            st.execute(s);
            System.out.println("Parola aggiunta correttamente dal db");
        } catch (SQLException ex) {
            System.out.println("Errore nella aggiunta della parola dal db, controllare la connessione di rete e riprovare!");
            ex.printStackTrace();
        }    
    }
    public static void modificaParola(String parola, String significato){
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            Statement st = connection.createStatement(); 
            String s = "UPDATE `Words` SET `Parola`="+parola+",`Significato` ="+significato;
            st.execute(s);
            System.out.println("Parola modificata correttamente dal db");
        } catch (SQLException ex) {
            System.out.println("Errore nella modifica della parola dal db, controllare la connessione di rete e riprovare!");
            ex.printStackTrace();
        }
    }
}