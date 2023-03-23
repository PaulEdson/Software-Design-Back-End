package com.liam.softwaredesign.Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class MailSenderUtilsTest {

    @InjectMocks
    MailSenderUtils mailSenderUtils;

    @Mock
    JavaMailSender mailSender;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void sendEmailTest() {
        doNothing().when(mailSender).send(new SimpleMailMessage());
        mailSenderUtils.sendEmail("test@hotmail.com", "subjectTest", "bodyTest");
    }


}
