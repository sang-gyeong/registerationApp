package org.techtown.registeration;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest { //AddRequest와 유사

    final static private String URL = "https://sknglee22.cafe24.com/ScheduleDelete.php";
    private Map<String, String> parameters;

    public DeleteRequest(String userID, String courseID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("courseID", courseID);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}

