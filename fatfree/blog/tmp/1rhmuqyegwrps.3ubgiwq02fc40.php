<h1>Blog Titles</h1>
<?php foreach (($list?:[]) as $item): ?>
  <p><a href="view/<?= $item['id'] ?>"><?= trim($item['title']) ?></a> by <?= $item['author'] ?></p>
  <p><?= $item['summary'] ?></p>
<?php endforeach; ?>