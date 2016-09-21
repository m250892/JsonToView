package manoj.com.dynamicview.property.style;

import android.view.View;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.HORIZONTAL;
import static manoj.com.dynamicview.property.PropertyValueType.VERTICAL;

/**
 * Created by manoj on 20/09/16.
 */
public class POrientation extends StyleProperty {

    public POrientation(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case HORIZONTAL:
                ((LinearLayout) view).setOrientation(LinearLayout.HORIZONTAL);
                break;
            case VERTICAL:
                ((LinearLayout) view).setOrientation(LinearLayout.VERTICAL);
                break;
        }
    }


    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(VERTICAL, HORIZONTAL);
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view instanceof LinearLayout;
    }
}
