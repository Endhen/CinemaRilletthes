package m2i.cinema.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.cinema.bo.GenericBean;
import m2i.cinema.dal.DAO;

@Service
public class BLL<T extends GenericBean> {
    
    @Autowired
    private DAO<T> repository;
    
    public List<T> findAll(){
        return repository.findAll();
    }
    
    public Optional<T> findById(int id){
        return repository.findById(id);
    }
    
    public T update(T updated){
        return repository.save(updated);
    }
    
    public T create(T newDomain){
        return repository.save(newDomain);
    }
    
    public void delete(int id){
        repository.deleteById(id);
    }
}