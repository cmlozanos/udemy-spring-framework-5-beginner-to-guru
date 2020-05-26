package cmls.springframework.springWebApp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
	
	@Id
    @GeneratedValue
    private Long id;

    private String title;
    private String isbn;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Publisher publisher;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonIgnore
    private Set<Author> authors;


}
