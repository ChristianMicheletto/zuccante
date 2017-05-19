<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>My Site</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-6">
      <form class="form-signin" method="POST" action="/authenticate">
      <h2 class="form-signin-heading">Sign in</h2>
      <div class="form-group">
        <label for="usr">Name:</label>
        <input type="text" class="form-control" name="username" id="usr">
      </div>
     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" class="form-control" name="password" id="pwd">
       <button type="submit" class="btn btn-default">Submit</button>
    </div>
     
    </div>
    <div class="col-sm-6">
      <h3>A text</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>

</body>
</html>
