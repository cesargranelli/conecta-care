-- Table structure for table sequences_cadastro

CREATE TABLE sequences_cadastro (
  id BIGSERIAL NOT NULL,
  status VARCHAR(25) NOT NULL,
  documento VARCHAR(15) NOT NULL,
  tipo VARCHAR(25) NOT NULL,
  modulo VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table usuarios

CREATE TABLE usuarios (
  id BIGSERIAL NOT NULL,
  email VARCHAR(180) NOT NULL,
  roles TEXT NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(email)
);

-- Table structure for table sequences_cadastro_usuarios

CREATE TABLE sequences_cadastro_usuarios (
  id_sequence_cadastro BIGSERIAL NOT NULL,
  id_usuario BIGSERIAL NOT NULL,
  PRIMARY KEY (id_sequence_cadastro,id_usuario),
  CONSTRAINT id_sequences_cadastro_fk FOREIGN KEY (id_sequence_cadastro) REFERENCES sequences_cadastro (id),
  CONSTRAINT id_usuarios_fk FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
);