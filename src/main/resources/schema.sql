DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
    ID int primary key auto_increment,
    name varchar(100),
    age int,
    dateOfBirth date,
    email varchar(100),
    isMarried boolean,
    wedAnniv date
);