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
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "questionlist?surveyId=<%=request.getParameter("surveyId")%>",
			dataType: "json",
			success: function(data) {
				var keyCount = 0;
				$.each(data.questionJson, function(key, value) {
					var temp = new Array();
					temp = key.split("-+");
					keyCount++;
				    var html='<fieldset id="listPlayers" data-role="controlgroup"><legend><h3>'+ keyCount + '.'+ temp[1] +'</h3></legend>';
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
		
		 $('#submitButton').bind("click", (function() {
				var selectedItems = new Array();
				$("input[type=checkbox]:checked").each(function() {
					selectedItems.push($(this).val());
				});
					
				if(selectedItems.length != 0 ) {
					$.ajax({
						type: "POST",
						url: "resultsanalysis",
						data: "surveyId=<%=request.getParameter("surveyId")%>&items=" + selectedItems.join('|'),
						dataType: "text",
						
						success: function(request) {
							document.location.reload();
						}
					});
				}
			}));
	})
</script> 


<title>问卷题目</title>
</head>
<body>
<div data-role="page" id="page1">
    <div data-theme="b" data-role="header">
        <h3>
            	问卷题目
        </h3>
    </div>
    <div data-role="content" id="checkbox_content">
        <div id="checkboxes" data-role="fieldcontain">
        <fieldset id="listPlayers" data-role="controlgroup">
        </fieldset>
        </div>
    	<a data-role="button" id="submitButton" >提交</a>
    </div>
     
    
</div>
</body>
</html>