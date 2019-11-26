CREATE SEQUENCE public.sq_pk_empresa START 1;

--CREATE TABLE empresa (
--id BIGSERIAL NOT NULL DEFAULT nextval('public.sq_pk_empresa'),
--cnpj varchar(30) NOT NULL,
--data_atualizacao TIMESTAMP NOT NULL,
--data_criacao TIMESTAMP NOT NULL,
--razao_social varchar(150) NOT NULL,
--CONSTRAINT pk_empresa PRIMARY KEY (id)
--);



--drop sequence if exists sq_pk_empresa cascade;
--drop sequence if exists sq_pk_funcionario cascade;
--drop sequence if exists sq_pk_lancamento cascade;

--drop table if exists empresa cascade;
--drop table if exists funcionario cascade;
--drop table if exists lancamento cascade;

--delete from flyway_schema_history where installed_by >= '1'

--CREATE SEQUENCE hibernate_sequence START 1;
