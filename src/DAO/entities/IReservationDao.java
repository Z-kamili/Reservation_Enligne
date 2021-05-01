package DAO.entities;

import java.sql.SQLException;
import java.util.List;

import beans.Reservation;

public interface IReservationDao {
	
	public Reservation save(Reservation a) throws SQLException ;
	public List<Reservation> PriductParMC(String mc) throws SQLException;
	public List<Reservation> update(int id) throws SQLException;
	public void deleteProduct(int id) throws SQLException;
	public Reservation getProduct(int id);
	public List<Reservation> getAllReservation();
	public List<Reservation> getAllReservation_false();

}
