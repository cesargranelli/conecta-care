-- Table structure for table especialidade

CREATE TABLE especialidade (
  id INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table contatos

CREATE TABLE contatos (
  id BIGSERIAL NOT NULL,
  telefone_fixo VARCHAR(13) DEFAULT NULL,
  telefone_recado VARCHAR(13) DEFAULT NULL,
  telefone_celular VARCHAR(13) DEFAULT NULL,
  telefone_whatsapp VARCHAR(13) DEFAULT NULL,
  email VARCHAR(100) DEFAULT NULL,
  flag_aceite_declaracao VARCHAR(3) DEFAULT NULL,
  flag_aceite_privacidade VARCHAR(3) DEFAULT NULL,
  homecare_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table enderecos

CREATE TABLE enderecos (
  id BIGSERIAL NOT NULL,
  logradouro VARCHAR(60) NOT NULL,
  numero VARCHAR(10) NOT NULL,
  complemento VARCHAR(60) DEFAULT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  comprovante VARCHAR(255),
  homecare_id BIGSERIAL NOT NULL,
  estado_id INTEGER NOT NULL,
  pais_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT enderecos_estado_id_fk FOREIGN KEY (estado_id) REFERENCES estado (id),
  CONSTRAINT enderecos_pais_id_fk FOREIGN KEY (pais_id) REFERENCES pais (id)
);

-- Table structure for table homecares

CREATE TABLE homecares (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  site VARCHAR(100) DEFAULT NULL,
  tipo_empresa_id INTEGER NOT NULL,
  contato_id INTEGER NOT NULL,
  endereco_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT homecares_tipo_empresa_id_fk FOREIGN KEY (tipo_empresa_id) REFERENCES tipo_empresa (id),
  CONSTRAINT homecares_contato_id_fk FOREIGN KEY (contato_id) REFERENCES contatos (id),
  CONSTRAINT homecares_endereco_id_fk FOREIGN KEY (contato_id) REFERENCES enderecos (id)
);

-- Table structure for table homecares_especialidade

CREATE TABLE homecares_especialidade (
  homecare_id BIGSERIAL NOT NULL,
  especialidade_id BIGSERIAL NOT NULL,
  CONSTRAINT home_espec_homecare_id_fk FOREIGN KEY (homecare_id) REFERENCES homecares (id),
  CONSTRAINT home_espec_especialidade_id_fk FOREIGN KEY (especialidade_id) REFERENCES especialidade (id)
);

-- Table structure for table plantonistas

CREATE TABLE plantonistas (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  contato VARCHAR(13) NOT NULL,
  site VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
);