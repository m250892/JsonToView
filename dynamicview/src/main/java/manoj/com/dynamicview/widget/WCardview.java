package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by manoj on 21/09/16.
 */
public class WCardview extends Widget {
    @Override
    public View createView(Context context) {
        return new FrameLayout(context);
    }
}
