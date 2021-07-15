package kodlamaio.Hrms.Adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.Adapters.abstracts.CandidateCheckService;
import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service("mernis")
public class RealCandidateCheckManager implements CandidateCheckService{

	@Override
	public boolean checkCandidate(Candidate candidate) {
		KPSPublicSoapProxy kpsPublicSoapProxy;
		 try {
	            kpsPublicSoapProxy= new KPSPublicSoapProxy();
	         boolean verifiy= kpsPublicSoapProxy.TCKimlikNoDogrula(
	                    Long.parseLong(candidate.getNationalIdentity()),
	                    candidate.getFirstName().toUpperCase(),
	                    candidate.getLastName().toUpperCase(),
	                    candidate.getBirthYear().getYear());
	         return verifiy;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

}
