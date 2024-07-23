package faca.training.Spring_ToolEnglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import faca.training.Spring_ToolEnglish.entities.NewWord;
import faca.training.Spring_ToolEnglish.service.NewWordService;

@Controller
public class HomeController {
	@Autowired
	private NewWordService service;

	@PostMapping("/addnewword")
	public String saveNewword(Model model, @ModelAttribute NewWord newword) {
		service.createnewword(newword);
		return  "redirect:/";
	}
	@RequestMapping("/")
	public String showvietnamese(Model model) {
		List<NewWord> vietnamese =  service.findall();
		model.addAttribute("vietnamese", vietnamese);
		int total = vietnamese.size();
		model.addAttribute("wordtotal", total);
		return "Home";
	}
	@RequestMapping("/createnewword")
	public String createnewword() {
		return "CreateNewWord";
	}
	@RequestMapping("/testtu")
	public String testtu(Model model) {
		NewWord word;
		do {
		  word = service.findnewword();
		}while(word == null);
		model.addAttribute("word", word);
		return "TraTu";
	}
	@PostMapping("/kiemtra")
	public String kiemtra(Model model, @ModelAttribute NewWord word, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(word.getEnglish())) {
			NewWord newword;
			do {
			  newword = service.findnewword();
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "TraTu";
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "TraTu";
		}
	}
	

}
