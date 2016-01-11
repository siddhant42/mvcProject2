package com.data;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
	boolean save(String message,Date date,double latitude,double longitude) throws SQLException, ClassNotFoundException;
	Spittle findOne(long id)throws SQLException,ClassNotFoundException;
}

