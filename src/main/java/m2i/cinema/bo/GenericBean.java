package m2i.cinema.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.experimental.Accessors;

@Data @Entity
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericBean {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
}


