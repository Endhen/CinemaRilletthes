package bo.users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bo.Address;
import bo.services.Reservation;

@Entity
@Table(name="client")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllClient",
			query="SELECT c FROM Client c"),
	@NamedQuery(
			// find + this.class + ById 
			name="findClientById",
			query="SELECT c FROM Client c WHERE c.id = :id")
})
public class Client  extends User {
	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			optional = false)
	private Address address;
	@Column(name = "birthday")
	private LocalDate birthday;
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Reservation> reservations = null;
	
	public Client(
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			Address address,
			LocalDate birthday, 
			LocalDateTime creationDate) {
		super(firstName, lastName, email, password);
		this.address = address;
		this.birthday = birthday;
		this.creationDate = creationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
