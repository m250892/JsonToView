package manoj.com.dynamicview.property.style;

import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.Utils;

import static manoj.com.dynamicview.property.PropertyValueType.COLOR;

/**
 * Created by manoj on 20/09/16.
 */
public class PTextColor extends StyleProperty {

    public PTextColor(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case COLOR:
                ((TextView) view).setTextColor(getValue());
        }
    }

    public Integer getValue() {
        return Utils.convertColor(getData());
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view instanceof TextView;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(COLOR);
    }

}
