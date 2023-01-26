package m2i.cinema.bo.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericEntity;

@Data @Entity
@AllArgsConstructor
@Table(name="movies")
@EqualsAndHashCode(callSuper=false)
public class Movie extends GenericEntity {

	private String name;
	
	private String cover;

	private float price;

	@OneToMany( // Not exclusive
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER) // EAGER
	@Fetch(FetchMode.SELECT)
	private List<Genre> genres;

	private String synopsis;

	private int duration;

	@Column(name = "experience_3d")
	private boolean experience3D;

	@ManyToOne( // Not exclusive
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			optional = false)
	private LanguageVersion languageVersion;
	
	public Movie() {}

}
