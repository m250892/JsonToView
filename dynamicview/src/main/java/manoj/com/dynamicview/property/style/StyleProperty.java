package manoj.com.dynamicview.property.style;

import android.view.View;
import android.view.ViewGroup;

import manoj.com.dynamicview.property.Property;

/**
 * Created by manoj on 17/09/16.
 */
public abstract class StyleProperty extends Property {

    public StyleProperty(String data) {
        super(data);
    }

    @Override
    public void applyStyleProperty(View view) {
        if (isViewTypeValid(view)) {
            addStyle(view);
        }
    }

    @Override
    public void addLayoutProperty(ViewGroup.LayoutParams params) {

    }

    public abstract void addStyle(View view);

    protected abstract boolean isViewTypeValid(View view);
}
