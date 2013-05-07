package com.gae.mobilesurvey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.gae.mobilesurvey.dao.QuestionDao;
import com.gae.mobilesurvey.model.Question;


@SuppressWarnings("serial")
public class QuestionListServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		String surveyId = req.getParameter("surveyId");
		List<Question> questionList = new ArrayList<Question>();
		questionList = QuestionDao.INSTANCE.getQuestion(Long.valueOf(surveyId));
		System.out.println("questionList:"+questionList);
		LinkedHashMap<String, List<String>> questionJsonMap = new LinkedHashMap<String, List<String>>();
		for(int i=0; i<questionList.size(); i++) {
			System.out.println(questionList.get(i).getqOption());
			questionJsonMap.put(questionList.get(i).getqId()+"-+"+questionList.get(i).getqTitle(), questionList.get(i).getqOption());
			System.out.println(questionJsonMap);
		}
		
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject.put("questionJson", questionJsonMap);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("questionJson", questionJsonMap);
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println(jsonObject);
		System.out.println(jsonObject);
	}
}
