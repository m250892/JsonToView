package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyDataType;

import static manoj.com.dynamicview.property.PropertyDataType.MATCH_PARENT;
import static manoj.com.dynamicview.property.PropertyDataType.WRAP_CONTENT;

/**
 * Created by manoj on 19/09/16.
 */
public class PLayoutHeight extends LayoutProperty {

    public PLayoutHeight(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params) {
        switch (getType()) {
            case MATCH_PARENT:
                params.height = params.MATCH_PARENT;
                break;
            case WRAP_CONTENT:
                params.height = params.WRAP_CONTENT;
                break;
        }
    }

    @Override
    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return params != null;
    }

    public PropertyDataType getType() {
        return PropertyDataType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyDataType> getPropertyTypes() {
        return Arrays.asList(MATCH_PARENT, WRAP_CONTENT);
    }
}