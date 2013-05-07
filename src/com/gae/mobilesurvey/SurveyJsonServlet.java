package com.gae.mobilesurvey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.SurveyDao;
import com.gae.mobilesurvey.model.Survey;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class SurveyJsonServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		//获取调查问卷列表
		List<Survey> listSurveys = new ArrayList<Survey>();
		listSurveys = SurveyDao.INSTANCE.listSurveys();
		
		//获取问卷名称
		String[][] surveyJson = new String[listSurveys.size()][2];
		for(int i=0; i<listSurveys.size(); i++) {
			surveyJson[listSurveys.size()-1-i][0] = listSurveys.get(i).getId() + "-+" + listSurveys.get(i).getTitle() + "/" + listSurveys.get(i).getDateCreated();
			surveyJson[listSurveys.size()-1-i][1] = listSurveys.get(i).getNarrative();
		}
		
		//将问卷名称以数组的形式存为JSON格式	
		JSONObject surveyJsonObject = new JSONObject();
		try {
			surveyJsonObject.put("surveyJson", surveyJson);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println(surveyJsonObject);
		System.out.println(surveyJsonObject);
	
	}
}
