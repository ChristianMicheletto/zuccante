<?php
class Controller {
	protected $f3;
    protected $db;

    function __construct() {
 
        // $f3 = require('../fatfree-master/lib/base.php');
 
        $db = $f3->get('db');
 
    $this->f3=$f3;
    $this->db=$db;
    }
}
?>