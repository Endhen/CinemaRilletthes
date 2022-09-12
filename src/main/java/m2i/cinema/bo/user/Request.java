package m2i.cinema.bo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@AllArgsConstructor
@Table(name="request")
@EqualsAndHashCode(callSuper=false)
public class Request extends GenericBean {

	@Column(name = "requested_order")
	private String order;

	private String comment;

	private boolean approuved;

	public Request() {}
	
}
