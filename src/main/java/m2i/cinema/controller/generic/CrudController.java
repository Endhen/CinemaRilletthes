package m2i.cinema.controller.generic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import m2i.cinema.bll.BLL;
import m2i.cinema.bo.GenericEntity;

public abstract class CrudController<T extends GenericEntity> implements CrudRouting<T> {
    
    @Autowired
    public BLL<T> bll;
    
    public ResponseEntity<List<T>> findAll(){
        return ResponseEntity.ok(bll.findAll());
    }
    
    public ResponseEntity<T> findById(int id){
        Optional<T> entity = bll.findById(id);        

        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else
            return ResponseEntity.notFound().build();

    }
    
    public ResponseEntity<T> update(int id, T updated){
        updated.setId(id);
        
        return ResponseEntity.ok(bll.update(updated));
    }
    
    public ResponseEntity<T> create(T created){
        return ResponseEntity.ok(bll.create(created));
    }
    
    public ResponseEntity<String> delete(int id){
        bll.delete(
            bll.findById(id).get());

        return ResponseEntity.ok("DELETED");
    }
}