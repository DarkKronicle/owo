package maow.owo.util;

import com.google.gson.Gson;
import maow.owo.util.json.Defaults;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
    private static final Gson gson = new Gson();

    private IOUtil() {}

    public static Defaults readResourceToDefaults(String path) {
        try {
            String json = collapseLines(getAllLines(getResource(path)));
            return gson.fromJson(json, Defaults.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Defaults readFileToDefaults(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                return gson.fromJson(reader, Defaults.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getResource(String path) {
        return IOUtil.class.getResourceAsStream("/" + path);
    }

    public static List<String> getAllLines(InputStream stream) throws IOException {
        List<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        while (reader.ready()) {
            strings.add(reader.readLine());
        }
        return strings;
    }

    public static String collapseLines(List<String> strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
