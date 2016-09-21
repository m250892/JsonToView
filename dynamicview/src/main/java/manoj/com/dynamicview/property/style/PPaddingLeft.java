package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PPaddingLeft extends PPadding {

    public PPaddingLeft(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setPadding(getValue(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
