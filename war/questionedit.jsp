<%@page import="java.util.ArrayList"%>
<%@page import="com.gae.mobilesurvey.model.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.gae.mobilesurvey.dao.QuestionDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>  
<title>编辑问卷题目</title>
</head>
<body>
<div data-role="page" id="page1">
	
    <div data-theme="b" data-role="header">
    	<a data-role="button" data-rel="back"  class="ui-btn-left">
            	返回
     	</a>
        <h3>
            	编辑问卷题目
        </h3>
    </div>
    <div data-role="content">
    <%
    	String questionId = request.getParameter("questionId");
    	String surveyId = request.getParameter("surveyId");
    	List<Question> listQuestionById = QuestionDao.INSTANCE.getByQuestionId(Long.valueOf(questionId));
    	String questionTitle = listQuestionById.get(0).getqTitle();
    	String option, option1, option2;
    	List<String> optionString = listQuestionById.get(0).getqOption();
    	option = optionString.get(0);
    	option1 = optionString.get(1);
    	
    	if(optionString.size() > 2) {
    		option2 = optionString.get(2);
    	} else {
    		option2 = "";
    	}
    %>
    	<form action="/questionedit?questionId=<%=questionId%>&surveyId=<%=surveyId%>" method="post" data-ajax="false">
        <ul data-role="listview" data-divider-theme="b" data-inset="true">
            <li data-role="list-divider" role="heading">
              		 题目：<input name="textinputTitle" id="textinputTitleId" placeholder="" value="<%=questionTitle%>" type="text">
            </li>
            <li data-theme="c">
                	选项：<input name="textinputOption" id="textinputOptionId" placeholder="" value="<%=option%>" type="text">
                	<input name="textinputOption1" id="textinputOptionId" placeholder="" value="<%=option1%>" type="text" >
                	<input name="textinputOption2" id="textinputOptionId" placeholder="" value="<%=option2%>" type="text" >
            </li>
        </ul>
        <input type="submit" value="Submit">
        </form>
    </div>
    <div data-theme="b" data-role="footer" data-position="fixed">
        <h3>
        </h3>
        <a  href="/questiondelete?questionId=<%=questionId%>&surveyId=<%=surveyId%>" data-role="button"
        data-icon="delete" data-iconpos="left" class="ui-btn-left" id="deleteButton" data-ajax="false">
          	  删除
        </a>
    </div>
</div>
</body>
</html>