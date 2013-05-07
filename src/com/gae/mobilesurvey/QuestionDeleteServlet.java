package com.gae.mobilesurvey;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.QuestionDao;

@SuppressWarnings("serial")
public class QuestionDeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String questionId = req.getParameter("questionId");
		String surveyId = req.getParameter("surveyId");
		boolean isDelete = QuestionDao.INSTANCE.deleteQuestion(Long.valueOf(questionId));
		if(isDelete) {
			resp.sendRedirect("/questionnaire.jsp?surveyId="+surveyId);
		}
	}
}
