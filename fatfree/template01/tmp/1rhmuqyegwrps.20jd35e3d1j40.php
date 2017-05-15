<!DOCTYPE html>
<html>
  <head>
    <title>template01</title>
  </head>
<body>

<p>We are in <?= $pagn ?></p>


<?php if ($pagn==1): ?>
    
        <p>We are in pag.1</p>
    
    <?php else: ?>
       <p><i>We are not in pag.1</i></p>
    
<?php endif; ?>
<?php if ($pagn==2): ?>
    
        <p>We are in pag.2</p>
    
    <?php else: ?>
       <p><i>We are not in pag.2</i></p>
    
<?php endif; ?>

</body>
</html>
