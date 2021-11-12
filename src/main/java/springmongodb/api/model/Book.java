package springmongodb.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@Document(collection="Book")
public class Book {

	@Id
	private int id;
	
	@Size(max = 80)
	@NotBlank
	private String bookName;

	@Size(max = 80)
	@NotBlank
	private String authorName;

}
