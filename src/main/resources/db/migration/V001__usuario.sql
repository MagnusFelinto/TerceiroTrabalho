create table usuario(
    id          bigint not null auto_increment,
    nome        varchar(100)  not null,
    email       varchar(80)   not null,
    urlavatar   varchar(300)   not null,
    senha       varchar(60)   not null,  
    primary key (id)
)