package m2i.cinema.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.cinema.bo.GenericBean;

@Repository
public interface DAO<T extends GenericBean> extends JpaRepository<T, Integer> {}