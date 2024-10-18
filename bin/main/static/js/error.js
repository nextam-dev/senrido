//---------------------------
// エラー処理
//---------------------------
function err_function(err) {
	try {
	    if(err.response.status == "403") {
	    	var baseUrl = $('#baseUrl').val();
	        window.location.href = baseUrl + "error/403.html";
	    }
	    else if(err.response.status == "404") {
	    	var baseUrl = $('#baseUrl').val();
	        window.location.href = baseUrl + "error/404.html";
	    }
	    else {
	    	var baseUrl = $('#baseUrl').val();
	        window.location.href = baseUrl + "error.html";
	    }
	}
    catch (e) {
    	var baseUrl = $('#baseUrl').val();
        window.location.href = baseUrl + "error.html";
    }
}

