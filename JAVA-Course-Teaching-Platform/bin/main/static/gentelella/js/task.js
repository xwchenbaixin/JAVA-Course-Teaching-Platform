$(document).ready(function() {	
	$('.btn').click(function(){
		$.ajax({
	        url: "http://localhost:8080/task/"+$("#search").val()
	    }).then(function(data) {
	    	$("#content").empty();
	    	$("#content").append("<h1>"+data.id+"、"+data.title+"</h1>")
	    	$("#content").append(data.description)
	    	
	    });
	});    
});