package bo.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="genres")
@NamedQueries({
	@NamedQuery(
			// findAll + this.class 
			name="findAllGenre",
			query="SELECT g FROM Genre g"),
	@NamedQuery(
			// find + this.class + ById 
			name="findGenreById",
			query="SELECT g FROM Genre g WHERE g.id = :id")
})
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "genre_name")
	private String name;
	
	public Genre() {}
	public Genre(String name) {
		this.name = name;
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
}
