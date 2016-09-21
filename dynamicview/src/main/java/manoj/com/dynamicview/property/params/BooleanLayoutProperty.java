package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.BOOLEAN;

/**
 * Created by manoj on 21/09/16.
 */
public abstract class BooleanLayoutProperty extends LayoutProperty {

    public BooleanLayoutProperty(String data) {
        super(data);
    }

    @Override
    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return getType() == BOOLEAN && params instanceof RelativeLayout.LayoutParams;
    }

    public boolean getValue() {
        return Utils.convertStringToBoolean(getData());
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(BOOLEAN);
    }
}
