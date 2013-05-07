package com.gae.mobilesurvey;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.SurveyDao;

@SuppressWarnings("serial")
public class SurveyDeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		Long surveyId = Long.valueOf(req.getParameter("surveyId"));
		boolean isRemove = SurveyDao.INSTANCE.remove(surveyId);
		if(isRemove) {
			resp.sendRedirect("/surveylist.jsp");
		}
	}
}
