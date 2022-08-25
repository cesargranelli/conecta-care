-- Table structure for table eventos

CREATE TABLE eventos (
  id BIGSERIAL NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  detalhe VARCHAR(255) DEFAULT NULL,
  data DATE NOT NULL,
  hora TIME NOT NULL,
  data_cadastro TIMESTAMP NOT NULL,
  usuario_cadastro VARCHAR(255) DEFAULT NULL,
  data_atualizacao TIMESTAMP NOT NULL,
  usuario_atualizacao VARCHAR(255) DEFAULT NULL,
  logradouro VARCHAR(255) DEFAULT NULL,
  numero VARCHAR(255) DEFAULT NULL,
  cep VARCHAR(255) DEFAULT NULL,
  bairro VARCHAR(255) DEFAULT NULL,
  cidade VARCHAR(255) DEFAULT NULL,
  duracao INTEGER DEFAULT NULL,
  vagas INTEGER DEFAULT NULL,
  status VARCHAR(25) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table eventos_estado

CREATE TABLE eventos_estado (
  evento_id BIGSERIAL NOT NULL,
  estado_id INTEGER NOT NULL,
  CONSTRAINT eventos_estado_evento_id_fk FOREIGN KEY (evento_id) REFERENCES eventos (id),
  CONSTRAINT eventos_estado_estado_id_fk FOREIGN KEY (estado_id) REFERENCES estado (id)
);

-- Table structure for table eventos_area_atendimento

CREATE TABLE eventos_area_atendimento (
  evento_id BIGSERIAL NOT NULL,
  area_atendimento_id INTEGER NOT NULL,
  CONSTRAINT even_area_aten_evento_id_fk FOREIGN KEY (evento_id) REFERENCES eventos (id),
  CONSTRAINT even_area_aten_area_aten_id_fk FOREIGN KEY (area_atendimento_id) REFERENCES area_atendimento (id)
);
