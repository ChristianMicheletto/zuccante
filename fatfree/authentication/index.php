<?php
// start server using "php -S localhost:8080 -t <path>/db01"
$f3 = require('../fatfree-master/lib/base.php');
$f3->set('DEBUG',3);
$f3->config('setup.cfg');
// connect to databases;
// set database
$db=new DB\SQL(
    'mysql:host=localhost;port=3306;dbname=fat02',
    'fat',
    'fat@2017'
);
// set a fatfree global variable
$f3->set('db',$db);

// run server
$f3->run();
?>