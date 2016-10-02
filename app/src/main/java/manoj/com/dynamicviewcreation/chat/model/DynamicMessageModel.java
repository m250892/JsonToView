package manoj.com.dynamicviewcreation.chat.model;

import org.json.JSONObject;

import manoj.com.dynamicviewcreation.chat.MessageType;

/**
 * Created by manoj on 22/09/16.
 */
public class DynamicMessageModel extends BaseMessageModel {

    private JSONObject jsonObject;

    public DynamicMessageModel(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    @Override
    public MessageType getType() {
        return MessageType.DYNAMIC;
    }
}
