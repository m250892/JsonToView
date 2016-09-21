package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PPaddingRight extends PPadding {

    public PPaddingRight(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), getValue(), view.getPaddingBottom());
    }
}
