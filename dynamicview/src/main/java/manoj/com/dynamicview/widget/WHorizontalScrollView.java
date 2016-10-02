package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by manoj on 22/09/16.
 */
public class WHorizontalScrollView extends Widget {
    @Override
    public View createView(Context context) {
        return new HorizontalScrollView(context);
    }
}
