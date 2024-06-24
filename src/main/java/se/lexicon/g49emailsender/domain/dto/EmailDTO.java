package se.lexicon.g49emailsender.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmailDTO {
    @NotBlank(message = "To field cannot be blank.")
    private String to;
    @NotBlank(message = "Subject field can not be blank.")
    private String subject;
    @NotBlank(message = "HTML cannot be blank.")
    private String html;

    private Integer type;
}
