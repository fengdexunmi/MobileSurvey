package com.gae.mobilesurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gae.mobilesurvey.model.Survey;

/**
 * 列出、新增、删除问卷调查
 * @author Frank
 *
 */
public enum SurveyDao {
	INSTANCE;
	
	/**
	 * 列出所有的调查问卷
	 * @return
	 */
	public List<Survey> listSurveys() {
		EntityManager em = EMFService.get().createEntityManager();
		//读取现有的数据
		Query query = em.createQuery("select m from Survey m");
		@SuppressWarnings("unchecked")
		List<Survey> surveys = query.getResultList();
		return  surveys;
	}
	
	/**
	 * 新增调查问卷
	 * @param title
	 * @param dateCreated
	 * @param narrative
	 */
	public void add(String title, String dateCreated, String narrative) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Survey surveys = new Survey(title, dateCreated, narrative);
			em.persist(surveys);
			em.close();
		}
	}
	
	/**
	 * 根据问卷调查Id获取对应的问卷调查
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Survey> getSurvey(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select s from Survey s where s.id = :id");
		query.setParameter("id", id);
		List<Survey> listSurveyById = query.getResultList();
		return listSurveyById;
	}
	
	/**
	 * 根据问卷调查的Id删除对应的问卷调查
	 * @param id
	 */
	public boolean remove(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.remove(em.find(Survey.class, id));
		} finally {
			em.close();
		}
		return true;
	}
	
	/**
	 * 更新调查问卷
	 * @param id 获取要执行更新操作的问卷调查	
	 * @param newTitle 
	 * @param newDate
	 * @param newNarrative
	 * @return
	 */
	public boolean update(Long id, String newTitle, String newDate, String newNarrative) {
		EntityManager em = EMFService.get().createEntityManager();
		em.getTransaction().begin();
		Survey survey = em.find(Survey.class, id);
		em.clear();
		survey.setTitle(newTitle);
		survey.setDateCreated(newDate);
		survey.setNarrative(newNarrative);
		em.merge(survey);
		em.getTransaction().commit();
		em.close();
		return true;
	}
}
