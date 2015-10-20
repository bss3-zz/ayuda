# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ong (
  id                        bigint not null,
  nome                      varchar(255),
  descricao                 varchar(255),
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
  constraint pk_voluntario primary key (id))
;

create sequence ong_seq;

create sequence projeto_seq;

create sequence usuario_seq;

create sequence voluntario_seq;




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

