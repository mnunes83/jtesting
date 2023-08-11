package br.com.mnunes.config.validade.security;

import br.com.mnunes.config.test.yaml.dto.security.WebDTO;
import br.com.mnunes.exception.ConfigException;

public class WebValidation {

    public void validate(WebDTO webDTO) throws ConfigException {

        if(webDTO.getUrl() == null || webDTO.getUrl().equals("")) {
            throw new ConfigException("Url property on web config is required");
        }

        if(webDTO.getClientId() == null || webDTO.getClientId().equals("")) {
            throw new ConfigException("ClientId property on web config is required");
        }

        if(webDTO.getResource() == null || webDTO.getResource().equals("")) {
            throw new ConfigException("Resource property on web config is required");
        }

        if(webDTO.getUsername() == null || webDTO.getUsername().equals("")) {
            throw new ConfigException("Username property on web config is required");
        }

        if(webDTO.getPassword() == null || webDTO.getPassword().equals("")) {
            throw new ConfigException("Password property on web config is required");
        }
    }
}
