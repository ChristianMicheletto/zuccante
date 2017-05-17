<?php

class UserController{

    function render(){
        echo \Template::instance()->render('login.html');
    }

    /*
    function beforeroute(){ *** DO NOTHING *** }

    function afteroute(){ *** DO NOTHING *** }
    */

    function login($f3) {

        $username = $f3->get('POST.username');
        $password = $f3->get('POST.password');

        $user = new User($db);
        $user->getByName($username);

        if($user->dry()) {
            $f3->reroute('/login');
        }

        if(password_verify($password, $user->password)) {
            $f3->set('SESSION.user', $user->username);
            $f3->reroute('/');
        } else {
            $f3->reroute('/login');
        }
    }

    function logout($f3) {
        $f3->unset('SESSION.user');
        $f3->reroute('/');
    }
}