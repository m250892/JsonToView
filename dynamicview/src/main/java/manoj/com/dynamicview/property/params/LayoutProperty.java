package manoj.com.dynamicview.property.params;

import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import manoj.com.dynamicview.property.Property;

/**
 * Created by manoj on 17/09/16.
 */
public abstract class LayoutProperty extends Property {

    public LayoutProperty(String data) {
        super(data);
    }

    @Override
    public void addLayoutProperty(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        if (isParamsTypeValid(params)) {
            addRule(params, ids);
        }
    }

    @Override
    public void applyStyleProperty(View view) {

    }

    protected abstract void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids);

    protected abstract boolean isParamsTypeValid(ViewGroup.LayoutParams params);
}
