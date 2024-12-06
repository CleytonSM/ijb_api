INSERT INTO tb_usuarios (email, cpf, senha, dt_criacao)
VALUES ('admin', '', '$2a$12$QVnn/RFXX3BZv/lSnFN.3OX8dw.oxtgBJsf4uUAViYna2OVUKmwaC', NOW());

INSERT INTO tb_infos_usuario (id_usuario, id_funcao, nome, dt_registro, dt_criacao)
VALUES((SELECT email FROM tb_usuarios WHERE email = 'admin'), 1, admin, NOW(), NOW());
