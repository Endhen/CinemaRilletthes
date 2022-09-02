package bo.cinemas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bo.Address;
import bo.users.SuperUser;

@Entity
@Table(name="cinemas")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllCinema",
			query="SELECT c FROM Cinema c"),
	@NamedQuery(
			// find + this.class + ById 
			name="findCinemaById",
			query="SELECT c FROM Cinema c WHERE c.id = :id")
})
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cinema_name")
	private String name;
	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			optional = false)
	private Address address;
//	@OneToOne(
//			cascade = CascadeType.ALL, 
//			fetch = FetchType.LAZY, 
//			optional = false)
//	private SuperUser manager; 
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private List<Room> rooms;
	
	public Cinema() {}
	public Cinema(String name, Address address, SuperUser manager, List<Room> rooms) {
		this.name = name;
		this.address = address;
//		this.manager = manager;
		this.rooms = rooms;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
//	public SuperUser getManager() {
//		return manager;
//	}
//	
//	public void setManager(SuperUser manager) {
//		this.manager = manager;
//	}
//	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}	
}
