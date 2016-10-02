package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by manoj on 17/09/16.
 */
public class PLayoutWidth extends PLayoutHeight {

    public PLayoutWidth(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        params.width = getValue();
    }
}
