package m2i.cinema.bo.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="street_type")
public class StreetType extends GenericBean {

	@Column(name = "type_name")
	private String name;
	
	public StreetType() {}
	
}
