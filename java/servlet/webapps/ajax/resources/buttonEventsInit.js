$(document).ready(function() {
	
    $("button").click(function(event) {
    	
    	// get button ID
    	var buttonID = event.target.id;
    	
        // http://api.jquery.com/jQuery.get/ *******************************
    	//
    	// 		1. A string containing the URL to which the request is sent. (our servlet)
    	//		2. A plain object or string that is sent to the server with the request. (trigger)
    	//		3. A callback function that is executed if the request succeeds.
        //
    	//      .done(function() {
        //          alert( "second success" );
        //      })
        //      .fail(function() {
        //          alert( "error" );
        //      })
        //      .always(function() {
        //      alert( "finished" );
        //      });
        //
        // ****************************************************************
        
    	$.get('DBRetrievalServlet', {"button-id": buttonID},
            function(resp) { 
    			// handling a JSON object.
    			if (buttonID === "bands")
    				printBands(resp); // from resultsPrinter.js
    			else if (buttonID === "bands-albums")
    				printBandsAndAlbums(resp);  // from resultsPrinter.js
            })
            .fail(function() { 
                alert("Request failed.");
            });
    });  
});
