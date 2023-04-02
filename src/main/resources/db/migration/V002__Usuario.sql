create table Usuario(
    id      bigint not null auto_increment,
    nome    varchar(60)  not null,
    email   varchar(60)  not null,
    senha   varchar(60)  not null,  
    primary key (id)
)