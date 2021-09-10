package solution;

import com.google.gson.Gson;
import models.Root;

import java.io.*;

public class ParserJsonImpl implements ParserJson {

    public Root parse(String fileName) {
        Root root = null;
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            root = gson.fromJson(reader, Root.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
}
