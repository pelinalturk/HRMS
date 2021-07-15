package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SocialMediaService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.Hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService{
	
	private SocialMediaDao socialMediaDao;

	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public List<SocialMedia> getByCandidateId(int id) {
		return this.socialMediaDao.getByCandidateId(id);
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		 this.socialMediaDao.save(socialMedia);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public Result delete(int id) {
		this.socialMediaDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(SocialMedia socialMedia) {
		SocialMedia getSocialMedia = socialMediaDao.findById(socialMedia.getId()).get();
		if(socialMedia.getCandidate() == null) {
			socialMedia.setCandidate(getSocialMedia.getCandidate());
		}
		if(socialMedia.getGithubLink() =="" || socialMedia.getGithubLink() == null) {
			socialMedia.setGithubLink(getSocialMedia.getGithubLink());
		}
		if(socialMedia.getLinkedinLink() =="" || socialMedia.getLinkedinLink() == null) {
			socialMedia.setLinkedinLink(getSocialMedia.getLinkedinLink());
		}
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("Güncellendi");
	}
}
