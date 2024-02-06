package com.example.trainingcore.service.impl;

import com.example.trainingcore.service.MailService;
import com.example.trainingcore.service.data.MailData;
import com.example.trainingcore.service.properties.MailResourcesProperties;
import freemarker.template.Configuration;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final Configuration configuration;
    private final JavaMailSender mailSender;
    private final MailResourcesProperties properties;

    @Override
    public void send(
            final MailData message
    ) {
        switch (message.getType()) {
            case ACTIVATION -> sendActivationMail(
                    message.getReceiver(),
                    message.getParams()
            );
            case RESTORE -> sendPasswordResetMail(
                    message.getReceiver(),
                    message.getParams()
            );
            default -> {
            }
        }
    }

    @SneakyThrows
    private void sendActivationMail(
            final String receiver,
            final Properties params
    ) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                false,
                "UTF-8"
        );
        helper.setSubject("Welcome to " + properties.getMainDomainName());
        helper.setTo(receiver);
        String emailContent = getActivationEmailContent(params);
        helper.setText(emailContent, true);
        mailSender.send(mimeMessage);
    }

    @SneakyThrows
    private String getActivationEmailContent(
            final Properties params
    ) {
        StringWriter stringWriter = new StringWriter();
        Properties model = new Properties();
        model.put("link", properties.getActivationLink()
                + params.get("token"));
        model.put("mainLink", properties.getMainLink());
        model.put("mainDomainName", properties.getMainDomainName());
        configuration.getTemplate("activation.ftlh")
                .process(model, stringWriter);
        return stringWriter.getBuffer()
                .toString();
    }

    @SneakyThrows
    private void sendPasswordResetMail(
            final String receiver,
            final Properties params
    ) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                false,
                "UTF-8"
        );
        helper.setSubject(
                "Reset your password on "
                        + properties.getMainDomainName()
        );
        helper.setTo(receiver);
        String emailContent = getPasswordResetEmailContent(params);
        helper.setText(emailContent, true);
        mailSender.send(mimeMessage);
    }

    @SneakyThrows
    private String getPasswordResetEmailContent(
            final Properties params
    ) {
        StringWriter stringWriter = new StringWriter();
        Properties model = new Properties();
        model.put("link", properties.getRestoreLink()
                + params.get("token"));
        model.put("mainLink", properties.getMainLink());
        model.put("mainDomainName", properties.getMainDomainName());
        configuration.getTemplate("restore.ftlh")
                .process(model, stringWriter);
        return stringWriter.getBuffer()
                .toString();
    }

}
