package faca.training.Spring_ToolEnglish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import faca.training.Spring_ToolEnglish.entities.NewWord;

public interface NewWordDao extends JpaRepository<NewWord, Integer> {

	@Query ("FROM NewWord ORDER BY NEWID()")
	NewWord finvietnamese();
}
