ALTER TABLE tb_noticias
DROP FOREIGN KEY fk_tb_eti_tb_not_id_etiqueta;

ALTER TABLE tb_noticias
DROP COLUMN id_etiqueta;

ALTER TABLE tb_noticias
ADD COLUMN etiquetas VARCHAR(25);