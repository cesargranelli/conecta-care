-- Table structure for table categoria

CREATE TABLE categoria (
  id INTEGER NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table sub_categoria

CREATE TABLE sub_categoria (
  id INTEGER NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table moeda

CREATE TABLE moeda (
  id INTEGER NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table unidade_medida

CREATE TABLE unidade_medida (
  id INTEGER NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table promocoes

CREATE TABLE promocoes (
  id BIGSERIAL NOT NULL,
  preco MONEY NOT NULL,
  data_inicio TIMESTAMP NOT NULL,
  data_fim TIMESTAMP NOT NULL,
  moeda_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT promocoes_moeda_id_fk FOREIGN KEY (moeda_id) REFERENCES moeda (id)
);

-- Table structure for table vendas

CREATE TABLE vendas (
  id BIGSERIAL NOT NULL,
  preco MONEY NOT NULL,
  moeda_id INTEGER NOT NULL,
  promocao_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT vendas_moeda_id_fk FOREIGN KEY (moeda_id) REFERENCES moeda (id),
  CONSTRAINT vendas_promocao_id_fk FOREIGN KEY (promocao_id) REFERENCES promocoes (id)
);

-- Table structure for table locacoes

CREATE TABLE locacoes (
  id BIGSERIAL NOT NULL,
  preco MONEY NOT NULL,
  moeda_id INTEGER NOT NULL,
  promocao_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT locacoes_moeda_id_fk FOREIGN KEY (moeda_id) REFERENCES moeda (id),
  CONSTRAINT locacoes_promocao_id_fk FOREIGN KEY (promocao_id) REFERENCES promocoes (id)
);

-- Table structure for table materiais

CREATE TABLE materiais (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  codigoBarras VARCHAR(255) NOT NULL,
  foto TEXT NOT NULL,
  categoria_id INTEGER NOT NULL,
  sub_categoria_id INTEGER NOT NULL,
  locacao_id INTEGER NOT NULL,
  venda_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT materiais_categoria_id_fk FOREIGN KEY (categoria_id) REFERENCES categoria (id),
  CONSTRAINT materiais_sub_categoria_id_fk FOREIGN KEY (sub_categoria_id) REFERENCES sub_categoria (id),
  CONSTRAINT materiais_locacao_id_fk FOREIGN KEY (locacao_id) REFERENCES locacoes (id),
  CONSTRAINT materiais_venda_id_fk FOREIGN KEY (venda_id) REFERENCES vendas (id)
);

-- Table structure for table estoque

CREATE TABLE estoque (
  id BIGSERIAL NOT NULL,
  quantidade INTEGER NOT NULL,
  data_ultima_compra TIMESTAMP NOT NULL,
  unidade_medida_id INTEGER NOT NULL,
  material_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT estoque_unidade_medida_id_fk FOREIGN KEY (unidade_medida_id) REFERENCES unidade_medida (id),
  CONSTRAINT estoque_material_id_fk FOREIGN KEY (material_id) REFERENCES materiais (id)
);
