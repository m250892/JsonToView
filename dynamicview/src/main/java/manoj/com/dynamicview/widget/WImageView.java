package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by manoj on 20/09/16.
 */
public class WImageView extends Widget {

    @Override
    public View createView(Context context) {
        return new ImageView(context);
    }
}
