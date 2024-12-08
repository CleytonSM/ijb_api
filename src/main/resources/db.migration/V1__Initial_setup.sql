CREATE TABLE tb_usuarios (
    id_usuario INTEGER NOT NULL AUTO_INCREMENT,
    email VARCHAR(100),
    cpf VARCHAR(11),
    senha VARCHAR(30),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_funcao (
    id_funcao INTEGER AUTO_INCREMENT,
    nm_funcao VARCHAR(50),
    ds_funcao VARCHAR(300),
    modulo VARCHAR(60),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_funcao)
);

CREATE TABLE tb_infos_usuario (
    id_usuario INTEGER NOT NULL,
    id_funcao INTEGER NOT NULL,
    celular1 VARCHAR(11),
    celular2 VARCHAR(11),
    foto_perfil LONGBLOB,
    nome VARCHAR(40),
    sobrenome VARCHAR(70),
    dt_nascimento DATE,
    rg VARCHAR(9),
    dt_registro DATE,
    ativo BOOL,
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuarios (id_usuario),
    FOREIGN KEY (id_funcao) REFERENCES tb_funcao (id_funcao)
);

CREATE TABLE tb_enderecos (
    id_endereco INTEGER AUTO_INCREMENT,
    cep VARCHAR(8),
    rua VARCHAR(60),
    nro_casa INTEGER,
    bairro VARCHAR(60),
    complemento VARCHAR(60),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_endereco)
);

CREATE TABLE tb_beneficiarios (
    id_beneficiario INTEGER AUTO_INCREMENT,
    id_usuario INTEGER,
    nm_representante VARCHAR(60),
    status VARCHAR(60),
    como_conheceu VARCHAR(200),
    indicador VARCHAR(60),
    add_info LONGTEXT,
    tem_terreno BOOL,
    renda_mensal DECIMAL(8,2),
    dt_indicacao DATE NOT NULL,
    status_moradia VARCHAR(60),
    decisao_triagem LONGTEXT,
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_beneficiario),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuarios(id_usuario)
);


CREATE TABLE tb_familiares (
    id_familiar         INTEGER AUTO_INCREMENT,
    id_beneficiario     INTEGER,
    nm_familiar         VARCHAR(60),
    cpf                 VARCHAR(11),
    parentesco          VARCHAR(30),
    dt_nascimento       DATE,
    escolaridade        VARCHAR(40),
    valor_renda         DECIMAL(8,2),
    fonte_de_renda      VARCHAR(40),
    problemas_de_saude  VARCHAR(100),
    dt_criacao          DATE,
    dt_alteracao        DATE,
    dt_exclusao         DATE,
    CONSTRAINT pk_tb_familiares_id_famil PRIMARY KEY (id_familiar),
    CONSTRAINT fk_tb_familiares_id_benef FOREIGN KEY (id_beneficiario)
        REFERENCES tb_beneficiarios (id_beneficiario)
);


CREATE TABLE tb_visitas(
	id_visita INTEGER NOT NULL AUTO_INCREMENT,
	id_beneficiario INTEGER,
	dt_visita DATE,
	relatorio_visita VARCHAR(500),
	foto1 LONGBLOB,
	foto2 LONGBLOB,
	foto3 LONGBLOB,
	foto4 LONGBLOB,
	foto5 LONGBLOB,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_visitas_id_visita PRIMARY KEY(id_visita),
	CONSTRAINT fk_tb_visitas_id_benef FOREIGN KEY(id_beneficiario)
		REFERENCES tb_beneficiarios(id_beneficiario)
);

CREATE TABLE tb_tipos_voluntarios (
	id_tipo_voluntario INTEGER NOT NULL AUTO_INCREMENT,
	nm_tipo_voluntario VARCHAR(30),
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_tipos_voluntarios_id_tipo_voluntario PRIMARY KEY(id_tipo_voluntario)
);

