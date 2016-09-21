package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.ID;

/**
 * Created by manoj on 21/09/16.
 */
public abstract class IDLayoutProperty extends LayoutProperty {

    public IDLayoutProperty(String data) {
        super(data);
    }

    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return getType() == ID && params instanceof RelativeLayout.LayoutParams;
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
