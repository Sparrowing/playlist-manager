package sparrowing.playlistmanager.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/u")
public class AuthController {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		
		// Simply render register form
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost() {
		// TODO: Implement /register post method
		return "todo";
	}

}
