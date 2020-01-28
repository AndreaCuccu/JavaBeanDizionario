package mieibeans;
import java.util.*;
import java.time.*;
import java.sql.*;
import java.lang.String;

public class Dizionario implements java.io.Serializable{

	private String testo;

	public Dizionario(){
		
	}
	public String getParola(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com:3306/vlIGVKqVUg?user=vlIGVKqVUg&password=bcMVQ0ApRc");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Words");
			while(rs.next()){
				testo=rs.getString("Username") + rs.getString("Parola") + rs.getString("Significato") + rs.getString("id");
				}
			return testo;
			}catch(Exception e){
			return "non va!";
			}
	}
	/*public void setParole(String val){
		testo = val;
	}
	public String getSignificato(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Words?serverTimezone=UTC","vlIGVKqVUg","bcMVQ0ApRc");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 'Significato' FROM 'Words' WHERE 1");
				return rs.getString("Significato");
				}catch(Exception e){
				return e.toString();
				}
			}
	public void setSignificato(String val){
		testo = val;
	}

		public String getUsername(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Words?serverTimezone=UTC","vlIGVKqVUg","bcMVQ0ApRc");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 'Username' FROM 'Words' WHERE 1");
				return rs.getString("Username");
				}catch(Exception e){
				return e.toString();
			}
		}

	public void setUsername(String val){
		testo = val;
	}

	public String getid(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Words?serverTimezone=UTC","vlIGVKqVUg","bcMVQ0ApRc");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT 'id' FROM 'Words' WHERE 1");
			return rs.getString("id");
			}catch(Exception e){
			return e.toString();
		}
	}
	public void setid(String val){
		testo = val;
	*/}
