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
		var surveyId = <%=request.getParameter("surveyId")%>;
		$.ajax({	
			type: "GET", 
			url: "questionlist?surveyId="+surveyId+"",
			dataType: "json",
			success: function(data) {
				var keyCount = 0;
				$.each(data.questionJson, function(key, value) {
					var temp = new Array();
					temp = key.split("-+");
					keyCount++;
				    var html='<fieldset id="listPlayers" data-role="controlgroup"><legend><h3>'+ keyCount + '.'+ temp[1] +'<a href="/questionedit.jsp?surveyId='+surveyId+'&questionId='+temp[0]+'">/编辑</a></h3></legend>';
				    for(var int=0; int<value.length; int ++) {
				    	html+='<input type="checkbox" name="itemSelect" id="checkbox-'+int+'a" class="custom" value="'+ (keyCount-1) + '-' + value[int] +'" ><label for="checkbox-'+int+'a">'+value[int]+'</label>';
				    }
				    $("#checkboxes").append(html+'</fieldset');  
					//var temp = $("<fieldset data-role='controlgroup' data-type='vertical' id='questionFieldset'>");
					//var temp2 = $("</fieldset>");
					//var questionTitleList = $("<legend>" + key + "</legend>");
					//var questionOptionList = $("<input id='"+ key +"' name=''  type='checkbox' ><label for='"+ key +"'>" + value[0]+ "</label>");
					//var questionOptionList1 = $("<input id='"+ value[1] +"' name='' type='checkbox' ><label for='"+ value[1] +"'>" + value[1]+ "</label>");
					//$("#questionFieldset").append(questionTitleList).append(questionOptionList).append(questionOptionList1);
					//$("input[type='checkbox']").attr("checked",false).checkboxradio("refresh");
					//$("#checkboxes").append(temp).append(questionTitleList).append(questionOptionList).append(temp2);
					$("#checkboxes").trigger('create');
				}); 
			}
			
		});
		
	});
</script> 


<title>问卷题目</title>
</head>
<body>
<div data-role="page" id="page2">
    <div data-theme="b" data-role="header">
   		<a data-role="button" href="/surveylist.jsp"  class="ui-btn-left" data-ajax="false">
            	返回
        </a>
        <h3>
            	问卷题目
        </h3>
        <a data-role="button" data-theme="b" href="/questionadd.jsp?surveyId=<%=request.getParameter("surveyId") %>" data-icon="plus" data-iconpos="left" class="ui-btn-right">
            	新增
        </a>
    </div>
    <div data-role="content" id="checkbox_content">
        <div id="checkboxes" data-role="fieldcontain">
        <fieldset id="listPlayers" data-role="controlgroup">
        </fieldset>
        </div>
    	<a href="/questionlist.jsp?surveyId=<%=request.getParameter("surveyId")%>" data-ajax="false" data-role="button" id="completeButton" >发布问卷</a>
    </div>
     
    
</div>
</body>
</html>