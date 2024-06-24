package se.lexicon.g49emailsender.service;

import org.springframework.stereotype.Service;
import se.lexicon.g49emailsender.domain.dto.EmailDTO;
import se.lexicon.g49emailsender.domain.entity.Email;
import se.lexicon.g49emailsender.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService{
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void sendEmail(EmailDTO dto) {
        //todo: Implement the main logic for sending an email
        if(dto == null) throw new IllegalArgumentException("Email is null");
        //Convert dto to entity
        Email emailEntity = Email.builder()
                .to(dto.getTo())
                .from("test@test.se")
                .subject(dto.getSubject())
                .content(dto.getHtml())
                .type(dto.getType())
                .build();
        emailRepository.save(emailEntity);

        //todo: Send the email

    }
}
