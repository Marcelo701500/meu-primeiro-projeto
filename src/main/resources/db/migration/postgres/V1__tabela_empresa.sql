CREATE SEQUENCE public.sq_pk_empresa START 1;

CREATE TABLE 'empresa' (
id BIGINT NOT NULL DEFAULT nextval('public.sq_pk_empresa'),
'cnpj' varchar(30) NOT NULL,
'data_atualizacao' datetime NOT NULL,
'data_criacao' datetime NOT NULL,
'razao_social' varchar(150) NOT NULL,
CONSTRAINT pk_empresa PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



  
