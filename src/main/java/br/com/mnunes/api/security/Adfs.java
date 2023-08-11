package br.com.mnunes.api.security;

public abstract class Adfs {

    private String endpoint;
    private String clientId;
    private String resource;

    public Adfs(String endpoint, String clientId, String clientSecret, String resource) {

        this.endpoint = endpoint;
        this.clientId = clientId;
        this.resource = resource;
    }


    public String getToken() {
        return "";
    }
}
