DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;


CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL
);

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('admin','$2y$12$KCmKEbSF9Jeq8HQAWcSzIu/fgEBe8dEW2CQs1vRLyDDACzD6kQ16O',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');
 
insert into users(username, password, enabled)values('user','$2y$12$0M9iYASCHzHBq3dgEJO.juiJMwPiEI9RtEppdPJGrOZtJ.jJ40fOm',true);
insert into authorities(username,authority)values('user','ROLE_USER');