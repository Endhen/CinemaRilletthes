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
import javax.persistence.Table;

@Entity
@Table(name="rooms")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllRoom",
			query="SELECT r FROM Room r"),
	@NamedQuery(
			// find + this.class + ById 
			name="findRoomById",
			query="SELECT r FROM Room r WHERE r.id = :id")
})
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "room_name")
	private String name;
	@Column(name = "prm_access")
	private boolean PRMAcess;
	@Column(name = "experience_4dx")
	private boolean experience4DX;
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			orphanRemoval = true)
	private List<Section> sections;

	public Room() {}
	public Room(
			String name, 
			boolean PRMAcess, 
			boolean experience4DX,
			List<Section> sections) {
		this.name = name;
		this.PRMAcess = PRMAcess;
		this.experience4DX = experience4DX;
		this.sections = sections;
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

	public boolean isPRMAcess() {
		return PRMAcess;
	}

	public void setPRMAcess(boolean PRMAcess) {
		this.PRMAcess = PRMAcess;
	}

	public boolean isExperience4DX() {
		return experience4DX;
	}

	public void setExperience4DX(boolean experience4DX) {
		this.experience4DX = experience4DX;
	}
	
	public List<Section> getGroups() {
		return sections;
	}

	public void setGroups(List<Section> sections) {
		this.sections = sections;
	}
}
