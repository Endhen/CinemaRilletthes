package m2i.cinema.bo.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.location.Address;
import m2i.cinema.bo.service.Reservation;

@Data @Entity
@Table(name="clients")
@EqualsAndHashCode(callSuper=false)
public class Client extends User {

	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, // EAGER
			optional = false)
	private Address address;

	private LocalDate birthday;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Reservation> reservations = null;

	// public Client(
	// 		String firstName, 
	// 		String lastName, 
	// 		String email, 
	// 		String password, 
	// 		Address address, 
	// 		LocalDate birthday,
	// 		LocalDateTime creationDate, 
	// 		List<Reservation> reservations) {
	// 	super(firstName, lastName, email, password);
	// 	this.address = address;
	// 	this.birthday = birthday;
	// 	this.creationDate = creationDate;
	// 	this.reservations = reservations;
	// }

}
