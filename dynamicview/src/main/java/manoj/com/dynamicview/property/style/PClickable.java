package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PClickable extends BooleanStyleProperty {

    public PClickable(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setClickable(getValue());
    }
}
