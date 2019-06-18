/**
 * 
 */
function testClick(){
	alert("fff")
	$("#testClick").empty();
	$("#testClick").html('<input type="button" onclick="testClick()">');
}