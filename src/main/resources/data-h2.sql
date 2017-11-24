-- SQL FILE USED TO LOAD DATA MANUALY VIA FILE
-- Throws an error unless called "data-h2"

INSERT INTO author(author.ID,author.NAME,author.ABOUT) VALUES (1, 'djuro', 'o meni');
INSERT INTO author(author.ID,author.NAME,author.ABOUT) VALUES (2, 'neko', 'o nekom');
INSERT INTO article(article.ID,article.title,article.body,article.poste,article.Author_id) VALUES (1, 'artikl1', 'ovde se nalazi telo artikla', CURRENT_DATE, 1);
INSERT INTO article(article.ID,article.title,article.body,article.posted,article.Author_id) VALUES (2, 'artikl2', 'ovde se nalazi telo artikla2', CURRENT_DATE, 1);
INSERT INTO article(article.ID,article.title,article.body,article.posted,article.Author_id) VALUES (3, 'artikl3', 'ovde se nalazi telo artikla3', CURRENT_DATE, 2);


