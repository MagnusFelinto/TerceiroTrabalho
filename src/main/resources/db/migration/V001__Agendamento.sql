create table Agendamento(
    id              bigint not null auto_increment,
    nome            varchar(60)  not null,
    email           varchar(120) not null,
    horarioEntrada  datetime     not null,
    horarioSaida    datetime     not null, 
    primary key (id)
)





