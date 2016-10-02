package manoj.com.dynamicviewcreation.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.Random;

import manoj.com.dynamicviewcreation.FileReader;
import manoj.com.dynamicviewcreation.R;
import manoj.com.dynamicviewcreation.chat.model.DynamicMessageModel;
import manoj.com.dynamicviewcreation.chat.model.TextMessageModel;

public class ChatActivity extends AppCompatActivity implements ChatStoreDataChangeListner, View.OnClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ChatDataStore chatDataStore;

    private EditText messageTypeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messageTypeEditText = (EditText) findViewById(R.id.message_type_edittext);
        findViewById(R.id.send_btn).setOnClickListener(this);


        chatDataStore = ChatDataStore.getInstance();
        chatDataStore.addListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(this, chatDataStore.getMessageList());
        recyclerView.setAdapter(chatAdapter);
        recyclerView.smoothScrollToPosition(chatAdapter.getItemCount());
    }

    @Override
    public void onChatDataChange() {
        if (chatAdapter != null) {
            chatAdapter.notifyDataSetChanged();
        }
        recyclerView.smoothScrollToPosition(chatAdapter.getItemCount());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                handleSendBtnClick();
                break;
        }
    }

    private void handleSendBtnClick() {
        String text = messageTypeEditText.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            chatDataStore.addMessage(new TextMessageModel(text));
            messageTypeEditText.setText("");
        }
        addMessageInChat();
    }

    private void addMessageInChat() {
        String names[] = {"card_one.json", "card_two.json", "card_three.json", "card_four.json"};
        int value = new Random().nextInt(names.length);
        String fileName = names[value];
        JSONObject jsonObject = FileReader.getFileData(this, fileName);
        chatDataStore.addMessage(new DynamicMessageModel(jsonObject));
    }
}
