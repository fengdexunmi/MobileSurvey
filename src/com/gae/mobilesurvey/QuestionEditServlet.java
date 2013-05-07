package com.gae.mobilesurvey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.QuestionDao;

/**
 * 编辑问卷题目，包括修改题目标题和选项
 * @author Frank
 *
 */
@SuppressWarnings("serial")
public class QuestionEditServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		String questionId = req.getParameter("questionId");
		String surveyId = req.getParameter("surveyId");
		String qTitle = req.getParameter("textinputTitle");
		String option = req.getParameter("textinputOption");
		String option1 = req.getParameter("textinputOption1");
		String option2= req.getParameter("textinputOption2");
		List<String> qOption = new ArrayList<String>();
		if(checkNull(option)){
			qOption.add(option);
		}
		if(checkNull(option1)){
			qOption.add(option1);
		}
		if(checkNull(option2)){
			qOption.add(option2);
		}
		
		boolean isUpdate = QuestionDao.INSTANCE
				.updateQuestion(Long.valueOf(questionId), qTitle, qOption);
		
		if(isUpdate) {
			resp.sendRedirect("/questionnaire.jsp?surveyId=" + surveyId);
		}
	}
	
	public boolean checkNull(String str) {
		if(str.equals("") || str==null) {
			return false;
		}
		return true;
	}
}
