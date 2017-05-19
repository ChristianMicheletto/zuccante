<?php
// start server using "php -S localhost:8080 -t <path>/authentication"
$f3 = require('../fatfree-master/lib/base.php');
// debug level
$f3->set('DEBUG',3);
// configuration
$f3->config('setups.cfg');
$f3->config('routes.cfg');
// connect to databases;
// set database
$db = new DB\SQL(
    $f3->get(devdb),
    $f3->get(devuser),
    $f3->get(devpwd)
);
// set a fatfree global variable
$f3->set('db',$db);
$f3->set('logged', $f3->exists('SESSION.user'));

// run server
$f3->run();

?>