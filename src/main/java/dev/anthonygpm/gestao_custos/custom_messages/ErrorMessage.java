package dev.anthonygpm.gestao_custos.custom_messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private String message;
    private String type;
}
