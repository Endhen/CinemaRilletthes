package m2i.cinema.bo.cinema;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericEntity;

@Data @Entity
@AllArgsConstructor
@Table(name="seats")
@EqualsAndHashCode(callSuper=false)
public class Seat extends GenericEntity {

	@Column(name = "col_placement")
	private int columnPlacement;

	@Column(name = "row_placement")
	private char rowPlacement;
	
	private boolean PMR;

	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			optional = false)
	private Section group;
	
	public Seat() {}
	
}
