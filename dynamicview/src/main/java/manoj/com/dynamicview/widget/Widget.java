package manoj.com.dynamicview.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import manoj.com.dynamicview.property.params.LayoutProperty;
import manoj.com.dynamicview.property.Property;
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

    public void applyLayoutProperties(ViewGroup.LayoutParams params) {
        for (Property property : getLayoutProperties()) {
            property.addLayoutProperty(params);
        }
    }

    public void addProperty(Property property) {
        if (isPropperySupported(property)) {
            properties.add(property);
        }
    }

    public void addChildViews(List<Widget> childs) {
        if (childs != null) {
            childViews.addAll(childs);
        }
    }

    protected boolean isPropperySupported(Property property) {
        return true;
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

    public List<Widget> getChildViews() {
        return childViews;
    }

    public abstract View createView(Context context);

    @Override
    public String toString() {
        String result = super.toString() + " Properties :" + properties.toString() + ", Childrens : " + childViews.toString();
        return result;
    }
}
