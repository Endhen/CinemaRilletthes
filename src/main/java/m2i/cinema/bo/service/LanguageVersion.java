package m2i.cinema.bo.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import m2i.cinema.bo.GenericBean;

@Data @Entity
@AllArgsConstructor
@Table(name="language_versions")
@EqualsAndHashCode(callSuper=false)
public class LanguageVersion extends GenericBean {

	@Column(name = "language_version_type")
	private String type;
	
	public LanguageVersion() {}

}
