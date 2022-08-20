package com.sevenine.conecta.infra.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMappingEnum {

    ERRO_AO_COMUNICAR_COM_SERVICO("Erro ao comunicar com serviço"),
    ID_PACIENTE_OBRIGATORIO("Identificador do paciente é obrigatório"),
    ID_CONTATO_PACIENTE_OBRIGATORIO("Identificador do contato do paciente é obrigatório"),
    ID_ENDERECO_PACIENTE_OBRIGATORIO("Identificador do endereço do paciente é obrigatório"),
    ID_HISTORICO_MEDICO_PACIENTE_OBRIGATORIO("Identificador do histórico médico do paciente é obrigatório"),
    ID_PACIENTE_NAO_ENCONTRADO("Paciente não encontrado"),
    PACIENTE_JA_POSSUI_ENDERECO("Paciente informado ja possui endereco cadastrado"),
    PACIENTE_JA_POSSUI_CONTATO("Paciente informado ja possui contato cadastrado"),
    ID_CONTATO_PACIENTE_NAO_ENCONTRADO("Identificador do contato do paciente não encontrado"),
    ID_ENDERECO_PACIENTE_NAO_ENCONTRADO("Identificador do endereço do paciente não encontrado"),
    ID_HISTORICO_MEDICO_PACIENTE_NAO_ENCONTRADO("Identificador do histórico médico do paciente não encontrado");

    private final String mensagem;

}
