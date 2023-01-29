package m2i.cinema.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.cinema.Cinema;

@Data @Entity
@Table(name="super_users")
@EqualsAndHashCode(callSuper=false)
public class SuperUser extends User {

	@OneToOne(
			cascade = CascadeType.MERGE, 
			fetch = FetchType.LAZY) // EAGER
	private Role role;

	@OneToOne(
			cascade = CascadeType.MERGE, 
			fetch = FetchType.LAZY)
	private Cinema cinema;

	@OneToMany(
			cascade = CascadeType.MERGE, 
			fetch = FetchType.LAZY)
	private List<Request> requests = null;

	// public SuperUser(
	// 		String firstName, 
	// 		String lastName, 
	// 		String email, 
	// 		String password, 
	// 		Role role, 
	// 		Cinema cinema) {

	// 	super(firstName, lastName, email, password);
	// 	this.role = role;
	// 	this.cinema = cinema;
	// }
}
