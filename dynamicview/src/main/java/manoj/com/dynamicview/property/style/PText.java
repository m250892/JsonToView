package manoj.com.dynamicview.property.style;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.REFERENCE;
import static manoj.com.dynamicview.property.PropertyValueType.STRING;

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

    private String getValue(Context context) {
        String result = null;
        switch (getType()) {
            case STRING:
                result = getData();
                break;
            case REFERENCE:
                int id = getStringResId(context);
                try {
                    result = context.getString(id);
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }

    private int getStringResId(Context context) {
        String data = Utils.getDataWithoutPrefix(REFERENCE, getData());
        return Utils.getStringId(context, data);
    }

    private PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    private List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(REFERENCE, STRING);
    }
}
