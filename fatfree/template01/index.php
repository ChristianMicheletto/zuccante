<?php
// start server using "php -S localhost:8080 -t <path>/template01/"
$f3 = require('../fatfree-master/lib/base.php');

$f3->route('GET /',
    function($f3) {
        $f3->set('name','andrea');
        $f3->set('surname','morettin');
        echo View::instance()->render('template.html');
        /* ... ovvero ....
        $view=new View;
        echo $view->render('template.htm');
        */
    }
);
$f3->run();
?>
