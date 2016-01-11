package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.conn.MysqlConnection;
import com.exceptions.DuplicateSpittleException;
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return createSpittleList(20);
	}
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
	@Override
	public boolean save(String message, Date date, double latitude, double longitude) 
	throws SQLException,ClassNotFoundException {
		Connection conn;
		conn = MysqlConnection.getConnection();
		String query = "select message from spittle where date = "+date;
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString("message").equals(message))
				throw new DuplicateSpittleException();
		}
		query = "insert into spittle(message,date,latitude,longitue) values(?,?,?,?)";
		ps = conn.prepareStatement(query);
		int numRows = ps.executeUpdate();
		conn.close();
		if(numRows<0)
		return false;
		return true;
	}
	@Override
	public Spittle findOne(long id) throws SQLException,ClassNotFoundException {
		final Connection conn;
		conn = MysqlConnection.getConnection();
		final String query = "select * from spittle where id = "+id;
		final PreparedStatement ps = conn.prepareStatement(query);
		final boolean status = ps.execute();
		if (!status) return null;
		final ResultSet rs = ps.getResultSet();
		Spittle sp = null;
		while(rs.next()){
			sp = new Spittle(rs.getString(2),rs.getDate(3),rs.getDouble(4),rs.getDouble(5));
			
		}
		return sp;
	}
	/*public static void main(String[] args) throws SQLException,ClassNotFoundException {
		SpittleRepository sr = new SpittleRepositoryImpl();
		Spittle sp = sr.findOne(1);
		System.out.println(sp.getMessage());
	}*/
}
