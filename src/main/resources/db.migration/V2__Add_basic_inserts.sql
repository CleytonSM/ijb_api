INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_ADMIN', 'ADMIN', NULL, NOW(), NOW(), NULL);

INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_FINANCEIRO', 'FINANCEIRO', 'FINANCEIRO', NOW(), NOW(), NULL);

INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_VOLUNTARIO_BRONZE', 'VOLUNTARIO', 'VOLUNTARIO', NOW(), NOW(), NULL);

INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_VOLUNTARIO_PRATA', 'VOLUNTARIO', 'VOLUNTARIO', NOW(), NOW(), NULL);

INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_VOLUNTARIO_OURO', 'VOLUNTARIO', 'VOLUNTARIO', NOW(), NOW(), NULL);

INSERT INTO tb_funcao (nm_funcao, ds_funcao, modulo, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('ROLE_BENEFICIARIO', 'BENEFICIARIO', 'BENEFICIARIO', NOW(), NOW(), NULL);


INSERT INTO tb_tipos_voluntarios(nm_tipo_voluntario, dt_criacao, dt_alteracao, dt_exclusao)
VALUES ('VOLUNTARIO', NOW(), NOW(), NULL);