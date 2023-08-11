package br.com.mnunes.config.test.security;

import br.com.mnunes.config.validade.security.AdfsValidation;
import br.com.mnunes.config.test.yaml.dto.security.AdfsDTO;
import br.com.mnunes.exception.ConfigException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdfsValidationTest {

    @Test
    public void whenUrlIsNull_thenShouldThrowException()  {

        AdfsDTO adfsDTO = new AdfsDTO();
        adfsDTO.setUrl(null);

        AdfsValidation adfsValidate = new AdfsValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            adfsValidate.validate(adfsDTO);
        });

        Assertions.assertEquals("Url property on adfs config is required", exception.getMessage());
    }

    @Test
    public void whenClientIdIsNull_thenShouldThrowException()  {

        AdfsDTO adfsDTO = new AdfsDTO();
        adfsDTO.setUrl("http://");
        adfsDTO.setClientId(null);

        AdfsValidation adfsValidate = new AdfsValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            adfsValidate.validate(adfsDTO);
        });

        Assertions.assertEquals("ClientId property on adfs config is required", exception.getMessage());
    }

    @Test
    public void whenClientSecretIsNull_thenShouldThrowException()  {

        AdfsDTO adfsDTO = new AdfsDTO();
        adfsDTO.setUrl("http://");
        adfsDTO.setClientId("as32d1a3s2d1as32d");
        adfsDTO.setClientSecret(null);

        AdfsValidation adfsValidate = new AdfsValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            adfsValidate.validate(adfsDTO);
        });

        Assertions.assertEquals("ClientSecret property on adfs config is required", exception.getMessage());
    }

    @Test
    public void whenResourceSecretIsNull_thenShouldThrowException()  {

        AdfsDTO adfsDTO = new AdfsDTO();
        adfsDTO.setUrl("http://");
        adfsDTO.setClientId("as32d1a3s2d1as32d");
        adfsDTO.setClientSecret("3sad203a2s10d 32asd10 as");
        adfsDTO.setResource(null);

        AdfsValidation adfsValidate = new AdfsValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            adfsValidate.validate(adfsDTO);
        });

        Assertions.assertEquals("Resource property on adfs config is required", exception.getMessage());
    }
}
