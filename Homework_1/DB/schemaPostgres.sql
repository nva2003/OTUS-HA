-- DROP DATABASE myDB;
CREATE DATABASE myDB;
-- USE myDB;
-- ----------------------------------
-- Schema myDB
-- ----------------------------------
-- Create table
CREATE TABLE users (
                       user_id  SERIAL,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,
                       age INTEGER NOT NULL,
                       sex VARCHAR(100) NOT NULL DEFAULT 'UNKNOWN',
                       interest VARCHAR(100) NOT NULL,
                       city VARCHAR(100) NOT NULL,
                       status VARCHAR(45)  NULL DEFAULT '1',
                       enabled SMALLINT NOT NULL DEFAULT 1,
                       PRIMARY KEY (user_id)
);

alter table users
    add constraint USERS_UK unique (username);


CREATE TABLE friends (
                         user_id BIGINT not null,
                         friend_id BIGINT not null
);

CREATE TABLE messages (
                          message_id SERIAL,
                          from_id BIGINT not null,
                          to_id BIGINT not null,
                          content TEXT,
                          time timestamp,
                          PRIMARY KEY (message_id)
);

alter table messages
    add constraint fk_messages_from foreign key (from_id) references users(user_id);
alter table messages
    add constraint fk_messages_to foreign key (to_id) references users(user_id);

-- ----------------------------------
--  If we run the MySQL command SHOW TABLES,
--  we can see tables inside our database myDB,
--  which are defined inside the schemaMySQL.sql.
-- ----------------------------------
-- USE myDB;

-- \dt public.*;

SELECT * FROM pg_catalog.pg_tables;

select column_name, data_type from information_schema.columns
where table_name = 'users';


