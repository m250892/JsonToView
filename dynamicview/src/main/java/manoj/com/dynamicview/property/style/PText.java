package manoj.com.dynamicview.property.style;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyDataType;

import static manoj.com.dynamicview.property.PropertyDataType.REFERENCE;
import static manoj.com.dynamicview.property.PropertyDataType.STRING;

/**
 * Created by manoj on 16/09/16.
 */
public class PText extends StyleProperty {

    public PText(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        ((TextView) view).setText(getValue(view.getContext()));
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view instanceof TextView;
    }

    public String getValue(Context context) {
        switch (getType()) {
            case STRING:
                return getData();
            case REFERENCE:
                //TODO: need to implement this feature
                return getData();
        }
        return null;
    }

    public PropertyDataType getType() {
        return PropertyDataType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyDataType> getPropertyTypes() {
        return Arrays.asList(REFERENCE, STRING);
    }
}
