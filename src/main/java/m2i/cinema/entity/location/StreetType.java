package m2i.cinema.entity.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;

@Data @Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="street_types")
public class StreetType extends GenericEntity {

	@Column(name = "type_name")
	private String name;
	
	public StreetType() {}
	
}
