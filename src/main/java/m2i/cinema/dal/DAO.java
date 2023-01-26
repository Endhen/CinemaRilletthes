package m2i.cinema.dal;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import m2i.cinema.bo.GenericEntity;

@Primary
public interface DAO<T extends GenericEntity> extends JpaRepository<T, Integer> {}
