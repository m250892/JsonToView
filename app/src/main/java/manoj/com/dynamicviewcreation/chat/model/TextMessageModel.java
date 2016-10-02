package manoj.com.dynamicviewcreation.chat.model;

import manoj.com.dynamicviewcreation.chat.MessageType;
import manoj.com.dynamicviewcreation.chat.model.BaseMessageModel;

/**
 * Created by manoj on 22/09/16.
 */
public class TextMessageModel extends BaseMessageModel {

    private String text;

    public TextMessageModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }
}
