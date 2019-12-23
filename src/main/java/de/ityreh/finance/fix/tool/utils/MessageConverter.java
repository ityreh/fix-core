package de.ityreh.finance.fix.tool.utils;

import quickfix.InvalidMessage;
import quickfix.Message;
import quickfix.MessageUtils;
import quickfix.Session;

public class MessageConverter {

    public static final String NEW_LINE = System.getProperty("line.separator");

    public static Message stringToFix(Session session, String stringMessage) throws InvalidMessage {
        String sanitizedStringMessage = stringMessage.replace(NEW_LINE, "");
        String normalizedStringMessage = sanitizedStringMessage.replace(";", "\001");
        System.out.println(normalizedStringMessage);
        System.out.println(session);
        return MessageUtils.parse(session, normalizedStringMessage);
    }
}
