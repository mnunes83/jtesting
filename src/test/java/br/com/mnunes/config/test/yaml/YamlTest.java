package br.com.mnunes.config.test.yaml;

import br.com.mnunes.config.test.yaml.dto.ApiDTO;
import br.com.mnunes.config.test.yaml.dto.EndpointDTO;
import br.com.mnunes.config.test.yaml.dto.endpoint.RequestDTO;
import br.com.mnunes.config.test.yaml.dto.endpoint.ResponseDTO;
import br.com.mnunes.config.test.yaml.dto.security.AdfsDTO;
import br.com.mnunes.config.test.yaml.dto.security.AzureDTO;
import br.com.mnunes.config.test.yaml.dto.security.WebDTO;
import br.com.mnunes.exception.ConfigException;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class YamlTest {

    private String file;

    @BeforeEach
    void setup() {
        this.file = "src/test/resources/yaml/agenda-workshop-api.yaml";
    }

    @Test
    public void whenLoadNullFile_thenShouldThrowException()  {

        YamlConfig config = new YamlConfig();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            ApiDTO apiDTO = config.load(null);
        });

        Assertions.assertEquals("File cannot be null", exception.getMessage());
    }

    @Test
    public void whenLoadFileNotFound_thenShouldThrowException()  {

        String file = "src/test/resources/yaml/workshop-api.yaml";
        YamlConfig config = new YamlConfig();

        Throwable exception = Assertions.assertThrows(ConfigException.class, () -> {
            ApiDTO apiDTO = config.load(file);
        });

        Assertions.assertEquals("File " + file + " not found", exception.getMessage());
    }


    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectApiDTO() throws ConfigException {

        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        Assertions.assertNotNull(apiDTO);
        Assertions.assertEquals("DMS - Dealer Management System", apiDTO.getTitle());
        Assertions.assertEquals("DMS API", apiDTO.getDescription());
        Assertions.assertEquals("https://agenda-gateway-dev.apps.pd01e.uscentral1.cf.gcp.ford.com/agenda-workshop/api", apiDTO.getHost());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectSecurityDTO() throws ConfigException  {

        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        Assertions.assertNotNull(apiDTO.getSecurity());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectAdfsSecurityConfig() throws ConfigException  {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        AdfsDTO adfsDTO = apiDTO.getSecurity().getAdfs();
        Assertions.assertEquals("https://corpqa.sts.ford.com/adfs/oauth2/token", adfsDTO.getUrl());
        Assertions.assertEquals("ad9cdf61", adfsDTO.getClientId());
        Assertions.assertEquals("vrZY2UphAy21d5", adfsDTO.getClientSecret());
        Assertions.assertEquals("urn:age:pcf:stf:dev", adfsDTO.getResource());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectAzureSecurityConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        AzureDTO azureDTO = apiDTO.getSecurity().getAzure();
        Assertions.assertEquals("https://login.microsoftonline.com/azureford.onmicrosoft.com/oauth2/v2.0/token", azureDTO.getUrl());
        Assertions.assertEquals("e83ccd18-f41016b7e09e", azureDTO.getClientId());
        Assertions.assertEquals("i~V8Q~zvgw516a5dsasdas516516asd", azureDTO.getClientSecret());
        Assertions.assertEquals("api://a30f9d1b-bd8/.default", azureDTO.getScope());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectWebSecurityConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        WebDTO webDTO = apiDTO.getSecurity().getWeb();
        Assertions.assertEquals("https://corpqa.sts.ford.com/adfs/oauth2/token", webDTO.getUrl());
        Assertions.assertEquals("urn:age:pcf:native:dev", webDTO.getClientId());
        Assertions.assertEquals("urn:age:pcf:weblogin:dev", webDTO.getResource());
        Assertions.assertEquals("mnunes25@ford.com", webDTO.getUsername());
        Assertions.assertEquals("test", webDTO.getPassword());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectEndpointConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        EndpointDTO endpointDTO = apiDTO.getEndpoint();

        Assertions.assertNotNull(endpointDTO);
        Assertions.assertNotNull(endpointDTO.getRequest());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectRequestConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        EndpointDTO endpointDTO = apiDTO.getEndpoint();
        RequestDTO requestDTO = endpointDTO.getRequest();

        Assertions.assertNotNull(requestDTO);

        Assertions.assertEquals("/schedulers/productives/list", requestDTO.getUrl());
        Assertions.assertEquals("get", requestDTO.getMethod());
        Assertions.assertEquals("A simple description about request", requestDTO.getDescription());
        Assertions.assertEquals("adfs", requestDTO.getSecurity());
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectParameterConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        EndpointDTO endpointDTO = apiDTO.getEndpoint();
        RequestDTO requestDTO = endpointDTO.getRequest();

        Assertions.assertEquals(6, requestDTO.getParams().size());
        Assertions.assertEquals("queryString", requestDTO.getParams().get("type"));
        Assertions.assertEquals("BRA", requestDTO.getParams().get("countryCode"));
        Assertions.assertEquals(1, requestDTO.getParams().get("divisionCode"));
        Assertions.assertEquals(56007, requestDTO.getParams().get("advisorCode"));
        Assertions.assertEquals("2023-10-10", requestDTO.getParams().get("schedule"));
        Assertions.assertEquals(1000, requestDTO.getParams().get("scheduleHour"));
    }

    @Test
    public void whenLoadYAMLDocument_thenLoadCorrectJavaObjectResponseConfig() throws ConfigException {
        YamlConfig config = new YamlConfig();
        ApiDTO apiDTO = config.load(this.file);

        EndpointDTO endpointDTO = apiDTO.getEndpoint();
        ResponseDTO responseDTO = endpointDTO.getResponse();

        Assertions.assertNotNull(responseDTO);

        Assertions.assertEquals(200, responseDTO.getStatus());
        Assertions.assertEquals("json", responseDTO.getContentType());
        Assertions.assertNotNull(responseDTO.getBody());

       JsonElement jsonExpected = JsonParser.parseString("{'divisionCode':1, 'advisorCode': 56770, 'countryCode': 'BRA', 'schedule': '2023-10-10','dealerCode': 3028, 'scheduleHour': 1000}");
       JsonElement jsonResponseBody = JsonParser.parseString(responseDTO.getBody());

        Assertions.assertEquals(jsonExpected, jsonResponseBody);
    }


}
