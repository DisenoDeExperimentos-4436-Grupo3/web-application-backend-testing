package pe.edu.upc.managewise.backend.iam.domain.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.managewise.backend.iam.domain.model.entities.RecaptchaResponse;

@Service
public class RecaptchaService {

    @Value("${recaptcha.secret}")
    private String recaptchaSecret;

    @Value("${recaptcha.verify.url}")
    private String verifyUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean verifyRecaptcha(String recaptchaResponseToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("secret", recaptchaSecret);
        params.add("response", recaptchaResponseToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RecaptchaResponse response = restTemplate.postForObject(
                verifyUrl,
                request,
                RecaptchaResponse.class
        );

        return response != null && response.isSuccess();
    }
}

