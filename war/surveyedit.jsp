<%@page import="com.gae.mobilesurvey.util.StringToDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.gae.mobilesurvey.model.Survey"%>
<%@page import="java.util.List"%>
<%@page import="com.gae.mobilesurvey.dao.SurveyDao"%>
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
<title>编辑问卷调查</title>
</head>
<body>
	<div data-role="page" id="page1">
    <div data-theme="b" data-role="header" data-position="fixed">
        <a data-role="button" data-rel="back"  class="ui-btn-left">
            	返回
        </a>
        <h3>
            	编辑问卷调查
        </h3>
    </div>
    <div data-role="content">
    	<%String surveyId = request.getParameter("surveyId"); %>
		<%List<Survey> listSurveyById = SurveyDao.INSTANCE.getSurvey(Long.valueOf(surveyId));%>
		<%String title = listSurveyById.get(0).getTitle(); %>
		<%String dateString = listSurveyById.get(0).getDateCreated(); %>
		<%String narrative = listSurveyById.get(0).getNarrative(); %>
        <form id="updateFormId" action="/surveyupdate?surveyId=<%=surveyId %>" method="post" data-ajax="false">
            <div data-role="fieldcontain">
                <label for="textinput1">
                   	 标题	
                </label>
                <input name="newTitle" id="newTitleId" placeholder="" value="<%=title %>" type="text">
                
            </div>
            <div data-role="fieldcontain">
                <label for="textinput2">
                 	   时间
                </label>
                <input name="newDate" id="newDateId" placeholder="" value="<%=dateString %>"  type="date" id="surveyDateId">
            </div>
            <div data-role="fieldcontain">
                <label for="textarea1">
                    	描述
                </label>
                <textarea name="newNarrative" id="newNarrativeId" placeholder=""> <%=narrative%></textarea>
            </div>
            <input type="submit" value="保存">
        </form>
    </div>
    <div data-theme="b" data-role="footer" data-position="fixed">
        <h3>
        </h3>
        <a  href="/surveydelete?surveyId=<%=surveyId%>" data-role="button"
        data-icon="delete" data-iconpos="left" class="ui-btn-left" id="deleteButton" data-ajax="false">
          	  删除
        </a>
    </div>
</div>
</body>
</html>