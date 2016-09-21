package manoj.com.dynamicview.property.style;

import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.Utils;

import static manoj.com.dynamicview.property.PropertyValueType.SP;

/**
 * Created by manoj on 20/09/16.
 */
public class PTextSize extends StyleProperty {

    public PTextSize(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case SP:
                ((TextView) view).setTextSize(getValue());
        }
    }

    public int getValue() {
        float sp = Utils.parseSpValue(getData());
        return (int) Utils.spToPx(sp);
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view instanceof TextView;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(SP);
    }

}
