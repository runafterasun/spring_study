package annotation.controller;

import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import annotation.dataTransferObjects.TestDTO;

@RestController
@RequestMapping(value="/api/test")
public class RestControllers {
	
	@GetMapping
	public TestDTO getTestDTO() {
		TestDTO test = new TestDTO();
		test.setFirstname("Тест");
		test.setLastname("fest");
		test.add(new Link("http://localhost:8080/structure/api/test"));
		return test;		
	}

}
