package com.psych.game.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rounds")
public class Round extends Auditable{

	@ManyToOne
	@Getter
	@Setter
	@NotNull
	private Game game;
	
	@Getter
	@Setter
	@ManyToOne
	@NotNull
	private Question question;
	
	@Getter
	@Setter
	@ManyToMany
	private Map<Player,PlayerAnswer> playerAnswers=new HashMap<>();
	
	@Getter
	@Setter
	@ManyToMany
	private Map<Player,PlayerAnswer> selectedAnswers=new HashMap<>();
	
	@ManyToOne
	@Getter
	@Setter
	private EllenAnswer ellenAnswer;
	
	@Getter
	@Setter
	@NotNull
	private int roundNumber;
}
