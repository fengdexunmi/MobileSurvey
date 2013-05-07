package com.gae.mobilesurvey;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.SurveyDao;

@SuppressWarnings("serial")
public class SurveyFormServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("surveyTitle");
		System.out.println(title);
		String dateCreated = req.getParameter("dateCreated");
		System.out.println(dateCreated);
		String narrative = req.getParameter("surrveyNarrative");
		System.out.println(narrative);
		SurveyDao.INSTANCE.add(title, dateCreated, narrative);
		resp.sendRedirect("/surveylist.jsp");
		return;
	}
	
}
