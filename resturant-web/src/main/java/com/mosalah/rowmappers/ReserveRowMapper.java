package com.mosalah.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mosalah.models.Reservation;



public class ReserveRowMapper  implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                  Reservation reserve = new Reservation();
		reserve.setId(rs.getInt("id"));
		reserve.setCustomerName(rs.getString("customerName"));
		reserve.setResturantName(rs.getString("resturantName"));
		reserve.setnOFtables(rs.getInt("nOFtables"));
		reserve.setnOFchairs(rs.getInt("nOFchairs"));
		reserve.setDate(rs.getString("date"));
		reserve.setTime(rs.getString("time"));
		
		return reserve;
		
	}
}