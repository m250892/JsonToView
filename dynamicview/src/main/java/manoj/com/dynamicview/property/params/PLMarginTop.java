package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by manoj on 20/09/16.
 */
public class PLMarginTop extends PLMargin {

    public PLMarginTop(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
        p.topMargin = getValue();
    }
}
