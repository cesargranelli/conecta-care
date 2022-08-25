-- Table structure for table enderecos

ALTER TABLE enderecos ADD COLUMN atendimento_id BIGSERIAL NOT NULL;

-- Table structure for table recorrencias

CREATE TABLE recorrencias (
  id BIGSERIAL NOT NULL,
  inicio date NOT NULL,
  fim date DEFAULT NULL,
  quantidade INTEGER NOT NULL,
  repeticao VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table recorrencias_semanas

CREATE TABLE recorrencias_semanas (
  recorrencia_id BIGSERIAL NOT NULL,
  semana_id BIGSERIAL NOT NULL,
  UNIQUE(recorrencia_id,semana_id),
  UNIQUE(semana_id),
  CONSTRAINT reco_sema_recorrencia_id_fk FOREIGN KEY (recorrencia_id) REFERENCES recorrencias (id),
  CONSTRAINT reco_sema_semana_id_fk FOREIGN KEY (semana_id) REFERENCES semana (id)
);

-- Table structure for table atendimentos_campos_baixa

CREATE TABLE atendimentos_campos_baixa (
  id BIGSERIAL NOT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  campo_id BIGSERIAL NOT NULL,
  texto TEXT,
  PRIMARY KEY (id)
);

-- Table structure for table tratamentos

CREATE TABLE tratamentos (
  id BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor_kilometragem MONEY NOT NULL,
  paciente_id BIGSERIAL NOT NULL,
  acompanhante_id BIGSERIAL NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  home_care_id BIGSERIAL NOT NULL,
  observacao VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Table structure for table atendimentos

CREATE TABLE atendimentos (
  id BIGSERIAL NOT NULL,
  data date NOT NULL,
  hora time NOT NULL,
  observacao VARCHAR(255) DEFAULT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  tratamento_id BIGSERIAL NOT NULL,
  plantonista_id BIGSERIAL NOT NULL,
  recorrencia_id BIGSERIAL NOT NULL,
  profissional_id BIGSERIAL NOT NULL,
  procedimento_id BIGSERIAL NOT NULL,
  valor_home_care MONEY DEFAULT NULL,
  valor_profissional MONEY DEFAULT NULL,
  valor_paciente MONEY DEFAULT NULL,
  valor_ajuda_custo MONEY DEFAULT NULL,
  home_care_id BIGSERIAL NOT NULL,
  paciente_id BIGSERIAL NOT NULL,
  codigo_seguranca VARCHAR(255) DEFAULT NULL,
  observacoes_baixa VARCHAR(255) DEFAULT NULL,
  assinatura TEXT,
  tipo_atendimento_id INTEGER DEFAULT '1',
  PRIMARY KEY (id),
  CONSTRAINT aten_atendimento_id_fk FOREIGN KEY (atendimento_id) REFERENCES enderecos (id),
  CONSTRAINT aten_recorrencia_id_fk FOREIGN KEY (recorrencia_id) REFERENCES recorrencias (id),
  CONSTRAINT aten_tipo_atendimento_id_fk FOREIGN KEY (tipo_atendimento_id) REFERENCES area_atendimento (id),
  CONSTRAINT aten_tratamento_id_fk FOREIGN KEY (tratamento_id) REFERENCES tratamentos (id)
);

-- Table structure for table atendimentos_grupos

CREATE TABLE atendimentos_grupos (
  atendimento_id BIGSERIAL NOT NULL,
  grupos_id BIGSERIAL NOT NULL,
  CONSTRAINT aten_grupos_atendimentos_id_fk FOREIGN KEY (atendimento_id) REFERENCES atendimentos (id),
  CONSTRAINT aten_grupos_grupo_id_fk FOREIGN KEY (grupos_id) REFERENCES grupo (id)
);

-- Table structure for table atendimentos_situacao

CREATE TABLE atendimentos_situacao (
  id BIGSERIAL NOT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  status_id BIGSERIAL NOT NULL,
  data_hora TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(id,atendimento_id),
  CONSTRAINT aten_situ_atendimento_id_fk FOREIGN KEY (atendimento_id) REFERENCES atendimentos (id),
  CONSTRAINT aten_situ_status_id_fk FOREIGN KEY (status_id) REFERENCES status_atendimento (id)
);

-- Table structure for table procedimentos

CREATE TABLE procedimentos (
  id BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT procedimentos_atendimento_id_fk FOREIGN KEY (atendimento_id) REFERENCES atendimentos (id)
);

-- Table structure for table equipamentos

CREATE TABLE equipamentos (
  id BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  procedimento_id BIGSERIAL NOT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT equipamentos_procedimento_id_fk FOREIGN KEY (procedimento_id) REFERENCES procedimentos (id),
  CONSTRAINT equipamentos_atendimento_id_fk FOREIGN KEY (atendimento_id) REFERENCES atendimentos (id)
);

-- Table structure for table medicamentos

CREATE TABLE medicamentos (
  id BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  medicamento_id BIGSERIAL NOT NULL,
  atendimento_id BIGSERIAL NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT medicamentos_atendimento_id_fk FOREIGN KEY (atendimento_id) REFERENCES atendimentos (id),
  CONSTRAINT medicamentos_procedimento_id_fk FOREIGN KEY (medicamento_id) REFERENCES procedimentos (id)
);

-- Table structure for table tratamentos_situacao

CREATE TABLE tratamentos_situacao (
  id BIGSERIAL NOT NULL,
  tratamento_id BIGSERIAL NOT NULL,
  status_id BIGSERIAL NOT NULL,
  data_hora TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  UNIQUE(id,tratamento_id),
  CONSTRAINT trat_situ_status_id_fk FOREIGN KEY (status_id) REFERENCES status_tratamento (id),
  CONSTRAINT trat_situ_tratamento_id_fk FOREIGN KEY (tratamento_id) REFERENCES tratamentos (id)
);