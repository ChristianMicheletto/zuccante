<?php

class MainController {

	/*
    function beforeroute(){ *** DO NOTHING *** }

    function afteroute(){ *** DO NOTHING *** }
    */

	function render($f3){
		$f3->set('name','world');
		echo \Template::instance()->render('template.html');
	}

	function sayhello(){
		echo 'Hello, babe!';
	}
}
?>