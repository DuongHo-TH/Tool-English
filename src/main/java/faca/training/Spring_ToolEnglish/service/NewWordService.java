package faca.training.Spring_ToolEnglish.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faca.training.Spring_ToolEnglish.dao.NewWordDao;
import faca.training.Spring_ToolEnglish.entities.NewWord;

@Service
public class NewWordService  {
 @Autowired
 private NewWordDao newdao;
  public void createnewword(NewWord newword) {
	  newdao.save(newword);
  }
  public NewWord findvietnamese() {
	  return  newdao.finvietnamese();
  }
  public List<NewWord> findall(){
	 return newdao.findAll();
  }
  public NewWord findnewword() {
	  int n = newdao.findAll().size();
	  Random random = new Random();
	  int id = random.nextInt(n);
	  return newdao.findById(id).orElse(null);
  }
  }
