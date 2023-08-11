package br.com.mnunes.config.validade.security;

import br.com.mnunes.config.test.yaml.dto.security.AzureDTO;
import br.com.mnunes.exception.ConfigException;

public class AzureValidation {

    public void validate(AzureDTO azureDTO) throws ConfigException {

        if(azureDTO.getUrl() == null || azureDTO.getUrl().equals("")) {
            throw new ConfigException("Url property on azure config is required");
        }

        if(azureDTO.getClientId() == null || azureDTO.getClientId().equals("")) {
            throw new ConfigException("ClientId property on azure config is required");
        }

        if(azureDTO.getClientSecret() == null || azureDTO.getClientSecret().equals("")) {
            throw new ConfigException("ClientSecret property on azure config is required");
        }

        if(azureDTO.getScope() == null || azureDTO.getScope().equals("")) {
            throw new ConfigException("Scope property on azure config is required");
        }
    }
}
