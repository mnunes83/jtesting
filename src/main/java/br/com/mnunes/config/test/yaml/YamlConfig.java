package br.com.mnunes.config.test.yaml;

import br.com.mnunes.config.test.Config;
import br.com.mnunes.config.test.yaml.dto.ApiDTO;
import br.com.mnunes.exception.ConfigException;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class YamlConfig implements Config<ApiDTO> {

    @Override
    public ApiDTO load(String file) throws ConfigException {

        FileInputStream fileInputStream = null;

        if(file == null || file.equals("")) {
            throw new ConfigException("File cannot be null");
        }

        try {

            fileInputStream = new FileInputStream(new File(file));

        } catch (FileNotFoundException e) {
            throw new ConfigException("File " + file + " not found");
        }

        LoaderOptions options = new LoaderOptions();
        options.setAllowDuplicateKeys(true);
        Yaml yaml = new Yaml(new Constructor(ApiDTO.class, options));

        ApiDTO apiDTO = yaml.load(fileInputStream);

        return apiDTO;
    }
}
