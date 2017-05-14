<!DOCTYPE html>
<html>
  <head>
    <title><?= $html_title ?></title>
  </head>
  <body>
    <?php echo $this->render($content,NULL,get_defined_vars(),0); ?>
  </body>
</html>