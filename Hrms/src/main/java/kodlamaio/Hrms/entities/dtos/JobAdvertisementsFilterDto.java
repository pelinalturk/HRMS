package kodlamaio.Hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementsFilterDto {
	private List<Integer> cityId;
    private List<Integer> jobPositionId;
    private List<Integer> mannerOfWorkId;
    private List<Integer> workingHourId;
    private List<Integer> positionLevelId;
}
