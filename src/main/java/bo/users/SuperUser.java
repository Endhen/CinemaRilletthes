package bo.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bo.cinemas.Cinema;

@Entity
@Table(name="super_user")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllSuperUser",
			query="SELECT s FROM SuperUser s"),
	@NamedQuery(
			// find + this.class + ById 
			name="findSuperUserById",
			query="SELECT s FROM SuperUser s WHERE s.id = :id")
})
public class SuperUser extends User {
	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private Role role;
	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private Cinema cinema;
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Request> requests = null;

	public SuperUser(
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			Role role, 
			Cinema cinema) {
		super(firstName, lastName, email, password);
		this.role = role;
		this.cinema = cinema;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
}
