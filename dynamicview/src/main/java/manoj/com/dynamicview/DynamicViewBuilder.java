package manoj.com.dynamicview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import manoj.com.dynamicview.widget.Widget;

/**
 * Created by manoj on 22/09/16.
 */
public class DynamicViewBuilder {

    public static View build(Context context, JSONObject jsonObject) {
        return build(context, jsonObject, null);
    }

    public static View build(Context context, JSONObject jsonObject, ViewGroup viewGroup) {
        try {
            Widget widget = ConverterJsonToWidget.parseWidgetJsonObject(jsonObject);
            if (widget != null) {
                Log.d("manoj", "Json to Widget Data :" + widget.toString());
                return ConverterWidgetToView.buildView(context, widget, viewGroup);
            } else {
                Log.d("manoj", "Widget is null");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
