<?php

// start server using "php -S localhost:8080 -t <path>/db01"
$f3 = require('../fatfree-master/lib/base.php');
// set fatfree variables
$f3->set('DEBUG',3); // set debug fatfree variable
$f3->set('UI','ui/'); // set template and html variabòe

// set database and the framework variable db
$db = new DB\SQL(
  'mysql:host=localhost;port=3306;dbname=fatblog',
  'fat',
  'fat@2017'
  );
$f3->set("db", $db);


$f3->route('GET /',
  function ($f3) {
    $f3->set('html_title','Home Page');
    // set the mappre, article is in dry state
    $article = new DB\SQL\Mapper($f3->get('db'),'Articles');
    $f3->set('list',$article->find());
    $f3->set('content','blog_home.html');
    echo \Template::instance()->render('layout.html');
  }
);

$f3->route('GET /view/@id',
  function ($f3, $params) {
    $id = $params['id']; // the same as $id = $f3->get('PARAMS.id');
    //create Mapper object and search for id
    $article = new DB\SQL\Mapper($f3->get('db'),'Articles');
    $article->load(array('id=?', $id));
    //set framework variables
    $f3->set('html_title', $article->title);
    $article->copyTo('GET');
    $article->copyTo('POST');
    //serve up the view
    $f3->set('content', 'blog_detail.html');
    echo \Template::instance()->render('layout.html');
  }
);

// Admin Home
$f3->route('GET /admin',
  function ($f3) {
    $f3->set('html_title','My Blog Administration');
    //assign a mapper to the user table
    $user = new DB\SQL\Mapper($f3->get('db'),'Users');
    // tell Auth what database fields to use, 
    // see https://fatfreeframework.com/3.6/auth
    $auth = new \Auth($user,
      array('id'=>'name','pw'=>'password')); // real colum names
    // will display an HTTP 401 Unauthorized error page if unsuccessful
    $auth->basic();
    // store the name they logged in with 
    // see http://php.net/manual/en/features.http-auth.php
    $f3->set('SESSION.user','SERVER.PHP_AUTH_USER');

    $article = new DB\SQL\Mapper($f3->get('db'),'Articles');
    $list=$article->find();
    $f3->set('list',$list);
    //display the admin view
    $f3->set('content','admin_home.html');
    echo \Template::instance()->render('layout.html');
  }
);
 
//Admin Add
$f3->route('GET /admin/add',
  function($f3) {
    if (!$f3->get('SESSION.user')) $f3->error(401);
    $f3->set('html_title','My Blog Create');
    $f3->set('content','admin_edit.html');
    echo \Template::instance()->render('layout.html');
  }
);
 
//Admin Edit 
$f3->route('GET /admin/edit/@id',
  function($f3, $params) {
    if (!$f3->get('SESSION.user')) $f3->error(401);
    $f3->set('html_title','My Blog Edit');
    $id = $params['id'];
    $article=new DB\SQL\Mapper($f3->get('db'),'Articles');
    $article->load(array('id=?',$id));
    $article->copyTo('POST');
    $f3->set('content','admin_edit.html');
    echo \Template::instance()->render('layout.html');
  }
);
 
//Admin Add and Edit both deal with Form Posts
//don't use a lambda function here
$f3->route('POST /admin/edit/@id','edit');
$f3->route('POST /admin/add','edit');
function edit($f3, $params) {
  //check they are allowed access
  if (!$f3->get('SESSION.user')) 
    $f3->error(401);
  $id = $params['id'];
  //create an article object
  $article = new DB\SQL\Mapper($f3->get('db'),'Articles');
  //if we don't load it first Mapper will do an insert instead of update when we use save command
  if ($id) $article->load(array('id=?',$id));
  //overwrite with values just submitted
  $article->copyFrom('POST');
  //create a timestamp in MySQL format
  $article->timestamp = date("Y-m-d H:i:s");
  $article->save();
  // Return to admin home page, new blog entry should now be there
  $f3->reroute('/admin');
}
 
//Admin Delete
$f3->route('GET /admin/delete/@id',
  function($f3, $params){
    if (!$f3->get('SESSION.user')) $f3->error(401);
    $id = $params['id'];
    $article = new DB\SQL\Mapper($f3->get('db'),'Articles');
    $article->load(array('id=?',$id));
    $article->erase();
    $f3->reroute('/admin');
  }
);

$f3->run();
?>