<?php
// start server using "php -S localhost:8080 -t /var/www/html/fatfree/routing/"

$f3 = require('../fatfree-master/lib/base.php');
// home
$f3->route('GET /',
    function() {
        echo 'Home!';
    }
);
// another routing example
$f3->route('GET /are',
    function() {
        echo 'another route example!';
    }
);
// using params
$f3->route('GET /brew/@count',
    function($f3,$params) {
        echo $params['count'].' bottles of beer on the wall.';
    }
);
// redirect
$f3->route('GET|HEAD /google',
    function($f3) {
        $f3->reroute('http://www.google.com');
    }
);
// an oop routing
$f3->route('GET /oop','WebPage->display');
// a named rout
$f3->route('GET @nr: /nr', 
  function() {
        echo 'named route!';
    }
);
// using named route
// $f3->reroute('@nr'); // note the single quotes

$f3->run();
// the class for oop routing
class WebPage {
    function display() {
        echo 'I cannot object to an object';
    }
}

?>
