package br.com.mnunes.config.test.security;

import br.com.mnunes.config.validade.security.WebValidation;
import br.com.mnunes.config.test.yaml.dto.security.WebDTO;
import br.com.mnunes.exception.ConfigException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebValidationTest {

    @Test
    public void whenUrlIsNull_thenShouldThrowException()  {

        WebDTO webDTO = new WebDTO();
        webDTO.setUrl(null);

        WebValidation webValidation = new WebValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            webValidation.validate(webDTO);
        });

        Assertions.assertEquals("Url property on web config is required", exception.getMessage());
    }

    @Test
    public void whenClientIdIsNull_thenShouldThrowException()  {

        WebDTO webDTO = new WebDTO();
        webDTO.setUrl("http://");
        webDTO.setClientId(null);

        WebValidation webValidation = new WebValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            webValidation.validate(webDTO);
        });

        Assertions.assertEquals("ClientId property on web config is required", exception.getMessage());
    }

    @Test
    public void whenResourceIsNull_thenShouldThrowException()  {

        WebDTO webDTO = new WebDTO();
        webDTO.setUrl("http://");
        webDTO.setClientId("a3s2dasd20as30d2");
        webDTO.setResource(null);

        WebValidation webValidation = new WebValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            webValidation.validate(webDTO);
        });

        Assertions.assertEquals("Resource property on web config is required", exception.getMessage());
    }

    @Test
    public void whenUsernameSecretIsNull_thenShouldThrowException()  {

        WebDTO webDTO = new WebDTO();
        webDTO.setUrl("http://");
        webDTO.setClientId("a3s2dasd20as30d2");
        webDTO.setResource("web:login");
        webDTO.setUsername(null);

        WebValidation webValidation = new WebValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            webValidation.validate(webDTO);
        });

        Assertions.assertEquals("Username property on web config is required", exception.getMessage());
    }

    @Test
    public void whenPasswordSecretIsNull_thenShouldThrowException()  {

        WebDTO webDTO = new WebDTO();
        webDTO.setUrl("http://");
        webDTO.setClientId("a3s2dasd20as30d2");
        webDTO.setResource("web:login");
        webDTO.setUsername("test");
        webDTO.setPassword(null);

        WebValidation webValidation = new WebValidation();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            webValidation.validate(webDTO);
        });

        Assertions.assertEquals("Password property on web config is required", exception.getMessage());
    }
}
