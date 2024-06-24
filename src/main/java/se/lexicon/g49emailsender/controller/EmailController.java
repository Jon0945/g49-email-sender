package se.lexicon.g49emailsender.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.g49emailsender.domain.dto.EmailDTO;
import se.lexicon.g49emailsender.service.EmailServiceImpl;

@RequestMapping("/api/v1/email")
@RestController
public class EmailController {
    private final EmailServiceImpl emailServiceImpl;
    @Autowired
    public EmailController(EmailServiceImpl emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Void> doSendEmail(@RequestBody @Valid EmailDTO dto) {
        emailServiceImpl.sendEmail(dto);
        return ResponseEntity.noContent().build();
    }
}
