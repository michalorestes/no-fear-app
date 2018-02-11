package com.nf.michal.nofear.Repository;

import com.nf.michal.nofear.Entities.Challenge;
import com.nf.michal.nofear.Services.DataServices.Clietn;
import com.nf.michal.nofear.Services.DataServices.Request;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChallengesRepository {
    private Request request;
    private Clietn clietn;
    private Map<String, String> parameters;
    private JSONParser jsonParser;

    public ChallengesRepository(Request request, Clietn clietn){
        this.request = request;
        this.clietn = clietn;
        this.jsonParser = new JSONParser();
    }

    public ArrayList<Challenge> getAllChallenges() throws Exception {
        this.request.setSource(Request.Source.challenges);
        Map<String, String> filters = new HashMap<>();
        this.request.createRequest(filters);
        this.clietn.setRequest(this.request);
        String jsonString = clietn.fetch();
        Object obj = this.jsonParser.parse(jsonString);
        JSONArray jsonArray = (JSONArray) obj;
        ArrayList<Challenge> arrayList = new ArrayList<>();
        for (Object jsonObject1 : jsonArray) {
            JSONObject jsonObject = (JSONObject) jsonObject1;
            arrayList.add(new Challenge(jsonObject));
        }
        return arrayList;
    }
}
