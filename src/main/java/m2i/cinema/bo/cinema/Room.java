package m2i.cinema.bo.cinema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericEntity;

@Data @Entity
@AllArgsConstructor
@Table(name="rooms")
@EqualsAndHashCode(callSuper=false)
public class Room extends GenericEntity {

	@Column(name = "room_name")
	private String name;

	@Column(name = "prm_access")
	private boolean PRMAcess;

	@Column(name = "experience_4dx")
	private boolean experience4DX;

	@OneToMany( // Bidirectionnal
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			orphanRemoval = true)
	private List<Section> sections;

	public Room() {}
}
