package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by manoj on 20/09/16.
 */
public class WRelativeLayout extends Widget {

    @Override
    public View createView(Context context) {
        return new RelativeLayout(context);
    }

}
