<?php

class MainController {

	/*
    function beforeroute(){ *** DO NOTHING *** }

    function afteroute(){ *** DO NOTHING *** }
    */

	function display($f3){
		$f3->set('logged', $f3->exists('SESSION.user'));
		echo \Template::instance()->render('main.html');
	}

}
?>