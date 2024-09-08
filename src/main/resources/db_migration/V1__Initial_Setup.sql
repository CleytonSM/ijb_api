CREATE TABLE tb_usuario (
    id_usuario INTEGER AUTO_INCREMENT,
    email VARCHAR(60) CONSTRAINT uq_tb_usuario_email UNIQUE,
    senha VARCHAR(40),
    CONSTRAINT pk_tb_usuario_id_usuario PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_funcao (
    id_funcao INTEGER AUTO_INCREMENT,
    nm_funcao VARCHAR(30),
    CONSTRAINT pk_tb_funcao_id_funcao PRIMARY KEY (id_funcao)
);