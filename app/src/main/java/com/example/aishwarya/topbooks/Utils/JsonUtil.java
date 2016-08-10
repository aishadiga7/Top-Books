package com.example.aishwarya.topbooks.Utils;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class having functions used for handling JSON data.
 */
public class JsonUtil {


    /**
     * Parses json from assets file into Model class object
     * @param context calling context
     * @param filename complete path of JSON file
     * @param classType Model class type
     * @param <T>
     * @return Object of class Model type
     * @throws IOException
     */
    public static <T> T parseAssetJSON(Context context, String filename, Class<T> classType) throws IOException {
        InputStream is = context.getAssets().open(filename);
        Gson gson = new Gson();
        return gson.fromJson(new InputStreamReader(is),classType);
    }
}
