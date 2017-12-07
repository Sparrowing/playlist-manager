package sparrowing.playlistmanager.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public String index() {
		return "home";
	}

}
