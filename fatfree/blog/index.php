<?php
// start server using "php -S localhost:8080 -t <path>/db01"
$f3 = require('../fatfree-master/lib/base.php');
// set database
        $db=new DB\SQL(
            'mysql:host=localhost;port=3306;dbname=fatblog',
             'fat',
             'fat@2017'
        );
);

// Admin Home
$f3->route('GET /admin',
  function ($f3) {
  }
);
 
//Admin Add
$f3->route('GET /admin/add',
  function($f3) {
  }
);
 
//Admin Edit 
$f3->route('GET /admin/edit/@id',
  function($f3) {
  }
);
 
//Admin Add and Edit both deal with Form Posts
//don't use a lambda function here
$f3->route('POST /admin/edit/@id','edit');
$f3->route('POST /admin/add','edit');
function edit($f3) {
}
 
//Admin Delete
$f3->route('GET /admin/delete/@id',
  function($





$f3->run();
?>
