package com.gae.mobilesurvey;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MobileSurveyServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String surveyTitle = req.getParameter("surveyTitle");
		System.out.println(surveyTitle);
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
