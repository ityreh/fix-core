package de.ityreh.finance;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import quickfix.*;
import quickfix.fix42.MessageFactory;

import java.util.logging.Logger;

/**
 * Generates FIX messages from a FIX test format file.
 */
public class StringToFixProcessor implements Processor {

    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String FIX42_DICTIONARY_LOCATION = "dictionary/FIX42.xml";

    MessageFactory messageFactory = new MessageFactory();
    DataDictionary dataDictionary = loadDictionary(FIX42_DICTIONARY_LOCATION);

    /**
     * Processor that converts a String message to a FIX message.
     *
     * @param exchange exchange from the camel route
     * @throws Exception
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        org.apache.camel.Message in = exchange.getIn();
        Message fixMessage = convertStringToFix((String) in.getBody());
        in.setBody(fixMessage);
    }

    /**
     * Converts the String message into a FIX message.
     *
     * @param stringMessage
     * @return Message FIX message
     * @throws InvalidMessage
     */
    private Message convertStringToFix(String stringMessage) throws InvalidMessage {
        String sanitizedStringMessage = stringMessage.replace(NEW_LINE, "");
        String normalizedStringMessage = sanitizedStringMessage.replace(";", "\001");
        return MessageUtils.parse(messageFactory, dataDictionary, normalizedStringMessage);
    }

    /**
     * Loads DataDictionary from Resources.
     *
     * @param location location of the dictionary
     * @return DataDictionary
     */
    private DataDictionary loadDictionary(String location) {
        try {
            return new DataDictionary(location);
        } catch (ConfigError error) {
            return null;
        }
    }
}
