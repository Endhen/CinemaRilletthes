package m2i.cinema.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;

@Data @Entity
@AllArgsConstructor
@Table(name="requests")
@EqualsAndHashCode(callSuper=false)
public class Request extends GenericEntity {

	@Column(name = "requested_order")
	private String order;

	private String comment;

	private boolean approuved;

	public Request() {}
	
}
