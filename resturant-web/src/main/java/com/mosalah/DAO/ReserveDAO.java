package com.mosalah.DAO;

import java.util.List;

import javax.sql.DataSource;

import com.mosalah.models.Reservation;

public interface ReserveDAO {

	
	
	

		List<Reservation>getAllreservation( String username );
		void saveReservation(Reservation reserve);
		Reservation getRserveById(int id);
		int update(Reservation reserve);
		int delete(int id);
		
		public void setDataSource(DataSource dataSource);
	
		
		
	
}
