package br.com.mnunes.config.validade.security;

import br.com.mnunes.config.test.yaml.dto.security.AdfsDTO;
import br.com.mnunes.exception.ConfigException;

public class AdfsValidation {

    public void validate(AdfsDTO adfsDTO) throws ConfigException {

        if(adfsDTO.getUrl() == null || adfsDTO.getUrl().equals("")) {
            throw new ConfigException("Url property on adfs config is required");
        }

        if(adfsDTO.getClientId() == null || adfsDTO.getClientId().equals("")) {
            throw new ConfigException("ClientId property on adfs config is required");
        }

        if(adfsDTO.getClientSecret() == null || adfsDTO.getClientSecret().equals("")) {
            throw new ConfigException("ClientSecret property on adfs config is required");
        }

        if(adfsDTO.getResource() == null || adfsDTO.getResource().equals("")) {
            throw new ConfigException("Resource property on adfs config is required");
        }
    }
}
