/* user exists / get user */
select * from users where name = 'eduardo'
String.format("select users.name from users where name = '%s'", username);

/* user login is valid */
select name from users where name = 'eduardo' and password = 'eduardo'
String.format("select name from users where name = '%s' and password = '%s'", username, password);

/* register user */
insert into users (NAME, PASSWORD) VALUES ('lucas1', 'lucas1')
String.format("insert into users (NAME, PASSWORD) VALUES ('%s', '%s')", username, password);

/* get questions */
SELECT * FROM questions
String.format("SELECT * FROM questions");

/* get answers */
SELECT * FROM answers
String.format("SELECT * FROM answers");

/* insert into leaderboard */
insert into leaderboard (NAME, SCORE) VALUES ('eduardo', 30)
String.format("insert into leaderboard (NAME, SCORE) VALUES ('%s', %2d)", username, score);

/* get leaderboard top 10 */
select * from leaderboard order by score desc limit 10
String.format("select * from leaderboard order by score desc limit 10);