package manoj.com.dynamicview.property.style;

import android.view.View;

/**
 * Created by manoj on 20/09/16.
 */
public class PPaddingTop extends PPadding {
    public PPaddingTop(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setPadding(view.getPaddingLeft(), getValue(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
