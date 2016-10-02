package manoj.com.dynamicviewcreation.chat;

import java.util.ArrayList;
import java.util.List;

import manoj.com.dynamicviewcreation.chat.model.BaseMessageModel;

/**
 * Created by manoj on 22/09/16.
 */
public class ChatDataStore {

    private List<BaseMessageModel> messageList;
    private static ChatDataStore instance;

    private List<ChatStoreDataChangeListner> listners;

    static {
        instance = new ChatDataStore();
    }

    private ChatDataStore() {
        messageList = new ArrayList<>();
        listners = new ArrayList<>();
    }

    public static ChatDataStore getInstance() {

        return instance;
    }


    public List<BaseMessageModel> getMessageList() {
        return messageList;
    }

    public void addMessage(BaseMessageModel messageModel) {
        messageList.add(messageModel);
        notifyListener();
    }

    public void notifyListener() {
        for (ChatStoreDataChangeListner listner : listners) {
            if (listner != null) {
                listner.onChatDataChange();
            }
        }
    }

    public void addListener(ChatStoreDataChangeListner listner) {
        listners.add(listner);
    }
}
