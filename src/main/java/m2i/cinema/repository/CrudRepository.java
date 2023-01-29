package m2i.cinema.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import m2i.cinema.entity.GenericEntity;

@Primary
public interface CrudRepository<T extends GenericEntity> extends JpaRepository<T, Integer> {}
