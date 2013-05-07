package com.gae.mobilesurvey.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;
	
	private Long questionId;
	
	private List<Integer> answerNum;

	public Answer(Long questionId, List<Integer> answerNum) {
		this.answerNum = answerNum;
	}
	
	public Long getAnswerId() {
		return answerId;
	}

	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}
	
	public List<Integer> getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(List<Integer> answerNum) {
		this.answerNum = answerNum;
	}
	
	
}
