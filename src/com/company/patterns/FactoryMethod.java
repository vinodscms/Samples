package com.company.patterns;

public class FactoryMethod {
    public static void main(String[] args) {
        String messageType = "SMS";
        MessageBuilder builder = MessageBuilderFactory.getBuilder(messageType);
        builder.build();
    }
}

abstract class MessageBuilder {
    public abstract void build () ;
}


class SMSMessageBuilder extends MessageBuilder {
    public void build () {
        System.out.println("This is SMS message Type");
        // do processing SMS message type
    }
}

class EMAILMessageBuilder extends MessageBuilder {
    public void build() {
        System.out.println("This is Email Message Type");
        //do proceessing EMAIL things.
    }
}

class NotificationMessageBuilder extends MessageBuilder {
    public void build () {
        System.out.println("This is Notification Message Type");
        // do processing Notification things.
    }
}

class MessageBuilderFactory {

    public static MessageBuilder getBuilder(String messageType) {
        if (messageType.equals("SMS")) {
            return new SMSMessageBuilder();
        } else if (messageType.equals("EMAIL")) {
            return new EMAILMessageBuilder();
        } else if (messageType.equals("NOTIFICATION")) {
            return new NotificationMessageBuilder();
        } else {
            return new SMSMessageBuilder();

        }
    }
}




