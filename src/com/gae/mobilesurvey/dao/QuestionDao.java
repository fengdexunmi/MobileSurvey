package com.gae.mobilesurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gae.mobilesurvey.model.Question;

public enum QuestionDao {
	INSTANCE;
	
	/**
	 * 列出问题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Question> listQuestion() {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select m from Question m");
		return query.getResultList();
	}
	
	/**
	 * 根据问题和选项新增问卷题目
	 * @param qTitle
	 * @param qOption
	 */
	public boolean addQuestion(Long surveyId, String qTitle, List<String> qOption) {
		EntityManager em = EMFService.get().createEntityManager();
		Question question = new Question(surveyId, qTitle, qOption);
		em.persist(question);
		em.close();
		return true;
	}
	
	/**
	 * 更新问卷
	 * @param questionId
	 * @param qTitle
	 * @param qOption
	 * @return
	 */
	public boolean updateQuestion(Long questionId, String qTitle, List<String> qOption) {
		EntityManager em = EMFService.get().createEntityManager();
		em.getTransaction().begin();
		Question question = em.find(Question.class, questionId);
		em.clear();
		question.setqTitle(qTitle);
		question.setqOption(qOption);
		em.merge(question);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	/**
	 * 根据问卷调查的Id获取对应的问卷题目
	 * @param surveyId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Question> getQuestion(Long surveyId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select q from Question q where q.surveyId = :surveyId");
		query.setParameter("surveyId", surveyId);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getByQuestionId(Long questionId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select q from Question q where q.qId = :questionId");
		query.setParameter("questionId", questionId);
		return query.getResultList();
	}
	
	/**
	 * 删除某个问题
	 * @param qId
	 */
	public boolean deleteQuestion(Long qId) {
		EntityManager em = EMFService.get().createEntityManager();
		em.remove(em.find(Question.class, qId));
		em.close();
		
		return true;
	}
}
