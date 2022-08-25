-- Table structure for table contatos

ALTER TABLE contatos ADD COLUMN plano_saude_id BIGSERIAL NOT NULL;

-- Table structure for table enderecos

ALTER TABLE enderecos ADD COLUMN plano_saude_id BIGSERIAL NOT NULL;

-- Table structure for table planos_saude

CREATE TABLE planos_saude (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  site VARCHAR(100) DEFAULT NULL,
  tipo_empresa_id INTEGER NOT NULL,
  contato_id INTEGER NOT NULL,
  endereco_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT plano_saude_tipo_empresa_id_fk FOREIGN KEY (tipo_empresa_id) REFERENCES tipo_empresa (id),
  CONSTRAINT plano_saude_contato_id_fk FOREIGN KEY (contato_id) REFERENCES contatos (id),
  CONSTRAINT plano_saude_endereco_id_fk FOREIGN KEY (contato_id) REFERENCES enderecos (id)
);

-- Table structure for table planos_saude_especialidade

CREATE TABLE planos_saude_especialidade (
  plano_saude_id BIGSERIAL NOT NULL,
  especialidade_id BIGSERIAL NOT NULL,
  CONSTRAINT plan_espec_homecare_id_fk FOREIGN KEY (plano_saude_id) REFERENCES planos_saude (id),
  CONSTRAINT plan_espec_especialidade_id_fk FOREIGN KEY (especialidade_id) REFERENCES especialidade (id)
);
