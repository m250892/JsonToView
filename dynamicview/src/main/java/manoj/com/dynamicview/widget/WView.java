package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;

/**
 * Created by manoj on 22/09/16.
 */
public class WView extends Widget {
    @Override
    public View createView(Context context) {
        return new View(context);
    }
}
