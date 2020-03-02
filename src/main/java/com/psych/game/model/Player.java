package com.psych.game.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="players")
public class Player extends User{
	@NotBlank
	@Getter
	@Setter
	private String alias;
	
	@Getter
	@Setter
	private String psychFaceUrl;
	
	@Getter
	@Setter
	private String picUrl;
	
	@OneToOne(cascade=CascadeType.ALL)
	@Getter
	@Setter
	private Stats stats=new Stats();
	
	@ManyToMany(mappedBy="players")
	@Getter
	@Setter
	private Set<Game> games;

	public Player() {}
	
	private Player(Builder builder) {
		this.email = builder.email;
		this.saltedHashedPassword = builder.saltedHashedPassword;
		this.alias = builder.alias;
		this.psychFaceUrl = builder.psychFaceUrl;
		this.picUrl = builder.picUrl;
	}

	/**
	 * Creates builder to build {@link Player}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Player}.
	 */
	public static final class Builder {
		private String email;
		private String saltedHashedPassword;
		private String alias;
		private String psychFaceUrl;
		private String picUrl;
		
		private Builder() {
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withSaltedHashedPassword(String saltedHashedPassword) {
			this.saltedHashedPassword = saltedHashedPassword;
			return this;
		}

		public Builder withAlias(String alias) {
			this.alias = alias;
			return this;
		}

		public Builder withPsychFaceUrl(String psychFaceUrl) {
			this.psychFaceUrl = psychFaceUrl;
			return this;
		}

		public Builder withPicUrl(String picUrl) {
			this.picUrl = picUrl;
			return this;
		}

		public Player build() {
			return new Player(this);
		}
	}


}
