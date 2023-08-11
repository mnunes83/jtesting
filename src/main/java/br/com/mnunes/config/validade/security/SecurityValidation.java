package br.com.mnunes.config.validade.security;

import br.com.mnunes.config.test.yaml.dto.security.AdfsDTO;
import br.com.mnunes.config.test.yaml.dto.security.AzureDTO;
import br.com.mnunes.config.test.yaml.dto.security.SecurityDTO;
import br.com.mnunes.config.test.yaml.dto.security.WebDTO;
import br.com.mnunes.exception.ConfigException;

public class SecurityValidation {

    public void validade(SecurityDTO securityDTO) throws ConfigException {

        AdfsDTO adfsDTO = securityDTO.getAdfs();

        if(adfsDTO != null) {
            AdfsValidation adfs = new AdfsValidation();
            adfs.validate(adfsDTO);
        }

        AzureDTO azureDTO = securityDTO.getAzure();

        if(azureDTO != null) {
            AzureValidation azure = new AzureValidation();
            azure.validate(azureDTO);
        }

        WebDTO webDTO = securityDTO.getWeb();

        if(webDTO != null) {
            WebValidation web = new WebValidation();
            web.validate(webDTO);
        }
    }
}
