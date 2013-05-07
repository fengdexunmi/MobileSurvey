package com.gae.mobilesurvey;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class QuestionnaireServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String surveyId = req.getParameter("surveyId");
		try {
			resp.sendRedirect("/questionnaire.jsp?surveyId="+surveyId);
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
