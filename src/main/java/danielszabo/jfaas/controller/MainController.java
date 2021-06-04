package danielszabo.jfaas.controller;

import danielszabo.jfaas.FunctionRunner;
import danielszabo.jfaas.entity.Function;
import danielszabo.jfaas.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {

	@Autowired
	FunctionRunner functionRunner;

	@Autowired
	private FunctionRepository functions;

	@GetMapping("/")
	public String getIndex(Model model){
		model.addAttribute("functions", functions.findAll());
		model.addAttribute("function", new Function());
		model.addAttribute("greeting", "jFaaF");
		return "index";
	}

	@PostMapping("/")
	public String getIndex(@ModelAttribute Function function){
		functions.save(function);
		return "redirect:/";
	}

	@GetMapping("/run/{fun}")
	@ResponseBody
	public String runFunction(@PathVariable String fun) {
		Optional<Function> function = functions.findByName(fun);
		if(function.isPresent()) {
			return functionRunner.run(function.get());
		} else {
			return "This function does not exist";
		}
	}
}
