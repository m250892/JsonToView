package manoj.com.dynamicviewcreation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import org.json.JSONException;
import org.json.JSONObject;

import manoj.com.dynamicview.ConverterJsonToWidget;
import manoj.com.dynamicview.ConverterWidgetToView;
import manoj.com.dynamicview.widget.Widget;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FrameLayout viewContainer = (FrameLayout) findViewById(R.id.container);
        addDynamicViewInContainer(viewContainer);
    }

    private void addDynamicViewInContainer(FrameLayout viewContainer) {

        JSONObject jsonObject = FileReader.getFileData(this, "testFormat.json");
        if (jsonObject != null) {
            Log.d("manoj", "Input Json Data :" + jsonObject.toString());
        }

        try {
            Widget widget = ConverterJsonToWidget.parseWidgetJsonObject(jsonObject);
            if (widget != null) {
                Log.d("manoj", "Json to Widget Data :" + widget.toString());
                View view = ConverterWidgetToView.buildView(this, widget, null);
                if (view != null) {
                    viewContainer.addView(view);
                }
            } else {
                Log.d("manoj", "Widget is null");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
