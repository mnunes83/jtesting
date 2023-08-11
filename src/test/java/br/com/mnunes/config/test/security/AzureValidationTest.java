package br.com.mnunes.config.test.security;

import br.com.mnunes.config.validade.security.AzureValidation;
import br.com.mnunes.config.test.yaml.dto.security.AzureDTO;
import br.com.mnunes.exception.ConfigException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AzureValidationTest {

    @Test
    public void whenUrlIsNull_thenShouldThrowException()  {

        AzureDTO azureDTO = new AzureDTO();
        azureDTO.setUrl(null);

        AzureValidation azureValidation = new AzureValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            azureValidation.validate(azureDTO);
        });

        Assertions.assertEquals("Url property on azure config is required", exception.getMessage());
    }

    @Test
    public void whenClientIdIsNull_thenShouldThrowException()  {

        AzureDTO azureDTO = new AzureDTO();
        azureDTO.setUrl("http://");
        azureDTO.setClientId(null);

        AzureValidation azureValidation = new AzureValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            azureValidation.validate(azureDTO);
        });

        Assertions.assertEquals("ClientId property on azure config is required", exception.getMessage());
    }

    @Test
    public void whenClientSecretIsNull_thenShouldThrowException()  {

        AzureDTO azureDTO = new AzureDTO();
        azureDTO.setUrl("http://");
        azureDTO.setClientId("a5sd4065as04d66as");
        azureDTO.setClientSecret(null);

        AzureValidation azureValidation = new AzureValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            azureValidation.validate(azureDTO);
        });

        Assertions.assertEquals("ClientSecret property on azure config is required", exception.getMessage());
    }

    @Test
    public void whenScopeSecretIsNull_thenShouldThrowException()  {

        AzureDTO azureDTO = new AzureDTO();
        azureDTO.setUrl("http://");
        azureDTO.setClientId("a5sd4065as04d66as");
        azureDTO.setClientSecret("11ads51a6s150d");
        azureDTO.setScope(null);

        AzureValidation azureValidation = new AzureValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            azureValidation.validate(azureDTO);
        });

        Assertions.assertEquals("Scope property on azure config is required", exception.getMessage());
    }
}
