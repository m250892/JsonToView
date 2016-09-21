package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PSelected extends BooleanStyleProperty {

    public PSelected(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setSelected(getValue());
    }
}
