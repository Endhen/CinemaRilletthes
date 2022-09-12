package m2i.cinema.bo.cinema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@AllArgsConstructor
@Table(name="sections")
@EqualsAndHashCode(callSuper=false)
public class Section extends GenericBean {

	@Column(name = "group_name")
	private String name;

	@Column(name = "group_code")
	private String code;

	@Column(name = "pos_length")
	private int lengthPosition;

	@Column(name = "pos_width")
	private int widthPosition;

	@Column(name = "height")
	private int height;

	@Column(name = "width")
	private int width;
	
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, // EAGER
			orphanRemoval = true)
	private List<Seat> seats;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, 
			optional = false)
	private Room room;
	
	public Section() {}
	
}
