package manoj.com.dynamicview.property.style;

import android.view.View;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.Utils;

import static manoj.com.dynamicview.property.PropertyValueType.BOOLEAN;

/**
 * Created by manoj on 20/09/16.
 */
public abstract class BooleanStyleProperty extends StyleProperty {

    public BooleanStyleProperty(String data) {
        super(data);
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return getType() == BOOLEAN && view != null;
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
