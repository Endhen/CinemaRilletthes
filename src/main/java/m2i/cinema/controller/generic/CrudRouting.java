package m2i.cinema.controller.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudRouting<T> {
    
    @GetMapping
    public ResponseEntity<List<T>> findAll();
    
    @GetMapping(path="/{id}")
    public ResponseEntity<T> findById(@PathVariable int id);
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<T> update(@PathVariable int id, @RequestBody T updated);
    
    @PostMapping
    public ResponseEntity<T> create(@RequestBody T created);
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id);
}
