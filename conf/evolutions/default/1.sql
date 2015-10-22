# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ong (
  id                        bigint not null,
  nome                      varchar(255),
  descricao                 varchar(255),
  usuario_id                bigint,
  constraint uq_ong_usuario_id unique (usuario_id),
  constraint pk_ong primary key (id))
;

create table projeto (
  id                        bigint not null,
  nome                      varchar(255),
  objetivo                  varchar(255),
  valor_arrecadar           varchar(255),
  data_inicio               timestamp,
  data_fim                  timestamp,
  url_foto                  varchar(255),
  url_video                 varchar(255),
  descricao_completa        varchar(255),
  constraint pk_projeto primary key (id))
;

create table usuario (
  id                        bigint not null,
  usuario                   varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (id))
;

create table voluntario (
  id                        bigint not null,
  nome                      varchar(255),
  cpf                       varchar(255),
  telefone                  varchar(255),
  usuario_id                bigint,
  constraint uq_voluntario_usuario_id unique (usuario_id),
  constraint pk_voluntario primary key (id))
;

create sequence ong_seq;

create sequence projeto_seq;

create sequence usuario_seq;

create sequence voluntario_seq;

alter table ong add constraint fk_ong_usuario_1 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_ong_usuario_1 on ong (usuario_id);
alter table voluntario add constraint fk_voluntario_usuario_2 foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_voluntario_usuario_2 on voluntario (usuario_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ong;

drop table if exists projeto;

drop table if exists usuario;

drop table if exists voluntario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ong_seq;

drop sequence if exists projeto_seq;

drop sequence if exists usuario_seq;

drop sequence if exists voluntario_seq;

