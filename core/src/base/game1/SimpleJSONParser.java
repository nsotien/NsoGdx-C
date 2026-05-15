package base.game1;

import java.util.Hashtable;
import java.util.Vector;

public class SimpleJSONParser {
   public Hashtable parse(String json) throws Exception {
      Hashtable jsonObject = new Hashtable();
      json = json.trim();
      if (json.startsWith("{") && json.endsWith("}")) {
         json = json.substring(1, json.length() - 1).trim();
         String[] pairs = this.split(json, ',');

         for(int i = 0; i < pairs.length; ++i) {
            String[] keyValue = this.split(pairs[i], ':');
            if (keyValue.length == 2) {
               String key = this.removeQuotes(keyValue[0].trim());
               String value = keyValue[1].trim();
               if (value.startsWith("{")) {
                  Hashtable subObject = this.parse(value);
                  jsonObject.put(key, subObject);
               } else if (value.startsWith("[")) {
                  Vector array = this.parseArray(value);
                  jsonObject.put(key, array);
               } else {
                  jsonObject.put(key, this.removeQuotes(value));
               }
            }
         }

         return jsonObject;
      } else {
         throw new Exception("Invalid JSON format");
      }
   }

   public Vector parseArray(String arrayString) throws Exception {
      Vector jsonArray = new Vector();
      arrayString = arrayString.trim();
      if (arrayString.startsWith("[") && arrayString.endsWith("]")) {
         arrayString = arrayString.substring(1, arrayString.length() - 1).trim();
         String[] elements = this.split(arrayString, ',');

         for(int i = 0; i < elements.length; ++i) {
            jsonArray.addElement(this.removeQuotes(elements[i].trim()));
         }

         return jsonArray;
      } else {
         throw new Exception("Invalid JSONArray format");
      }
   }

   private String[] split(String str, char delimiter) {
      int count = 1;

      for(int i = 0; i < str.length(); ++i) {
         if (str.charAt(i) == delimiter) {
            ++count;
         }
      }

      String[] result = new String[count];
      int start = 0;
      int index = 0;

      for(int i = 0; i < str.length(); ++i) {
         if (str.charAt(i) == delimiter) {
            result[index] = str.substring(start, i);
            start = i + 1;
            ++index;
         }
      }

      result[index] = str.substring(start);
      return result;
   }

   private String removeQuotes(String str) {
      return str.startsWith("\"") && str.endsWith("\"") ? str.substring(1, str.length() - 1) : str;
   }
}
