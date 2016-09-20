package manoj.com.dynamicview.property;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by manoj on 16/09/16.
 */
public abstract class Property {

    protected String data;

    public Property(String data) {
        this.data = data;
    }

    protected String getData() {
        return data;
    }

    public abstract void applyStyleProperty(View view);

    public abstract void addLayoutProperty(ViewGroup.LayoutParams params);
}
