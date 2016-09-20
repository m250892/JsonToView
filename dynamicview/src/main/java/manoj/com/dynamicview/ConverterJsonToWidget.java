package manoj.com.dynamicview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import manoj.com.dynamicview.property.FactoryProperty;
import manoj.com.dynamicview.property.Property;
import manoj.com.dynamicview.widget.FactoryWidget;
import manoj.com.dynamicview.widget.Widget;

/**
 * Created by manoj on 14/09/16.
 */
public class ConverterJsonToWidget {

    public static Widget parseWidgetJsonObject(JSONObject jsonObject) throws JSONException {
        if (jsonObject == null) {
            return null;
        }

        String widgetKey = jsonObject.getString("widget");
        if (widgetKey == null) {
            return null;
        }
        Widget widget = FactoryWidget.getWidget(widgetKey);
        Iterator<?> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if (key != null) {
                if (key.equals("widget")) {
                    continue;
                } else if (key.equals("childern")) {
                    JSONArray jsonArray = jsonObject.getJSONArray(key);
                    List<Widget> childs = parseWidgetJsonArray(jsonArray);
                    widget.addChildViews(childs);
                } else {
                    String value = jsonObject.getString(key);
                    Property property = FactoryProperty.getProperty(key, value);
                    if (property != null) {
                        widget.addProperty(property);
                    }
                }
            }
        }
        return widget;
    }

    private static List<Widget> parseWidgetJsonArray(JSONArray jsonArray) throws JSONException {
        List<Widget> widgetList = new ArrayList<>();
        if (jsonArray != null) {
            for (int index = 0; index < jsonArray.length(); index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                Widget widget = parseWidgetJsonObject(jsonObject);
                if (widget != null) {
                    widgetList.add(widget);
                }
            }
        }
        return widgetList;
    }
}
