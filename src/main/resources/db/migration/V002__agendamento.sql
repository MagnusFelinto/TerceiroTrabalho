create table agendamento(
    id              bigint not null auto_increment,
    usuario_id      bigint not null,
    titulo          varchar(100),
    descricao       varchar(300),
    horarioentrada  varchar(20) not null, 
    status          varchar(20) not null,
    primary key (id)
    
);
alter table agendamento add constraint fk_agendamento_usuario
foreign key (usuario_id) references usuario (id);

