-- Table structure for table contatos

ALTER TABLE contatos ADD COLUMN telefone_responsavel VARCHAR(255) DEFAULT NULL;
ALTER TABLE contatos ADD COLUMN email_responsavel VARCHAR(255) DEFAULT NULL;

-- Table structure for table enderecos

ALTER TABLE enderecos ADD COLUMN paciente_id BIGSERIAL NOT NULL;

-- Table structure for table tipo_sanguineo

CREATE TABLE tipo_sanguineo (
  id BIGSERIAL NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  PRIMARY KEY(id)
);

-- Table structure for table historico_medico

CREATE TABLE historico_medico (
  id BIGSERIAL NOT NULL,
  carteira_vacinacao BOOLEAN NOT NULL,
  alergia_medicamento BOOLEAN NOT NULL,
  alergia_medicamento_descricao VARCHAR(15) DEFAULT NULL,
  data_ultimo_tratamento TIMESTAMP DEFAULT NULL,
  data_ultimo_atendimento TIMESTAMP DEFAULT NULL,
  tipo_sanguineo_id INTEGER DEFAULT NULL,
  PRIMARY KEY(id),
  CONSTRAINT hist_medi_tipo_sanguineo_id_fk FOREIGN KEY (tipo_sanguineo_id) REFERENCES tipo_sanguineo (id)
);

-- Table structure for table pacientes

CREATE TABLE pacientes (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(100) DEFAULT NULL,
  sobrenome VARCHAR(100) DEFAULT NULL,
  cpf VARCHAR(14) DEFAULT NULL,
  data_nascimento TIMESTAMP DEFAULT NULL,
  rg VARCHAR(25) DEFAULT NULL,
  rg_emissor VARCHAR(25) DEFAULT NULL,
  rg_data_emissao TIMESTAMP DEFAULT NULL,
  foto TEXT DEFAULT NULL,
  fotoRg TEXT DEFAULT NULL,
  fotoCpf TEXT DEFAULT NULL,
  genero_id INTEGER DEFAULT NULL,
  estado_civil_id INTEGER DEFAULT NULL,
  endereco_id INTEGER DEFAULT NULL,
  contato_id INTEGER DEFAULT NULL,
  historico_medico_id INTEGER DEFAULT NULL,
  PRIMARY KEY(id),
  CONSTRAINT paciente_genero_id_fk FOREIGN KEY (genero_id) REFERENCES genero (id),
  CONSTRAINT paciente_estado_civil_id_fk FOREIGN KEY (estado_civil_id) REFERENCES estado_civil (id),
  CONSTRAINT paciente_endereco_id_fk FOREIGN KEY (endereco_id) REFERENCES enderecos (id),
  CONSTRAINT paciente_contato_id_fk FOREIGN KEY (contato_id) REFERENCES contatos (id),
  CONSTRAINT paciente_hist_medico_id_fk FOREIGN KEY (historico_medico_id) REFERENCES historico_medico (id)
);

-- Table structure for table acompanhantes

CREATE TABLE acompanhantes (
  id BIGSERIAL NOT NULL,
  nome_completo VARCHAR(255) NOT NULL,
  cpf VARCHAR(15) NOT NULL,
  data_nascimento TIMESTAMP NOT NULL,
  genero_id INTEGER DEFAULT NULL,
  parentesco_id INTEGER DEFAULT NULL,
  contato_id INTEGER DEFAULT NULL,
  paciente_id INTEGER DEFAULT NULL,
  PRIMARY KEY(id),
  CONSTRAINT acompanhantes_genero_id_fk FOREIGN KEY (genero_id) REFERENCES genero (id),
  CONSTRAINT acompanhantes_parentesco_id_fk FOREIGN KEY (parentesco_id) REFERENCES parentesco (id),
  CONSTRAINT acompanhantes_contato_id_fk FOREIGN KEY (contato_id) REFERENCES contatos (id),
  CONSTRAINT acompanhantes_paciente_id_fk FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);