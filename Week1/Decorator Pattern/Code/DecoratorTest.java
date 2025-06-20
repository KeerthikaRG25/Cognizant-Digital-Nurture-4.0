interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        notifier.send();
        System.out.println("Sending SMS Notification");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        notifier.send();
        System.out.println("Sending Slack Notification");
    }
}

class DecoratorTest {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier sms = new SMSNotifierDecorator(email);
        Notifier slack = new SlackNotifierDecorator(sms);
        slack.send();
    }
}
