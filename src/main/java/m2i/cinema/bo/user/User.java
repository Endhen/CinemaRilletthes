
package m2i.cinema.bo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericEntity;

@Data @Entity
@Table(name="user")
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public abstract class User extends GenericEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_pwd")
	private String password;

	public User() {}
}
