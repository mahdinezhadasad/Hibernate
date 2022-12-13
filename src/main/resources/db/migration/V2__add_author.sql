create table author
(
    id         bigint not null,
    firstName varchar(255),
    lastName varchar(255),
    primary key (id)
) engine = InnoDB;