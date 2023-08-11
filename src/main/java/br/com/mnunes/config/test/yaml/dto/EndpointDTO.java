package br.com.mnunes.config.test.yaml.dto;

import br.com.mnunes.config.test.yaml.dto.endpoint.RequestDTO;
import br.com.mnunes.config.test.yaml.dto.endpoint.ResponseDTO;

public class EndpointDTO {

    private RequestDTO request;

    private ResponseDTO response;

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    public ResponseDTO getResponse() {
        return response;
    }

    public void setResponse(ResponseDTO response) {
        this.response = response;
    }
}
