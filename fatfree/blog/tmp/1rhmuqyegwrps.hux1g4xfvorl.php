<h1>Edit</h1>
<form name="blog" method="post" action="<?= $BASE ?><?= $PARAMS[0] ?>" >
  <label for='title'>Title: </label><br /><input type="text" name="title" id="title" value="<?= isset($POST['title'])?htmlspecialchars($POST['title']):'' ?>" size="60"/><br />
  <label for='author'>Author: </label><br /><input type="text" name="author" id="author" value="<?= isset($POST['author'])?htmlspecialchars($POST['author']):'' ?>" size="60"/><br />
  <label for='summary'>Summary: </label><br /><textarea name="summary" id="summary" cols="60" rows="10"><?= isset($POST['summary'])?htmlspecialchars($POST['summary']):'' ?></textarea><br />
  <label for='content'>Content: </label><br /><textarea name="content" id="content" cols="60" rows="10"><?= isset($POST['content'])?htmlspecialchars($POST['content']):'' ?></textarea><br />
  <input type="submit" value="Submit"/>
</form>