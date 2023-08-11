package br.com.mnunes.config.test.yaml.dto.security;

public class SecurityDTO {

    private AdfsDTO adfs;
    private AzureDTO azure;
    private WebDTO web;

    public AdfsDTO getAdfs() {
        return adfs;
    }

    public void setAdfs(AdfsDTO adfs) {
        this.adfs = adfs;
    }

    public AzureDTO getAzure() {
        return azure;
    }

    public void setAzure(AzureDTO azure) {
        this.azure = azure;
    }

    public WebDTO getWeb() {
        return web;
    }

    public void setWeb(WebDTO web) {
        this.web = web;
    }
}
