package com.sevenine.conecta.controller.data.request;

import com.sevenine.conecta.annotation.ValueOfEnum;
import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.enumerator.TipoDocumento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class DocumentoRequest {

    @NotEmpty(message = "O campo numero é obrigatório")
    @Size(max = 15, message = "O campo numero aceita até 15 posições")
    @Pattern(regexp = "[\\d]{0,}", message = "O campo numero aceita apenas valores numéricos")
    private String numero;

    @ValueOfEnum(enumClass = TipoDocumento.class, message = "O campo tipo aceita os valores [CPF, CNPJ]")
    private String tipo;

    @ValueOfEnum(enumClass = Modulo.class, message = "O campo módulo aceita os valores [ROOT, PACIENTE, PROFISSIONAL, HOMECARE, PLANO_SAUDE]")
    private String modulo;

}
