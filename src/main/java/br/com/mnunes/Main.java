package br.com.mnunes;

import br.com.mnunes.config.test.yaml.YamlConfig;
import br.com.mnunes.config.test.yaml.dto.ApiDTO;
import br.com.mnunes.exception.ConfigException;

public class Main {

    public static void main(String[] args) {

        ApiDTO apiDTO = null;

        YamlConfig yamlConfig = new YamlConfig();

        String file = args[0];

        try {

            apiDTO = yamlConfig.load(file);

        } catch (ConfigException e) {
            // TODO ... Setup log
        }
    }
}