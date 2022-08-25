-- Table structure for table genero

CREATE TABLE genero (
  id INTEGER NOT NULL,
  tipo VARCHAR(1) NOT NULL,
  descricao VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table tipo_empresa

CREATE TABLE tipo_empresa (
  id INTEGER NOT NULL,
  sigla VARCHAR(10) NOT NULL,
  tipo VARCHAR(40) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table area_atendimento

CREATE TABLE area_atendimento (
  id INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table tipo_conta

CREATE TABLE tipo_conta (
  id INTEGER NOT NULL,
  codigo VARCHAR(3) NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table transporte

CREATE TABLE transporte (
  id INTEGER NOT NULL,
  tipo VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table banco

CREATE TABLE banco (
  id INTEGER NOT NULL,
  codigo VARCHAR(5) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table categoria_cnh

CREATE TABLE categoria_cnh (
  id INTEGER NOT NULL,
  sigla VARCHAR(1) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table conselho

CREATE TABLE conselho (
  id INTEGER NOT NULL,
  sigla VARCHAR(30) NOT NULL,
  descricao VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table estado

CREATE TABLE estado (
  id INTEGER NOT NULL,
  codigo INTEGER NOT NULL,
  uf VARCHAR(2) NOT NULL,
  nome VARCHAR(20) NOT NULL,
  regiao VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table estado_civil

CREATE TABLE estado_civil (
  id INTEGER NOT NULL,
  tipo VARCHAR(10) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table instrucao

CREATE TABLE instrucao (
  id INTEGER NOT NULL,
  grau VARCHAR(60) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table pais

CREATE TABLE pais (
  id INTEGER NOT NULL,
  codigo VARCHAR(5) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table parentesco

CREATE TABLE parentesco (
  id INTEGER NOT NULL,
  descricao VARCHAR(100),
  PRIMARY KEY (id)
);

-- Table structure for table campo

CREATE TABLE campo (
  id INTEGER NOT NULL,
  tipo VARCHAR(25) NOT NULL,
  tamanho VARCHAR(25) NOT NULL,
  pre VARCHAR(255),
  pos VARCHAR(255),
  PRIMARY KEY (id)
);

-- Table structure for table grupo

CREATE TABLE grupo (
  id INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table subgrupo

CREATE TABLE subgrupo (
  id INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table grupo_subgrupos

CREATE TABLE grupo_subgrupos (
  grupo_id INTEGER NOT NULL,
  subgrupos_id INTEGER NOT NULL
);

-- Table structure for table subgrupo_campos

CREATE TABLE subgrupo_campos (
  subgrupo_id INTEGER NOT NULL,
  campos_id INTEGER NOT NULL
);

-- Table structure for table modelo

CREATE TABLE modelo (
  id INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table modelo_grupos

CREATE TABLE modelo_grupos (
  modelo_id INTEGER NOT NULL,
  grupos_id INTEGER NOT NULL
);

-- Table structure for table repeticao

CREATE TABLE repeticao (
  id INTEGER NOT NULL,
  descricao VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table semana

CREATE TABLE semana (
  id INTEGER NOT NULL,
  sigla VARCHAR(15) NOT NULL,
  descricao VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_atendimento

CREATE TABLE status_atendimento (
  id INTEGER NOT NULL,
  descricao VARCHAR(25) NOT NULL,
  status VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_cadastro

CREATE TABLE status_cadastro (
  id INTEGER NOT NULL,
  status VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_evento

CREATE TABLE status_evento (
  id INTEGER NOT NULL,
  status VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_evento_profissional

CREATE TABLE status_evento_profissional (
  id INTEGER NOT NULL,
  status VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_tratamento

CREATE TABLE status_tratamento (
  id INTEGER NOT NULL,
  descricao VARCHAR(25) NOT NULL,
  status VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table status_usuario

CREATE TABLE status_usuario (
  id INTEGER NOT NULL,
  status VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);