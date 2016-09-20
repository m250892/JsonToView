package manoj.com.dynamicview.property.style;

import android.view.View;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.Utils;
import manoj.com.dynamicview.property.PropertyDataType;

import static manoj.com.dynamicview.property.PropertyDataType.COLOR;
import static manoj.com.dynamicview.property.PropertyDataType.REFERENCE;

/**
 * Created by manoj on 17/09/16.
 */
public class PBackground extends StyleProperty {

    public PBackground(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case COLOR:
                view.setBackgroundColor((Integer) getValue());
                break;
            case REFERENCE:
                //TODO: need to implement color value
                //view.setBackgroundResource((Integer) getValue());
                break;
        }
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view != null;
    }

    public PropertyDataType getType() {
        return PropertyDataType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyDataType> getPropertyTypes() {
        return Arrays.asList(COLOR, REFERENCE);
    }

    public Object getValue() {
        return Utils.convertColor(getData());
    }
}
