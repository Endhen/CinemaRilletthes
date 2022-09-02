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
@Table(name="request")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllRequest",
			query="SELECT r FROM Request r"),
	@NamedQuery(
			// find + this.class + ById 
			name="findRequestById",
			query="SELECT r FROM Request r WHERE r.id = :id")
})
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "requested_order")
	private String order;
	@Column(name = "comment")
	private String comment;
	@Column(name = "approuved")
	private boolean approuved;
	
	public Request(String order, String comment) {
		this.order = order;
		this.comment = comment;
		this.approuved = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isApprouved() {
		return approuved;
	}

	public void setApprouved(boolean approuved) {
		this.approuved = approuved;
	}
}
