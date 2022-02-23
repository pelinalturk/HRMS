package kodlamaio.Hrms.business.concretes;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import kodlamaio.Hrms.business.abstracts.RegisterEmployerService;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterEmployerManager implements RegisterEmployerService{

	private final EmployerDao employerDao;
	
	@Override
	public Result registerEmployer(Employer employer) throws Exception {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        employer.setPassword(bCryptPasswordEncoder.encode(employer.getPassword())); 
        employerDao.save(employer);
        return new SuccessResult("Kayıt başarılı, giriş yapabilirsiniz.");
	}

	@Override
	public String employerConfirmation(int employerId, int systemUserId) throws NotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
