package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by manoj on 20/09/16.
 */
public class WTextView extends Widget {
    @Override
    public View createView(Context context) {
        return new TextView(context);
    }
}
