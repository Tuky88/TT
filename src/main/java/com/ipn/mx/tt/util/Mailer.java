/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.tt.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author Axel Reyes
 */
public class Mailer {

    private Properties prop;

    public void configProp() {
        prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "567");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    }

    Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("axelreyezamezcua@gmail.com", "CharizardS88");
        }
    });
}
