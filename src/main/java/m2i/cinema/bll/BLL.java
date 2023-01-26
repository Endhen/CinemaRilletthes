package m2i.cinema.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.cinema.bo.GenericEntity;
import m2i.cinema.dal.DAO;

@Service
public class BLL<T extends GenericEntity> {
    
    @Autowired
    private DAO<T> repository;
    
    public List<T> findAll(){
        return repository.findAll();
    }
    
    public Optional<T> findById(int id){
        return repository.findById(id);
    }
    
    public T update(T entity){
        return repository.save(entity);
    }
    
    public T create(T entity){
        return repository.save(entity);
    }
    
    public void delete(T entity){
        repository.delete(entity);
    }
}