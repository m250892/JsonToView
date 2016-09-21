package manoj.com.dynamicview.property.style;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

/**
 * Created by manoj on 20/09/16.
 */
public class PGravity extends StyleProperty {

    public PGravity(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        if (isViewTypeValid(view)) {
            ((TextView) view).setGravity(getValue());
        }
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return getType() == PropertyValueType.GRAVITY_TYPE && view instanceof TextView;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(PropertyValueType.GRAVITY_TYPE);
    }

    public int getValue() {
        return (int) Utils.getValueInt(Gravity.class, getData().toUpperCase());
    }
}
