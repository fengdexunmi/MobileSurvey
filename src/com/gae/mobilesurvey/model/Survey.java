package com.gae.mobilesurvey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 调查问卷的标题
	 */
	private String title;
	
	/**
	 * 调查问卷的创建时间
	 */
	private String dateCreated;
	
	/**
	 * 调查问卷的叙述
	 */
	private String narrative;

	/**
	 * 构造函数
	 * @param title 
	 * @param dateCreated
	 * @param narrative
	 */
	public Survey(String title, String dateCreated, String narrative) {
		this.title = title;
		this.dateCreated = dateCreated;
		this.narrative = narrative;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
}

