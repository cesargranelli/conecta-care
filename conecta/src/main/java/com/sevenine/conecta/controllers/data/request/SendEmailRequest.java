package com.sevenine.conecta.adapter.controller.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SendEmailRequest {

    @NotEmpty(message = "O campo from é obrigatório")
    @Email(message = "O valor no campo from não é um email válido")
    private String from;

    @NotEmpty(message = "O campo to é obrigatório")
    @Email(message = "O valor no campo to não é um email válido")
    private String to;

    @NotEmpty(message = "O subject to é obrigatório")
    private String subject;

    private String body;

}
