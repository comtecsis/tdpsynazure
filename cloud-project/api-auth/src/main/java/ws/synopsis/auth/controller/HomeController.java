package ws.synopsis.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

public interface HomeController {
	
	@GetMapping( "home" )
    public String home( @AuthenticationPrincipal(expression = "claims['name']") String name );
	
}
