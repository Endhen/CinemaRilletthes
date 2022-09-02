package bo.services;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllMovie",
			query="SELECT m FROM Movie m"),
	@NamedQuery(
			// find + this.class + ById 
			name="findMovieById",
			query="SELECT m FROM Movie m WHERE m.id = :id")
})
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "movie_name")
	private String name;
	@Column(name = "cover")
	private String cover;
	@Column(name = "price")
	private float price;
	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	private List<Genre> genres;
	@Column(name = "synopsis")
	private String synopsis;
	@Column(name = "duration")
	private int duration;
	@Column(name = "experience_3d")
	private boolean experience3D;
	@ManyToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			optional = false)
	private LanguageVersion languageVersion;
	
	public Movie() {}
	public Movie(
			String name, 
			String cover, 
			float price, 
			List<Genre> genres, 
			String synopsis, 
			int duration,
			boolean experience3d, 
			LanguageVersion languageVersion) {
		this.name = name;
		this.cover = cover;
		this.price = price;
		this.genres = genres;
		this.synopsis = synopsis;
		this.duration = duration;
		experience3D = experience3d;
		this.languageVersion = languageVersion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isExperience3D() {
		return experience3D;
	}

	public void setExperience3D(boolean experience3d) {
		experience3D = experience3d;
	}

	public LanguageVersion getLanguageVersion() {
		return languageVersion;
	}

	public void setLanguageVersion(LanguageVersion languageVersion) {
		this.languageVersion = languageVersion;
	}
}
