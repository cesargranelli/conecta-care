-- `conecta-contato`.telefone_situacao definition

CREATE TABLE `telefone_situacao` (
  `id` bigint NOT NULL,
  `descricao` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

-- `conecta-contato`.telefone_tipo definition

CREATE TABLE `telefone_tipo` (
  `id` bigint NOT NULL,
  `descricao` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

-- `conecta-contato`.telefones definition

CREATE TABLE `telefones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ddi` varchar(3) NOT NULL,
  `ddd` varchar(3) NOT NULL,
  `numero` varchar(15) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `situacao` varchar(25) NOT NULL,
  `data_hora_registro` datetime NOT NULL,
  PRIMARY KEY (`id`)
);

-- `conecta-contato`.usuario_situacao definition

CREATE TABLE `usuario_situacao` (
  `id` bigint NOT NULL,
  `descricao` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

-- `conecta-contato`.usuario_tipo definition

CREATE TABLE `usuario_tipo` (
  `id` bigint NOT NULL,
  `descricao` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

-- `conecta-contato`.usuarios definition

CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `situacao` varchar(25) NOT NULL,
  `data_hora_cadastro` datetime NOT NULL,
  `data_hora_atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

