package manoj.com.dynamicview.property.params;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

/**
 * Created by manoj on 21/09/16.
 */
public class PLayoutGravity extends LayoutProperty {

    public PLayoutGravity(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        if (isParamsTypeValid(params)) {
            ((LinearLayout.LayoutParams) params).gravity = getValue();
        }
    }

    @Override
    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return getType() == PropertyValueType.GRAVITY_TYPE && params instanceof LinearLayout.LayoutParams;
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
