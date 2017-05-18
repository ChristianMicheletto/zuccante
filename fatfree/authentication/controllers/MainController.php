<?php

class MainController {

	/*
    function beforeroute(){ *** DO NOTHING *** }

    function afteroute(){ *** DO NOTHING *** }
    */

	function display(){
		echo \Template::instance()->render('main.html');
	}

}
?>