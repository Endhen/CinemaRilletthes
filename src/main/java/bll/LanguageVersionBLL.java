package bll;

import bo.services.LanguageVersion;
@SuppressWarnings("hiding")
public class LanguageVersionBLL<LanguageVersion> extends BLL<LanguageVersion> {

	public LanguageVersionBLL (Class<LanguageVersion> entityType) {
		super((Class<LanguageVersion>) entityType);
	}
	
	public BLL<LanguageVersion> insert(LanguageVersion entity) {
		dao.insert((LanguageVersion) entity);
		return this;
	}
}
