package manoj.com.dynamicviewcreation;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by manoj on 20/09/16.
 */
public class FileReader {

    public static JSONObject getFileData(Context context, String filePath) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(readFile(filePath, context));
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * Helper function to load file from assets
     */
    private static String readFile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets().open(fileName);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line;
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null) isr.close();
                if (fIn != null) fIn.close();
                if (input != null) input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}
