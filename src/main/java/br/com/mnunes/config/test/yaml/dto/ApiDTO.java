package br.com.mnunes.config.test.yaml.dto;

import br.com.mnunes.config.test.yaml.dto.security.SecurityDTO;

public class ApiDTO {

    private String description;
    private String title;
    private String host;
    private SecurityDTO security;

    private EndpointDTO endpoint;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public SecurityDTO getSecurity() {
        return security;
    }

    public void setSecurity(SecurityDTO security) {
        this.security = security;
    }

    public EndpointDTO getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(EndpointDTO endpoint) {
        this.endpoint = endpoint;
    }
}
