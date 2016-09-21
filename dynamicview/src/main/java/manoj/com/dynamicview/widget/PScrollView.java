package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by manoj on 21/09/16.
 */
public class PScrollView extends Widget {

    @Override
    public View createView(Context context) {
        return new ScrollView(context);
    }
}
