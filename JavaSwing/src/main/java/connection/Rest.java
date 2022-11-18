/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author 98tae
 */
public class Rest {

    private static ObjectMapper mapper = new ObjectMapper();
    public static JsonNode get(String path){
        return request("GET", path, null);
    }
    public static JsonNode post(String path,Object data){
        return request("POST", path, data);
    }
    public static JsonNode put(String path,Object data){
        return request("PUT", path, data);
    }
    public static JsonNode delete(String path){
        return request("DELETE", path, null);
    }
    
    private static JsonNode request(String method, String path, Object data) {
        try {
            String uri = "https://polyjava6-4528b-default-rtdb.firebaseio.com" + path + ".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);
            }
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
