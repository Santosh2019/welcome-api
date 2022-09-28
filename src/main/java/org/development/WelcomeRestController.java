package org.development;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetClient greetClient;
	
	@GetMapping("/welcome")
	public WelcomeResponse getGreetMsg() {

		String welcomeMsg = "Welcome to Pune";

		String greetMsg = greetClient.invokeGreetApi();

		/*
		 * RestTemplate rest = new RestTemplate();
		 * 
		 * String endPointUrl =
		 * "https://44e6snmqp5.execute-api.ap-south-1.amazonaws.com/dev";
		 * 
		 * ResponseEntity<Pet> entity = rest.getForEntity(endPointUrl, Pet.class);
		 * 
		 * Pet pet = entity.getBody();
		 * 
		 */		//System.out.println("---------------------------------------" + pet);
		
		WelcomeResponse finalResponse = new WelcomeResponse();

		finalResponse.setGreetMsg(greetMsg);

		finalResponse.setWelcomeMsg(welcomeMsg);

		//finalResponse.setPet(pet);

		System.out.println(finalResponse);
		// greetMsg + "" + welcomeMsg;

		return finalResponse;
	}
}
