package com.dene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test_URL_Req {



  public static void main(String[] args) throws IOException, JSONException {

	 
	  
	  InputStream is = new URL("https://www.quandl.com/api/v3/datasets/CBRT/TP_MK_ISL_MK.json?api_key=SYvvsyvCbzRPu9rCRs6U").openStream();
	  BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
    String jsonText = readAll(rd);
    JSONObject json = new JSONObject(jsonText);
    is.close();
   // System.out.println(json.toString());
  
   //json.getJSONObject("dataset");
    
    
    //printJsonObject(json);
    
 
   // System.out.println(json.getJSONObject("dataset"));
 
    JSONObject json2 = json.getJSONObject("dataset");
    //  System.out.println(json2.get("data"));
    
  // System.out.println(json2.optJSONArray("data"));
  //  JSONArray js = json2.optJSONArray("data");
    //JSONArray js2 = js.getJSONArray(1);
   // System.out.println(js2.get(1));
    
    ArrayList<Gunlukverý> datalar = new ArrayList<Gunlukverý>();     
   JSONArray jsonArray = json2.optJSONArray("data"); 
   if (jsonArray != null) { 
      int len = jsonArray.length();
      for (int i=0;i<len;i++){ 
    	  Gunlukverý gv = new Gunlukverý();
    	  JSONArray onedayarray=jsonArray.optJSONArray(i);
    	  
    	  gv.setTarih(onedayarray.get(0).toString());
    	 //System.out.println(onedayarray.get(0).toString());
    	  gv.setDeger((double) onedayarray.get(1));
    	 //System.out.println(onedayarray.get(1).toString());
    		datalar.add(gv);
    	  	
 
      	} 
        
   } 
   
  // System.out.println(datalar.toString());
   
   //DATALAR ARRAYLÝSTÝNDE GÜNLÜKVERÝ TÝPÝNDE OBJELER TUTULUYOR BU OBJERLERDE DE OBJELERÝN PARAMETLERÝNE GÖRE VERÝ TUTULUYOR
   
   
   System.out.println(datalar.get(0).getDeger());
   System.out.println(datalar.get(0).toString());
   datalar.get(0).setDeger(100000);
   System.out.println(datalar.get(0).getDeger());
   System.out.println(datalar.get(0).toString());
   System.out.println("--------");
   System.out.println(datalar.get(1));
   System.out.println(datalar.get(2));
   System.out.println(datalar.get(3));
    
   
  
    
   
 
      
  }
  
	  
	  
  public static void printJsonObject(JSONObject jsonObj) {
	    for (Object key : jsonObj.keySet()) {
	        //based on you key types
	        String keyStr = (String)key;
	        Object keyvalue = jsonObj.get(keyStr);

	        //Print key and value
	        System.out.println("key: "+ keyStr + " value: " + keyvalue);

	        //for nested objects iteration if required
	        if (keyvalue instanceof JSONObject)
	            printJsonObject((JSONObject)keyvalue);
	    }
  }
  
  
  private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
  
  
}




