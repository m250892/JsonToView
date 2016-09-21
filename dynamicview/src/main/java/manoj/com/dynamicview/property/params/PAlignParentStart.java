package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;

/**
 * Created by manoj on 21/09/16.
 */
public class PAlignParentStart extends BooleanLayoutProperty {

    public PAlignParentStart(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        if (getValue()) {
            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_START);
        }
    }
}
