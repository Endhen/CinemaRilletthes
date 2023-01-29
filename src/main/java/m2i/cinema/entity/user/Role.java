package m2i.cinema.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;

@Data @Entity
@Table(name="role")
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Role extends GenericEntity {

	@Column(name = "role_name")
	private String name;
	
	public Role() {}
}
