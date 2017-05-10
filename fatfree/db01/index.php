<?php
// start server using "php -S localhost:8080 -t <path>/db01"
$f3 = require('../fatfree-master/lib/base.php');
// set database
        $db=new DB\SQL(
            'mysql:host=localhost;port=3306;dbname=fat01',
             'fat',
             'fat@2017'
        );
// set a fatfree global variable
$f3->set('db',$db);

// view page
$f3->route('GET @main: /',
    function($f3) {
        // obtain db
        $db = $f3->get('db');
        $f3->set('result', $db->exec('SELECT name, quantity, price FROM Products'));
        echo Template::instance()->render('main.html');
    }
);

$f3->route('POST /',
    function($f3) {
        $db = $f3->get('db');
        /* insert the new produc
           if F3 detects that the value of the query parameter/token is a string, 
           the underlying data access layer escapes the string and adds quotes as necessary
        */
        $db->exec('INSERT INTO Products VALUES(NULL,?,?,?,?)',
             array($f3->get('POST.code'),$f3->get('POST.name'),$f3->get('POST.quantity'),$f3->get('POST.price'))
             );
        $f3->set('result', $db->exec('SELECT name, quantity, price FROM Products'));
        echo Template::instance()->render('main.html');
    }
);





$f3->run();
?>
