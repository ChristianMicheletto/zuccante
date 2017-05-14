<?php
// start server using "php -S localhost:8080 -t <path>/template01/"
$f3 = require('../fatfree-master/lib/base.php');
// set framework (global) variavles
$f3->set('name','Andrea');
$f3->set('surname','Morettin');
$f3->set('figure',array('fante','cavallo','re'));
$f3->set('fruits',array(' plum','               cherry','kiwi'));
$f3->set('pagn',$f3->get('PARAMS.number'));

// a simple template
$f3->route('GET /',
    function($f3) {
        echo View::instance()->render('template.html');
        /* ... ovvero ....
        $view = new View;
        echo $view->render('template.htm');
        */
    }
);
// ... working with array
$f3->route('GET /bis',
    function($f3) {
        // \ is the global namespace (you work with the same instance, i.e. as a singleton) 
        echo \Template::instance()->render('template_bis.html');
    }
);
// ... working with array
$f3->route('GET /pag/@number',
    function($f3) {
        echo \Template::instance()->render('pages.html');
    }
);

$f3->run();
?>
