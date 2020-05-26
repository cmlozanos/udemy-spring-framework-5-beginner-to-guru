package cmls.springframework.springWebApp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Book> books;

}
