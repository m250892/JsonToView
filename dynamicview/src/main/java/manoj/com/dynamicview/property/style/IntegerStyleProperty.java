package manoj.com.dynamicview.property.style;

import android.view.View;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.INTEGER;

/**
 * Created by manoj on 20/09/16.
 */
public abstract class IntegerStyleProperty extends StyleProperty {

    public IntegerStyleProperty(String data) {
        super(data);
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return getType() == INTEGER && view != null;
    }

    public int getValue() {
        return Integer.valueOf(getData());
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(INTEGER);
    }
}
