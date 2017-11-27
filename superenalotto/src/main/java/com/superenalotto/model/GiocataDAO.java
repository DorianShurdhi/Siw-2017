package com.superenalotto.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GiocataDAO {
	Connection conn=null;
	
	public GiocataDAO() {
		super();
		conn = DAO.getConnection();
	}

	public void addGiocata(int id_utente, String num_giocate, String num_estratti) throws SQLException{
        if(conn==null) conn=DAO.getConnection();
        Statement st = conn.createStatement();
        
        
        st.executeUpdate("insert into giocate (id_utente, num_giocate, num_estratti) "
        	+ "values('"+id_utente+"', '"+num_giocate+"', '"+num_estratti+"')");
	}
}
