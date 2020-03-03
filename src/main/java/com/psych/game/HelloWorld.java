package com.psych.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psych.game.model.Game;
import com.psych.game.model.GameMode;
import com.psych.game.model.Player;
import com.psych.game.model.Question;
import com.psych.game.repositories.GameRepository;
import com.psych.game.repositories.PlayerRepository;
import com.psych.game.repositories.QuestionRepository;

@RestController
@RequestMapping("/test")
public class HelloWorld {
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@GetMapping("/")
	public String hello(){
		return "Hello, World!";
	}
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions(){
		return questionRepository.findAll();
	}
	@GetMapping("/getAllGames")
	public List<Game> getAllGames(){
		return gameRepository.findAll();
	}
	@GetMapping("/question/{id}")
	public Question getQuestionById(@PathVariable(name="id")Long id){
		return questionRepository.findById(id).orElseThrow();
	}
	@GetMapping("/getAllPlayers")
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}
	@GetMapping("/populate")
	public String populateDB(){
//		Player riya=new Player().builder().withAlias("steel").withEmail("riya@gmail.com").withSaltedHashedPassword("psych123").build();
//		playerRepository.save(riya);
		
//		Question question=new Question("How many moons does Jupiter have?", "79", GameMode.IS_THIS_A_FACT);
//		questionRepository.save(question);
		questionRepository.save(new Question(
                "Who invented the first wheel?",
                "Mesopotamia",
                GameMode.IS_THIS_A_FACT
        ));
		return "populated";
		
	}
	@GetMapping("/deleteAllQuestions")
	public String deleteAllQuestions(){
		questionRepository.deleteAll();
		return "deleted";
	}
}