CREATE TABLE tb_tipos_doacoes (
	id_tipo_doacao INTEGER NOT NULL AUTO_INCREMENT,
	nm_tipo_doacao VARCHAR(30),
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_tipos_doacoes_id_tipo_doacao PRIMARY KEY(id_tipo_doacao)
);

CREATE TABLE tb_voluntarios (
	id_voluntario INTEGER NOT NULL AUTO_INCREMENT,
	id_usuario INTEGER,
	id_tipo_voluntario INTEGER,
	cargo_desejado VARCHAR(100),
	sobre_voce VARCHAR(240),
	hobby VARCHAR(150),
	intencao VARCHAR(200),
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_voluntarios_id_voluntario PRIMARY KEY(id_voluntario),
	CONSTRAINT fk_tb_voluntarios_id_tipo_voluntario FOREIGN KEY(id_tipo_voluntario) REFERENCES tb_tipos_voluntarios(id_tipo_voluntario),
	CONSTRAINT fk_tb_voluntarios_id_usuario FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
);

CREATE TABLE tb_doacoes (
	id_doacao INTEGER NOT NULL AUTO_INCREMENT,
	id_tipo_doacao INTEGER,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_doacoes_id_doacao PRIMARY KEY(id_doacao),
	CONSTRAINT fk_tb_doacoes_id_tipo_doacao FOREIGN KEY(id_tipo_doacao) REFERENCES tb_tipos_doacoes(id_tipo_doacao)
);

CREATE TABLE tb_doacoes_voluntarios (
	id_doacao INTEGER,
	id_voluntario INTEGER,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_doacoes_voluntarios_id_doacao_id_voluntario PRIMARY KEY(id_doacao, id_voluntario),
	CONSTRAINT fk_tb_doacoes_id_doacao FOREIGN KEY(id_doacao)REFERENCES tb_doacoes(id_doacao),
	CONSTRAINT fk_tb_doacoes_id_voluntario FOREIGN KEY(id_voluntario)REFERENCES tb_voluntarios(id_voluntario)
);

CREATE TABLE tb_visitas_voluntarios (
	id_visita INTEGER,
	id_voluntario INTEGER,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_visitas_voluntarios_id_visita_id_voluntario PRIMARY KEY(id_visita, id_voluntario),
	CONSTRAINT fk_tb_visitas_id_visita FOREIGN KEY(id_visita) REFERENCES tb_visitas(id_visita),
	CONSTRAINT fk_tb_visitas_id_voluntario FOREIGN KEY(id_voluntario) REFERENCES tb_voluntarios(id_voluntario)
);

CREATE TABLE tb_materiais (
    id_material INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_doacao INT,
    nm_material VARCHAR(255),
    quantidade INTEGER,
    ds_material VARCHAR(255),
    preco DECIMAL(10, 2),
    origem VARCHAR(255),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,

    FOREIGN KEY (id_doacao) REFERENCES tb_doacoes(id_doacao)
);

CREATE TABLE tb_obras(
	id_obra INTEGER AUTO_INCREMENT,
	id_endereco INTEGER,
	descricao VARCHAR(100),
	dt_inicio DATE,
	dt_termino DATE,
	situacao_construcao VARCHAR(20),
	custo_estimado DECIMAL(8,2),
	custo_total DECIMAL(8,2),
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	CONSTRAINT pk_tb_obras_id_obra PRIMARY KEY(id_obra),
	FOREIGN KEY (id_endereco) REFERENCES tb_enderecos(id_endereco)
);

CREATE TABLE tb_materiais_em_uso (
	id_material_em_uso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_material INTEGER,
	id_obra INTEGER,
	quantidade INTEGER,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	FOREIGN KEY (id_material) REFERENCES tb_materiais(id_material),
	FOREIGN KEY (id_obra) REFERENCES tb_obras(id_obra)
);

CREATE TABLE tb_produtos_outlet (
	id_prod_outlet INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_doacao INT,
	ds_prod_outlet VARCHAR(100),
	nm_produto_outlet VARCHAR(60),
	status VARCHAR(20),
	preco DECIMAL(10, 2),
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	FOREIGN KEY (id_doacao) REFERENCES tb_doacoes(id_doacao)
);

