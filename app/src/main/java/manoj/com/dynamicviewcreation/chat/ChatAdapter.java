package manoj.com.dynamicviewcreation.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import manoj.com.dynamicview.DynamicViewBuilder;
import manoj.com.dynamicviewcreation.R;
import manoj.com.dynamicviewcreation.chat.model.BaseMessageModel;
import manoj.com.dynamicviewcreation.chat.model.DynamicMessageModel;
import manoj.com.dynamicviewcreation.chat.model.TextMessageModel;

/**
 * Created by manoj on 22/09/16.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context context;
    private List<BaseMessageModel> messageList;


    public ChatAdapter(Context context, List<BaseMessageModel> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("manoj", "ViewType : " + viewType);
        ViewHolder holder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
            holder = new TextMessageViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_dynamic_view, null);
            holder = new DynamicViewHolder(view);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return messageList.get(position).getType().ordinal();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseMessageModel baseMessageModel = messageList.get(position);
        if (baseMessageModel instanceof TextMessageModel) {
            ((TextMessageViewHolder) holder).textView.setText(((TextMessageModel) baseMessageModel).getText());
        } else if (baseMessageModel instanceof DynamicMessageModel) {
            //Dynamic view
            DynamicMessageModel dynamicMessageModel = (DynamicMessageModel) baseMessageModel;
            DynamicViewHolder dynamicViewHolder = (DynamicViewHolder) holder;
            View view = DynamicViewBuilder.build(context, dynamicMessageModel.getJsonObject(), dynamicViewHolder.frameLayout);
            if (view != null) {
                dynamicViewHolder.frameLayout.removeAllViews();
                dynamicViewHolder.frameLayout.addView(view);
            }
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public class DynamicViewHolder extends ViewHolder {

        private FrameLayout frameLayout;

        public DynamicViewHolder(View itemView) {
            super(itemView);
            frameLayout = (FrameLayout) itemView.findViewById(R.id.dynamic_view_holder);
        }
    }

    public class TextMessageViewHolder extends ViewHolder {

        private TextView textView;

        public TextMessageViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

}
