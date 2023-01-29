package m2i.cinema.entity.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.entity.GenericEntity;

@Data @Entity
@AllArgsConstructor
@Table(name="language_versions")
@EqualsAndHashCode(callSuper=false)
public class LanguageVersion extends GenericEntity {

	@Column(name = "language_version_type", unique = true)
	private String type;
	
	public LanguageVersion() {}

}
