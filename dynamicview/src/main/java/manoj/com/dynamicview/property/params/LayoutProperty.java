package manoj.com.dynamicview.property.params;

import android.view.View;
import android.view.ViewGroup;

import manoj.com.dynamicview.property.Property;

/**
 * Created by manoj on 17/09/16.
 */
public abstract class LayoutProperty extends Property {

    public LayoutProperty(String data) {
        super(data);
    }

    @Override
    public void addLayoutProperty(ViewGroup.LayoutParams params) {
        if (isParamsTypeValid(params)) {
            addRule(params);
        }
    }

    @Override
    public void applyStyleProperty(View view) {

    }

    protected abstract void addRule(ViewGroup.LayoutParams params);

    protected abstract boolean isParamsTypeValid(ViewGroup.LayoutParams params);
}
