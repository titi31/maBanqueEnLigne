package co.simplon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SecurityController {
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/operations";
	}
	@RequestMapping(value="/403")
	public String accessDenied() {
		return "403";
	}
}