CREATE TABLE tb_receitas(
	id_receita INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_doacao INTEGER,
	dt_recebimento DATE,
	dt_vencimento DATE,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,
	FOREIGN KEY (id_doacao) REFERENCES tb_doacoes(id_doacao)
);

CREATE TABLE tb_despesas(
	id_despesa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_material INTEGER,
	id_obra INTEGER,
	dt_recebimento DATE,
	dt_vencimento DATE,
	dt_criacao DATE,
	dt_alteracao DATE,
	dt_exclusao DATE,

	FOREIGN KEY (id_obra) REFERENCES tb_obras(id_obra),
	FOREIGN KEY (id_material) REFERENCES tb_materiais(id_material)
);

CREATE TABLE tb_movimentacoes (
    id_movimentacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_receita INTEGER,
    id_despesa INTEGER,
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    FOREIGN KEY (id_receita) REFERENCES tb_receitas(id_receita),
	FOREIGN KEY (id_despesa) REFERENCES tb_despesas(id_despesa)
);

CREATE TABLE tb_notas_fiscais (
    id_nota_fiscal INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_movimentacao INTEGER,
    foto_nota_fiscal LONGBLOB,
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,

    FOREIGN KEY (id_movimentacao) REFERENCES tb_movimentacoes(id_movimentacao)
);

CREATE TABLE tb_etiquetas(
    id_etiqueta INT NOT NULL AUTO_INCREMENT,
    nm_etiqueta VARCHAR(20),
    cor_hex VARCHAR(7),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,

    CONSTRAINT pk_tb_etiquetas_id_etiqueta PRIMARY KEY(id_etiqueta)
);

CREATE TABLE tb_noticias(
    id_noticia INTEGER AUTO_INCREMENT,
    id_etiqueta INTEGER,
    id_voluntario INTEGER,
    img_noticia LONGBLOB,
    dt_publicacao DATE,
    status_visibilidade BOOL,
    autor_noticia VARCHAR(30),
    url_imagem VARCHAR(800),
    descricao_noticia VARCHAR(150),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,

    CONSTRAINT pk_tb_noticias_id_noticia PRIMARY KEY(id_noticia),
    CONSTRAINT fk_tb_eti_tb_not_id_etiqueta FOREIGN KEY(id_etiqueta)
        REFERENCES tb_etiquetas(id_etiqueta),
    CONSTRAINT pk_tb_vol_tb_not_id_voluntario FOREIGN KEY(id_voluntario)
        REFERENCES tb_voluntarios(id_voluntario)
);

CREATE TABLE tb_eventos (
    id_evento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_voluntario INTEGER,
    id_endereco INTEGER,
    id_noticia INTEGER,
    nm_evento VARCHAR(20),
    dt_evento DATE,
    local_evento VARCHAR(100),
    descricao_evento VARCHAR(100),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,

    FOREIGN KEY (id_voluntario) REFERENCES tb_voluntarios(id_voluntario),
    FOREIGN KEY (id_endereco) REFERENCES tb_enderecos(id_endereco),
    FOREIGN KEY (id_noticia) REFERENCES tb_noticias(id_noticia)
);

CREATE TABLE tb_patrocinadores (
    id_patrocinador INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nm_patrocinador VARCHAR(100),
    valor_investido DECIMAL(10, 2),
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE
);

CREATE TABLE tb_patrocinadores_eventos (
    id_patrocinador INTEGER,
    id_evento INTEGER,
    dt_criacao DATE,
    dt_alteracao DATE,
    dt_exclusao DATE,
    PRIMARY KEY (id_patrocinador, id_evento),
    FOREIGN KEY (id_patrocinador) REFERENCES tb_patrocinadores(id_patrocinador),
    FOREIGN KEY (id_evento) REFERENCES tb_eventos(id_evento)
);