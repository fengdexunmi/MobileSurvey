package com.gae.mobilesurvey;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.SurveyDao;

@SuppressWarnings("serial")
public class SurveyUpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String surveyId = req.getParameter("surveyId");
		String newTitle = req.getParameter("newTitle");
		String newDate = req.getParameter("newDate");
		String newNarrative = req.getParameter("newNarrative");
		if(surveyId != null) {
			boolean isUpdate = SurveyDao.INSTANCE.update(Long.valueOf(surveyId), newTitle, newDate, newNarrative);
			if(isUpdate) {
				try {
					resp.sendRedirect("/surveylist.jsp");
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
