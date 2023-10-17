package io.sim.Projeto;

public class Route {

    private String id;
    private String depart;
    private String edges;

    public Route(String id, String depart, String edges) {
        this.id = id;
        this.depart = depart;
        this.edges = edges;
    }
    
    public String getId() {
        return id;
    }

    public String getDepart() {
        return depart;
    }

    public String getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Route{" + "id=" + id + ", depart=" + depart + ", edges=" + edges + '}';
    }

}
