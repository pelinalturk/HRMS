package kodlamaio.Hrms.api.controllers;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.entities.dtos.LoginDto;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginDto loginDto) throws Exception {
        return authService.login(loginDto);
    }

    @ExceptionHandler(value = {
            UsernameNotFoundException.class,
            IllegalStateException.class,
            Exception.class,
            AuthenticationException.class
    })
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleException(Exception e, HttpServletRequest httpServletRequest) {
        return new ErrorResult("Exception Message Found: "+e.getMessage());
    }
}
