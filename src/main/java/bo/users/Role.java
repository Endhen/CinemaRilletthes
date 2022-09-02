package bo.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="role")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllRole",
			query="SELECT r FROM Role r"),
	@NamedQuery(
			// find + this.class + ById 
			name="findRoleById",
			query="SELECT r FROM Role r WHERE r.id = :id")
})
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "role_name")
	private String name;
	
	public Role(String name) {
		this.name = name;
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
}
