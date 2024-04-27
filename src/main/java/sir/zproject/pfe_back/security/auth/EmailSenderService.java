package sir.zproject.pfe_back.security.auth;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.security.user.User;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import static jakarta.mail.Message.RecipientType.TO;

@Service
public class EmailSenderService {

    private static final String TEST_EMAIL = "pfegestionressources@gmail.com";
    private static final String CONFIRMATION_SUBJECT = "Confirmation de votre adresse e-mail";
    private static final String CREDENTIALS_SUBJECT = "Identifiants de votre compte";
    private final Gmail service;

    public EmailSenderService() throws Exception {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("Test Mailer")
                .build();
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(EmailSenderService.class.getResourceAsStream("/client_secret_762963967563-1dghsuit15651s55j0u2c0rp5ip9t4ph.apps.googleusercontent.com.json")));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void sendMail(User user, String token) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(TEST_EMAIL));
        email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail()));
        email.setSubject(CONFIRMATION_SUBJECT);
        String emailContent = String.format(
                "Cher/Chère %s %s,\n\n" +
                        "Pour compléter votre inscription et vérifier votre adresse e-mail, veuillez saisir le code de confirmation suivant dans le champ prévu à cet effet via le lien de confirmation envoyé.\n\n" +
                        "Code de Confirmation : %s\n\n" +
                        "Nous vous remercions de votre coopération.\n\n" +
                        "Cordialement,\n" +
                        "[Nom de votre entreprise ou organisation]\n" +
                        "[Informations de contact]\n" +
                        "[URL du site web]",
                user.getFirstname(), user.getLastname(), token
        );

        email.setText(emailContent);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }


    public void sendCredentials(User user, String password) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(TEST_EMAIL));
        email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail()));
        email.setSubject(CREDENTIALS_SUBJECT);
        String emailContent = String.format(
                "Bonjour %s %s,\n" +
                        "\n" +
                        "Nous sommes heureux de vous accueillir sur [Nom de l'Application] ! Votre compte a été créé avec succès.\n" +
                        "\n" +
                        "Voici vos identifiants de connexion :\n" +
                        "\n" +
                        "Email : %s\n" +
                        "Mot de passe : %s\n" +
                        "\n" +
                        "Pour des raisons de sécurité, nous vous conseillons de changer votre mot de passe après votre première connexion. Vous pouvez le faire en accédant à la section \"Paramètres de compte\" une fois connecté.\n" +
                        "\n" +
                        "Pour accéder à votre compte, rendez-vous sur : [URL de Connexion]\n" +
                        "\n" +
                        "Si vous rencontrez des problèmes pour vous connecter ou si vous avez des questions, n'hésitez pas à contacter notre support technique à [Adresse Email du Support].\n" +
                        "\n" +
                        "Nous vous remercions de votre confiance et espérons que vous apprécierez l'utilisation de [Nom de l'Application].\n" +
                        "\n" +
                        "Cordialement,\n" +
                        "\n" +
                        "[L'Équipe de [Nom de l'Application]]\n" +
                        "[Coordonnées de Contact, optionnel]\n" +
                        "\n",
                user.getFirstname(), user.getLastname(), user.getEmail(), password
        );
        email.setText(emailContent);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);
        try {
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }

    }
}

