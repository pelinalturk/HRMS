package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	List<SocialMedia> getByCandidateId(int id);
	Result add(SocialMedia socialMedia);
	Result delete(int id);
	Result update (SocialMedia socialMedia);
}
