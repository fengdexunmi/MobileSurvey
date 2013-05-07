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
    <title>添加问卷</title> 
  </head>

  <body>
  <!-- Home -->
<div data-role="page" id="page1">
    <div id="surveyContainerId" data-theme="b" data-role="header" class="surveyContainer">
    	<a data-role="button" data-rel="back"  class="ui-btn-left">
            	返回
        </a>
        <h3>
        	    问卷调查
        </h3>
    </div>
    <div data-role="content">
      <form id="formPostId" action="/surveyform" method="POST" class="formPost" data-ajax="false">      
        <div data-role="fieldcontain" id="surveyTitleId" class="surveyTitle">
            <label for="surveyTitleId">
             	   标题
            </label>
            <input name="surveyTitle" id="surveyTitleId" placeholder="" value="" type="text">
        </div>
        <div data-role="fieldcontain" id="dateCreatedId" class="dateCreated">
            <label for="dateCreatedId">
           	     时间
            </label>
            <input name="dateCreated" id="dateCreatedId" placeholder="" value="" type="date">
        </div>
        <div data-role="fieldcontain" id="surrveyNarrativeId" class="surrveyNarrative">
            <label for="surrveyNarrativeId">
            	    描述
            </label>
            <textarea name="surrveyNarrative" id="surrveyNarrativeId" placeholder="">请输入</textarea>
        </div>
        <input type="submit" value="Submit">
    </div>
</div>
</form>
  </body>
</html>
