package metier.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DAO.entities.IReservationDao;
import beans.Reservation;
import beans.User;

public class ReservationDaoImplementation implements IReservationDao{

	@Override
	public Reservation save(Reservation a) throws SQLException {
		// TODO Auto-generated method stub
        PreparedStatement ps = null;
        System.out.println("hello");
        System.out.println(a.id_user);
        Connection connection = DAO.entities.Connection.getConnection();
        	ps = connection.prepareStatement("INSERT INTO public.\"Reservation\"(\r\n" + 
        			"	 email, \"Desc\", \"Date\", active, \"Id_user\")\r\n" + 
        			"	VALUES ( ?, ?, ?, ?, ?);");
        	ps.setString(1, a.getEmail());
        	ps.setString(2, a.getDesc());
        	ps.setString(3,a.getDate_reservation());
        	ps.setBoolean(4,false);
        	ps.setInt(5,a.id_user);
            ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT Max(id)	FROM public.\"Reservation\"");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt("max"));
			}
		ps.close();
		return a;
	}
	

	@Override
	public List<Reservation> PriductParMC(String mc) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		List<Reservation> product = new ArrayList<Reservation>();
			PreparedStatement ps = connection.prepareStatement("SELECT id, title, image, prix FROM public.produit where title Like ?");
			ps.setString(1, "%"+ mc + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Reservation a = new Reservation();
				a.setId(rs.getInt("id"));
				a.setemail(rs.getString("title"));
				product.add(a);
			}
			
	

		return product;
	}

	@Override
	public List<Reservation> update(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<Reservation> rsv = new ArrayList<Reservation>();
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE public.\"Reservation\"\r\n" + 
					"	SET active=?" + "WHERE id = ?");
			ps.setBoolean(1,true);
			ps.setInt(2,id);
			ps.executeUpdate();
		rsv = getAllReservation_false();
			
			return rsv;
	}

	@Override
	public void deleteProduct(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM produit WHERE id=?");
		ps.setInt(1,id);
		ps.executeUpdate();
	}

	@Override
	public Reservation getProduct(int id){
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		Reservation product = new Reservation();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT id, title, image, prix FROM public.produit where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Reservation a = new Reservation();
				a.setId(rs.getInt("id"));
				a.setemail(rs.getString("title"));
				product = a;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return product;
		
	}

	@Override
	public List<Reservation> getAllReservation(){
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		List<Reservation> rsv = new ArrayList<Reservation>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT id, email, \"Desc\", \"Date\"\r\n" + 
					"FROM public.\"Reservation\";");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reservation a = new Reservation();
				a.setId(rs.getInt("id"));
				a.setemail(rs.getString("email"));
				a.setDesc(rs.getString("Desc"));
				a.setDate_reservation(rs.getString("Date"));
				rsv.add(a);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

			
	

		return rsv;
	}
	
	@Override
	public List<Reservation> getAllReservation_false() {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		List<Reservation> rsv = new ArrayList<Reservation>();
		try {
			PreparedStatement ps_2 = connection.prepareStatement("SELECT id, email, \"Desc\", \"Date\"\r\n" + 
					"FROM public.\"Reservation\" where active = false;");
			ResultSet rs = ps_2.executeQuery();
			while(rs.next()) {
				Reservation a = new Reservation();
				a.setId(rs.getInt("id"));
				a.setemail(rs.getString("email"));
				a.setDesc(rs.getString("Desc"));
				a.setDate_reservation(rs.getString("Date"));
				rsv.add(a);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rsv;
	}

}
