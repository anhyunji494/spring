CREATE TABLE BOARD(
 	IDX INT NOT NULL AUTO_INCREMENT,
 	TITLE VARCHAR(100) NOT NULL,
 	CONTENT VARCHAR(2000) NOT NULL,
 	WRITER VARCHAR(30) NOT NULL,
 	INDATE DATETIME DEFAULT NOW(),
 	COUNT INT DEFAULT 0,
 	PRIMARY KEY(IDX)
);

INSERT INTO BOARD(TITLE,CONTENT,WRITER)
VALUES('레이니즘','레이니즘','비');

CREATE TABLE REPLY(
	IDX INT NOT NULL AUTO_INCREMENT,
	BOARDNUM INT NOT NULL,
	WRITER VARCHAR(30) NOT NULL,
	CONTENT VARCHAR(2000) NOT NULL,
	INDATE DATETIME DEFAULT NOW(),
	PRIMARY KEY(IDX)
);

DROP TABLE REPLY;

SELECT * FROM REPLY;
