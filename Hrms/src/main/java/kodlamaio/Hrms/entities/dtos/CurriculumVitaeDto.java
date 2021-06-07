package kodlamaio.Hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	@JsonIgnore
	private int id;
	private int candidateId;
	private String githublink;
	private String linkedinlink;
	private String photo;
	private String description;
}
