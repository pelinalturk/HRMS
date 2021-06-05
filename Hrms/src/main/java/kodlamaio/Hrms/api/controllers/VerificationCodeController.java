package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.VerificationCodeService;

@RestController
@RequestMapping("/api/verification_codes")
public class VerificationCodeController {
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerificationCodeController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
}
