package m2i.cinema.bo.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;


@Data @Entity
@Table(name="genres")
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Genre extends GenericBean {

	@Column(name = "genre_name")
	private String name;
	
	public Genre() {}
}
