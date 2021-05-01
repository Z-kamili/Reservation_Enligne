package beans;

import java.io.InputStream;
import java.util.Date;

public class Reservation {
	int id;
	String email;
	String Desc;
	String date_reservation;
	boolean active;
	public int id_user;
	
	
	public Reservation(String email,String desc,String date_reservation,int id_user){
		// TODO Auto-generated constructor stub
		
		this.email = email;
		this.Desc = desc;
		this.date_reservation = date_reservation;
		this.id_user = id_user;
		
	}
	

	
	public Reservation() {
		
	}
	
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public int getId_user() {
		return id_user;
	}



	public void setId_user(int id_user) {
		this.id_user = id_user;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(String date_reservation) {
		this.date_reservation = date_reservation;
	}
	
}
