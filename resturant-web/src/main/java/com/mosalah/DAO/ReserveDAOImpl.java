package com.mosalah.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mosalah.models.Reservation;
import com.mosalah.rowmappers.ReserveRowMapper;

public class ReserveDAOImpl implements ReserveDAO {
	
	
	
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public ReserveDAOImpl (DataSource dataSourcce ) {
		jdbcTemplate = new JdbcTemplate(dataSourcce);
	}
	

	 @Override
	public List<Reservation> getAllreservation(String username) {
		
		String sql ="SELECT * FROM `reservations` WHERE customerName=?";
		List<Reservation> reservations = jdbcTemplate.query(sql, new Object[] {username},new ReserveRowMapper());
		return reservations;	
	}

	@Override
	public void saveReservation(Reservation reserve) {
		Object[] reserveInfo = {
				reserve.getCustomerName(),	reserve.getResturantName(),reserve.getnOFtables(),reserve.getnOFchairs(),
				reserve.getDate(),reserve.getTime()
				};
		String sql = "INSERT INTO `reservations`(`customerName`, `resturantName`, `nOFtables`, `nOFchairs`, `date`, `time`) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,reserveInfo);
		System.out.println("inserted successfully !");
		
	}

	@Override
	public Reservation getRserveById(int id) {
		String sql ="SELECT * FROM `reservations` WHERE id=?" ;
		return jdbcTemplate.queryForObject(sql,new Object[]{id},new ReserveRowMapper());
	}

	@Override
	public int update(Reservation reserve) {
		String sql = "UPDATE `reservations` SET `customerName`='"+reserve.getCustomerName()+"',"
				+ "`resturantName`='"+reserve.getResturantName()+"',`nOFtables`='"+reserve.getnOFtables()+"',`nOFchairs`='"+reserve.getnOFchairs()+"',"
						+ "`date`='"+reserve.getDate()+"',`time`='"+reserve.getTime()+"' WHERE id="+reserve.getId();
	
     return jdbcTemplate.update(sql);
	}

	
	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `reservations` WHERE id="+id;
		return jdbcTemplate.update(sql);
	}

	
	
    @Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

}
