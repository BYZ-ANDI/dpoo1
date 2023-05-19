package persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import persistence.Configuration;

import java.io.FileReader;
import java.io.IOException;

public class ReadConfigJSON {

    public Configuration readJSON(){

        Gson gson = new Gson();

        try {
            JsonReader jsonReader = new JsonReader(new FileReader("config.json"));
            Configuration configuration = gson.fromJson(jsonReader, Configuration.class);

            return configuration;

        }catch (IOException e) {
            return null;
        }
    }
}
