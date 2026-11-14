import java.util.*;

interface Notifier {
    void send(String message);
}

class NotificationEmail implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim email: " + message);
    }
}

class NotificationSMS implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class NotificationWhatsApp implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}

class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendNotification(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new NotificationEmail();
        Notifier smsNotifier = new NotificationSMS();
        Notifier whatsappNotifier = new NotificationWhatsApp();

        NotificationService emailService = new NotificationService(emailNotifier);
        NotificationService smsService = new NotificationService(smsNotifier);
        NotificationService whatsappService = new NotificationService(whatsappNotifier);

        emailService.sendNotification("Halo, ini email test!");
        smsService.sendNotification("Ini SMS test!");
        whatsappService.sendNotification("Ini pesanWhatsApp test!");
    }
}
