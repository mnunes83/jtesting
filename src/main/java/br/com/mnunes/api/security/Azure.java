package br.com.mnunes.api.security;

public class Azure {

    private String endpoint;
    private String clientId;
    private String clientSecret;
    private String scope;

    public Azure(String endpoint, String clientId, String clientSecret, String scope) {

        this.endpoint = endpoint;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
    }
}
