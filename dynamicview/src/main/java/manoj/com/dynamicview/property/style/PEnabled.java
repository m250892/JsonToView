package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PEnabled extends BooleanStyleProperty {

    public PEnabled(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setEnabled(getValue());
    }
}
