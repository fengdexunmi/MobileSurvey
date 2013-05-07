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
    <script type="text/javascript">
    $(document).ready(function() {
    document.oncontextmenu = function() {return false;};
   	 $.ajax({
  	      type:"GET",
  	      url:"surveyjson",
  		  dataType:"json",
  		  success:function(data){
  				$.each(data.surveyJson, function(i, item) { 
  					var temp = new Array();
  					temp = item[0].split('-+');
  					var survey_list = $("<li><a class='taphold' href='/questionnaire.jsp?surveyId="+temp[0]+"' data-transition='slide' data-ajax='false' id="+temp[0]+"><h3>"+temp[1]+"</h3><p>"+ item[1]+"</p></a></li>");
  					$("#survey_list").append(survey_list);
              		$('ul').listview('refresh');
            		$("#survey_list").find("li:last").slideDown(300);
  					//$("#survey_list").trigger('create');
  		  		});
  				
  				//长按某个href，则跳转至编辑页面
  			 	$("a.taphold").on('taphold', function(e){
  			 		e.preventDefault();
  			        window.location.href="/surveyedit.jsp?surveyId="+$(this).attr('id')+"";
  				});
  		  }
      });
   
    })
    </script>

<title>调查问卷</title>
</head>
<body>
<div data-role="page" id="page1">
 	<div data-theme="b" data-role="header">
 	 	<a data-role="button" data-theme="b" href="surveyadd.jsp" data-icon="plus" data-iconpos="left" class="ui-btn-right">
            	新建
        </a>
        <h3>
         	   问卷调查
        </h3>
    </div>
    <div data-role="content" id="surveyList_Content">
    	 <ul data-role="listview"  data-inset="true" id="survey_list">
         </ul>
    </div>
</div>
</body>
</html>