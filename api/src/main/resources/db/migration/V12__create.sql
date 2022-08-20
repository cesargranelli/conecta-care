-- Table structure for table profissionais_eventos

CREATE TABLE profissionais_eventos (
  id BIGSERIAL NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  evento_id BIGSERIAL NOT NULL,
  status_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT prof_even_status_id_fk FOREIGN KEY (status_id) REFERENCES status_evento (id),
  CONSTRAINT prof_even_evento_id_fk FOREIGN KEY (evento_id) REFERENCES eventos (id),
  CONSTRAINT prof_even_profissional_id_fk FOREIGN KEY (profissional_id) REFERENCES profissionais (id)
);

-- Table structure for table registros

CREATE TABLE registros (
  id BIGSERIAL NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  chave VARCHAR(100) NOT NULL,
  data_lancamento TIMESTAMP NOT NULL,
  data_encerramento TIMESTAMP DEFAULT NULL,
  status VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(tipo,chave,data_lancamento)
);