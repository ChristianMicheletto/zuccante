<?php

class UserController {

    function display(){
        echo \Template::instance()->render('login.html');
    }

    /*
    function beforeroute(){ *** DO NOTHING *** }

    function afteroute(){ *** DO NOTHING *** }
    */

    function authenticate($f3) {

        $username = $f3->get('POST.username');
        $password = $f3->get('POST.password');

        $user = new User($f3->get('db'));
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
        $f3->clear('POST'); // fit prudentia
        $f3->clear('SESSION.user');
        $f3->reroute('/');
    }
}