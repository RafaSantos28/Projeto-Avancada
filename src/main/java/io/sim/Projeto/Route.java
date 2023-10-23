package io.sim.Projeto;

import de.tudresden.sumo.objects.SumoStringList;
import de.tudresden.sumo.util.SumoCommand;
import io.sim.json.JSONObject;

public class Route {
    private String id;
    private String edges;

    public Route(String json){
        JSONObject obj = new JSONObject(json);

        this.id = obj.getString("id");
        this.edges = obj.getString("route");
    }

    public Route(String id,  String edges) {
        this.id = id;
        this.edges = edges;
    }
    
    public String getId() {
        return id;
    }

    public String getEdges() {
        return edges;
    }

    public String toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("id", this.id);
        obj.put("route", this.edges);
        return obj.toString();
    }

    public static SumoCommand add(String string, SumoStringList edge) {
        return null;
    }
}
