/* ユーザーテーブル */
CREATE TABLE IF NOT EXISTS m_user (
	user_id VARCHAR(50) PRIMARY KEY
	, password VARCHAR(100)
	, user_name VARCHAR(50)
	, age INT
	, birthday DATE
	, gender INT
	, role CHAR(50)
);

/* 初期データ */
INSERT INTO m_user (
	user_id,
	password,
	user_name,
	birthday,
	age,
	gender,
	role
)
VALUES(
	'system@co.jp',
	'"$2a$10$G8m7Gg1mXsEWT/EAwiU4XO4ZRT3gTnecPpUJk.EoJmQQ8QAsJ2yMO"',/* password */
	'Admin',
	'2000-01-01',
	21,
	1,
	'ROLE_ADMIN'
),(
	'user@co.jp',
	'"$2a$10$G8m7Gg1mXsEWT/EAwiU4XO4ZRT3gTnecPpUJk.EoJmQQ8QAsJ2yMO"',/* password */
	'User1',
	'2000-01-01',
	21,
	2,
	'ROLE_GENERAL'
)