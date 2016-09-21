package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by manoj on 20/09/16.
 */
public class WButton extends Widget {

    @Override
    public View createView(Context context) {
        return new Button(context);
    }
}
