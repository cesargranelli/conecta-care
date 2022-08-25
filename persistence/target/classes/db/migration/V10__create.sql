-- Table structure for table contatos

ALTER TABLE contatos ADD COLUMN profissional_id BIGSERIAL NOT NULL;

-- Table structure for table enderecos

ALTER TABLE enderecos ADD COLUMN profissional_id BIGSERIAL NOT NULL;

-- Table structure for table escolaridade

CREATE TABLE escolaridade (
  id BIGSERIAL NOT NULL,
  instrucao_id INTEGER NOT NULL,
  instituicao_ensino TEXT,
  ano_conclusao TEXT,
  profissional_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(profissional_id),
  CONSTRAINT escolaridade_instrucao_id_fk FOREIGN KEY (instrucao_id) REFERENCES instrucao (id)
);

-- Table structure for table contas

CREATE TABLE contas (
  id BIGSERIAL NOT NULL,
  tipo_id INTEGER NOT NULL,
  banco_id INTEGER NOT NULL,
  agencia VARCHAR(5) NOT NULL,
  numero VARCHAR(12) NOT NULL,
  digito varchar(2) NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(profissional_id),
  CONSTRAINT contas_tipo_id_fk FOREIGN KEY (tipo_id) REFERENCES tipo_conta (id),
  CONSTRAINT contas_banco_id_fk FOREIGN KEY (banco_id) REFERENCES banco (id)
);

-- Table structure for table experiencias

CREATE TABLE experiencias (
  id BIGSERIAL NOT NULL,
  empresa VARCHAR(100) DEFAULT NULL,
  cargo VARCHAR(50) DEFAULT NULL,
  observacao VARCHAR(255) DEFAULT NULL,
  posicao INTEGER NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  data_admissao date DEFAULT NULL,
  data_demissao date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE(posicao,profissional_id)
);

-- Table structure for table profissionais_experiencias

CREATE TABLE profissionais_experiencias (
  profissional_id BIGSERIAL NOT NULL,
  experiencia_id BIGSERIAL NOT NULL,
  PRIMARY KEY (profissional_id,experiencia_id)
);

-- Table structure for table carreiras

CREATE TABLE carreiras (
  id BIGSERIAL NOT NULL,
  conselho_id INTEGER NOT NULL,
  uf_conselho_id INTEGER NOT NULL,
  transporte_id INTEGER NOT NULL,
  registro_profissional INTEGER DEFAULT NULL,
  nome_referencia1 VARCHAR(100) DEFAULT NULL,
  nome_referencia2 VARCHAR(100) DEFAULT NULL,
  telefone_referencia1 VARCHAR(11) DEFAULT NULL,
  telefone_referencia2 VARCHAR(11) DEFAULT NULL,
  profissional_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(profissional_id),
  CONSTRAINT carreiras_transporte_id_fk FOREIGN KEY (transporte_id) REFERENCES transporte (id),
  CONSTRAINT carreiras_conselho_id_fk FOREIGN KEY (conselho_id) REFERENCES conselho (id),
  CONSTRAINT carreiras_uf_conselho_id_fk FOREIGN KEY (uf_conselho_id) REFERENCES estado (id)
);

-- Table structure for table carreiras_area_atendimento

CREATE TABLE carreiras_area_atendimento (
  carreira_id BIGSERIAL NOT NULL,
  area_atendimento_id INTEGER NOT NULL,
  PRIMARY KEY (carreira_id,area_atendimento_id),
  CONSTRAINT carr_area_aten_carreira_id_fk FOREIGN KEY (carreira_id) REFERENCES carreiras (id),
  CONSTRAINT carr_area_aten_area_aten_id_fk FOREIGN KEY (area_atendimento_id) REFERENCES area_atendimento (id)
);

-- Table structure for table profissionais

CREATE TABLE profissionais (
  id BIGSERIAL NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(40) NOT NULL,
  sobrenome VARCHAR(60) NOT NULL,
  data_nascimento date NOT NULL,
  rg VARCHAR(20) DEFAULT NULL,
  rg_emissor VARCHAR(25) DEFAULT NULL,
  rg_data_emissao date DEFAULT NULL,
  cnpj VARCHAR(14) DEFAULT NULL,
  ctps VARCHAR(11) NOT NULL,
  ctps_serie INTEGER NOT NULL,
  pis INTEGER DEFAULT NULL,
  foto_profissional TEXT,
  foto_rg_frente TEXT,
  foto_rg_verso TEXT,
  foto_assinatura TEXT,
  foto_ctps TEXT,
  disponivel_para_atendimento BOOLEAN,
  genero_id INTEGER NOT NULL,
  tipo_empresa_id INTEGER DEFAULT NULL,
  estado_civil_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(cpf),
  CONSTRAINT profissionais_estado_civil_id_fk FOREIGN KEY (estado_civil_id) REFERENCES estado_civil (id),
  CONSTRAINT profissionais_genero_id_fk FOREIGN KEY (genero_id) REFERENCES genero (id),
  CONSTRAINT profissionais_tipo_empresa_id_fk FOREIGN KEY (tipo_empresa_id) REFERENCES tipo_empresa (id)
);

-- Table structure for table profissionais_complemento

CREATE TABLE profissionais_complemento (
  id BIGSERIAL NOT NULL,
  titulo_eleitoral INTEGER DEFAULT NULL,
  zona_eleitoral VARCHAR(3) DEFAULT NULL,
  secao_eleitoral VARCHAR(4) DEFAULT NULL,
  numero_habilitacao INTEGER DEFAULT NULL,
  data_validade_habilitacao date DEFAULT NULL,
  numero_reservista INTEGER DEFAULT NULL,
  nome_mae VARCHAR(100) DEFAULT NULL,
  profissao_mae VARCHAR(60) DEFAULT NULL,
  nome_pai VARCHAR(100) DEFAULT NULL,
  profissao_pai VARCHAR(60) DEFAULT NULL,
  nome_conjuge VARCHAR(100) DEFAULT NULL,
  profissao_conjuge VARCHAR(60) DEFAULT NULL,
  foto_cnh_frente TEXT NOT NULL,
  foto_cnh_verso TEXT NOT NULL,
  carteira_vacinacao BOOLEAN NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  categoria_cnh_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE(profissional_id),
  CONSTRAINT prof_comp_categoria_cnh_id_fk FOREIGN KEY (categoria_cnh_id) REFERENCES categoria_cnh (id)
);