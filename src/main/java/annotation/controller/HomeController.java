package annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import annotation.entity.Table_temp;
import annotation.hibernateRepository.Test_TempRepositoryHib;
import annotation.repository.TableTempRepository;
import annotation.sentMails.EmailService;

@Controller
@RequestMapping("/")
@SessionAttributes("test")
public class HomeController {

	private final TableTempRepository tableTempRepository;
	private final Test_TempRepositoryHib tableTempRepositoryHib;
	
	@Autowired
	public HomeController(TableTempRepository tableTempRepository, Test_TempRepositoryHib tableTempRepositoryHib) {
		this.tableTempRepositoryHib = tableTempRepositoryHib;
		this.tableTempRepository = tableTempRepository;
	}

	@GetMapping("/{id}")
	public String home(@PathVariable("id") Table_temp tabletemp, Model model) {
		//model.addAttribute("test", tableTempRepository.findById("1L0C6B7A624").get());
		model.addAttribute("testPhone", tableTempRepository.findByPhone(1234));	
		model.addAttribute("test",tabletemp);		
		return "home";
	}
	
	@GetMapping(path = "/next")
	public String next(Model model) {
		model.addAttribute("testHib", tableTempRepositoryHib.findById("AX9CC9C9082"));
		return "next";
	}
	
	@GetMapping
	public String homeClear() {
		return "home";
	}
}
