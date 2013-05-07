package com.gae.mobilesurvey.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 问卷题目
 * @author Frank
 *
 */
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qId;
	
	/**
	 * 调查问卷的Id
	 */
	private Long surveyId;
	
	/**
	 * 问卷题目类型，分为单选、多选和叙述题
	 */
	private Long qType;
	
	/**
	 * 问题的题目
	 */
	private String qTitle;
	
	/**
	 * 问题的选项
	 */
	private List<String> qOption;
	
	public Question(Long surveyId, String qTitle, List<String> qOption) {
		this.surveyId  = surveyId;
		this.qTitle = qTitle;
		this.qOption = qOption;
	}

	public Long getqId() {
		return qId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public Long getqType() {
		return qType;
	}

	public void setqType(Long qType) {
		this.qType = qType;
	}
	
	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public List<String> getqOption() {
		return qOption;
	}

	public void setqOption(List<String> qOption) {
		this.qOption = qOption;
	}
}
