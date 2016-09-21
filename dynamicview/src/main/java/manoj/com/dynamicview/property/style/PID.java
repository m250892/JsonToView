package manoj.com.dynamicview.property.style;

import android.view.View;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.ID;

/**
 * Created by manoj on 21/09/16.
 */
public class PID extends StyleProperty {

    public PID(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
    }

    @Override
    public boolean isViewTypeValid(View view) {
        return getType() == ID && view != null;
    }

    public String getValue() {
        return Utils.getDataWithoutPrefix(ID, getData());
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(ID);
    }
}
