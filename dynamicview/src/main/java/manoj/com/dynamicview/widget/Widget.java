package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import manoj.com.dynamicview.IOnClickListener;
import manoj.com.dynamicview.property.Property;
import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.property.params.LayoutProperty;
import manoj.com.dynamicview.property.style.PID;
import manoj.com.dynamicview.property.style.POnClickProperty;
import manoj.com.dynamicview.property.style.StyleProperty;

/**
 * Created by manoj on 16/09/16.
 */
public abstract class Widget {
    protected List<Property> properties;
    protected List<Widget> childViews;

    protected Widget() {
        this.properties = new ArrayList<>();
        this.childViews = new ArrayList<>();
    }

    public void applyStyleProperties(View view) {
        for (Property property : getStyleProperties()) {
            property.applyStyleProperty(view);
        }
    }

    public void applyLayoutProperties(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        for (Property property : getLayoutProperties()) {
            property.addLayoutProperty(params, ids);
        }
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void addChildViews(List<Widget> childs) {
        if (childs != null) {
            childViews.addAll(childs);
        }
    }

    public List<Property> getStyleProperties() {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof StyleProperty) {
                result.add(property);
            }
        }
        return result;
    }

    public List<Property> getLayoutProperties() {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property instanceof LayoutProperty) {
                result.add(property);
            }
        }
        return result;
    }

    public void registerOnClickListener(IOnClickListener onClickListener) {
        for (Property property : properties) {
            if (property instanceof POnClickProperty) {
                ((POnClickProperty) property).registerClickListener(onClickListener);
            }
        }

        for (Widget widget : getChildViews()) {
            widget.registerOnClickListener(onClickListener);
        }
    }

    public List<Widget> getChildViews() {
        return childViews;
    }

    public abstract View createView(Context context);

    @Override
    public String toString() {
        String result = super.toString() + " Properties :" + properties.toString() + ", Childrens : " + childViews.toString();
        return result;
    }

    public String getId() {
        for (Property property : getStyleProperties()) {
            if (property instanceof PID && ((PID) property).getType() == PropertyValueType.ID) {
                return ((PID) property).getValue();
            }
        }
        return null;
    }
}
