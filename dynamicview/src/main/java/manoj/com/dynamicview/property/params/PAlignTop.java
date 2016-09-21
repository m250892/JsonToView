package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;

/**
 * Created by manoj on 21/09/16.
 */
public class PAlignTop extends IDLayoutProperty {

    public PAlignTop(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        if (ids.containsKey(getValue())) {
            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_TOP, ids.get(getValue()));
        }
    }
}
