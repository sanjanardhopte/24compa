logindemo – JSP Servlet JDBC project

features
- login using JDBC
- session management
- update password
- logout

technologies used
- JSP
- servlet
- JDBC
- MySQL
- Apache Tomcat

database setup
create database authdb
use authdb

create table users (
  id int primary key auto_increment,
  username varchar(50),
  password varchar(50)
)

insert into users(username, password) values ('admin', '1234')
