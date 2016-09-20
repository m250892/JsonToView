package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by manoj on 16/09/16.
 */
public class WLinearLayout extends Widget {

    @Override
    public View createView(Context context) {
        return new LinearLayout(context);
    }
}
