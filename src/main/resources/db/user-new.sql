DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id          BIGINT(20) NOT NULL COMMENT '主键ID' AUTO_INCREMENT,
-- 			 id    VARCHAR(32) NOT NULL COMMENT '主键ID', -- UUID
    name        VARCHAR(32) NULL DEFAULT NULL COMMENT '姓名',
    age         INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email       VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    create_time DATETIME DEFAULT NULL,
    update_time DATETIME DEFAULT NULL,
    version     INT(2) DEFAULT 1,
    PRIMARY KEY (id)
);

DELETE
FROM user;

INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');

select *
from user;