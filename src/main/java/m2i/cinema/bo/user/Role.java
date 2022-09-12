package m2i.cinema.bo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@Table(name="role")
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Role extends GenericBean {

	@Column(name = "role_name")
	private String name;
	
	public Role() {}
}
