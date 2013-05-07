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
<title>新增问卷题目</title>
</head>
<body>
<div data-role="page" id="page1">
    <div data-theme="b" data-role="header">
    	<a data-role="button" href="/questionnaire.jsp?surveyId=<%=request.getParameter("surveyId") %>" class="ui-btn-left" data-ajax="false">
            	返回
     	</a>
        <h3>
            	新增问卷题目
        </h3>
    </div>
    <div data-role="content">
    	<form action="/questionadd?surveyId=<%=request.getParameter("surveyId") %>" method="post" data-ajax="false">
        <ul data-role="listview" data-divider-theme="b" data-inset="true">
            <li data-role="list-divider" role="heading">
              		 题目：<input name="textinputTitle" id="textinputTitleId" placeholder="" value="" type="text">
            </li>
            <li data-theme="c">
                	选项：<input name="textinputOption" id="textinputOptionId" placeholder="" value="" type="text">
                	<input name="textinputOption1" id="textinputOptionId" placeholder="" value="" type="text" >
                	<input name="textinputOption2" id="textinputOptionId" placeholder="" value="" type="text" >
            </li>
        </ul>
        <input type="submit" value="Submit">
        </form>
    </div>
</div>
</body>
</html>