package com.gae.mobilesurvey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gae.mobilesurvey.dao.AnswerDao;
import com.gae.mobilesurvey.dao.QuestionDao;
import com.gae.mobilesurvey.model.Answer;
import com.gae.mobilesurvey.model.Question;

@SuppressWarnings("serial")
public class ResultsAnalysisServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		
		String str = req.getParameter("items");
		String surveyId = req.getParameter("surveyId");
//		String[] strArray = str.split("//|");
//		int arrayLength = strArray.length;
//		String[][] strArray2 = new String[arrayLength][2];
//		List<String> listStrings = new ArrayList<String>();
//		for(int i=0; i<arrayLength; i++) {
//			strArray2[i][0] = strArray[i].substring(0, strArray[i].indexOf("-"));
//			strArray2[i][1] = strArray[i].substring(strArray[i].indexOf("-"));
//			listStrings.add(Integer.parseInt(strArray2[i][0]), strArray2[i][1]);
//		}
		List<Question> listQuestions = new ArrayList<Question>();
		
		listQuestions = QuestionDao.INSTANCE.getQuestion(Long.valueOf(surveyId));
		
		List<Answer> listAnswers = new ArrayList<Answer>();
		listAnswers = AnswerDao.INSTANCE.listAnswers();
		
		int listSize = listQuestions.size();
		for(int i=0; i<listSize; i++) {
			List<String> temp = listQuestions.get(i).getqOption();
			List<Integer> answerNumsList = new ArrayList<Integer>();
			for(int j=0; j< temp.size(); j++)
			{
				if(str.contains(i+"-"+temp.get(j))) {
					answerNumsList.add(j, 1);
				} else {
					answerNumsList.add(j, 0);
				}
			}
			if(listAnswers.isEmpty()) {
			AnswerDao.INSTANCE.addAnswerNum(listQuestions.get(i).getqId(), answerNumsList);
			} else {
				AnswerDao.INSTANCE.updateAnswerNum(listAnswers.get(i).getAnswerId(), 
						this.listAddition(answerNumsList, listAnswers.get(i).getAnswerNum()));
			}
		}
		
		resp.sendRedirect("/index.html");
	}
	
	public List<Integer> listAddition(List<Integer> listStr1, List<Integer> listStr2) {
		List<Integer> listTemp = new ArrayList<Integer>();
		for(int i=0; i<listStr1.size(); i++) {
			listTemp.add(i, listStr1.get(i) + listStr2.get(i));
		}
		return listTemp;
	}
}
