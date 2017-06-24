package com.antivirus.service;

/**
 * Created by USER on 09.06.2017.
 */
public interface MailSenderService {
    void sendMail(String theme, String  mailBody, String email);
}
