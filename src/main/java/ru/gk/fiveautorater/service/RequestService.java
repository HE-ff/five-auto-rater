package ru.gk.fiveautorater.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.gk.fiveautorater.model.Check;
import ru.gk.fiveautorater.model.DetailCheck;
import ru.gk.fiveautorater.model.Transactions;
import ru.gk.fiveautorater.model.Unrated;

@Service
public class RequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);

    @Value("${authorization}")
    private String authorization;

    private static final String RATE_URL = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3YyL3RyYW5zYWN0aW9ucy8=";
    private static final String UNRATED_LIST_URL = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3YzL3RyYW5zYWN0aW9ucy91bnJhdGVk";
    private static final String TRAN = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3YyL3RyYW5zYWN0aW9ucy8/bGltaXQ9NSZvZmZzZXQ9";
    private static final String CHECK_DETAIL = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3YyL3RyYW5zYWN0aW9ucy8=";
    private static final String UNRATED_LIST_URL_5 = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3Y1L3RyYW5zYWN0aW9ucy91bnJhdGVkLw==";
    private static final String RATINGS_URL = "aHR0cHM6Ly9teS41a2EucnUvYXBpL3YyL3RyYW5zYWN0aW9ucy9yYXRpbmdzLw==";


    private static final String RATE_URL_D = new String(Base64.decodeBase64(RATE_URL.getBytes()));
    private static final String TRAN_D = new String(Base64.decodeBase64(TRAN.getBytes()));
    private static final String CHECK_DETAIL_D = new String(Base64.decodeBase64(CHECK_DETAIL.getBytes()));
    private static final String UNRATED_LIST_URL_5_D = new String(Base64.decodeBase64(UNRATED_LIST_URL_5.getBytes()));
    private static final String RATINGS_URL_D = new String(Base64.decodeBase64(RATINGS_URL.getBytes()));

    private final RestTemplate restTemplate;
    private static final String RATE = "{\"rate\":5}";

    @Autowired
    public RequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Check> getUnrated() {
        final String checkUrl = new String(Base64.decodeBase64(UNRATED_LIST_URL.getBytes()));
        final HttpEntity<String> request = new HttpEntity<>(getHeaders());

        final ResponseEntity<List<Check>> result = restTemplate.exchange(checkUrl, HttpMethod.GET, request, new ParameterizedTypeReference<List<Check>>() {
        });
        log.info("getUnrated result " + result.getStatusCode().getReasonPhrase() + ":" + result);
        return result.getBody();
    }


    public List<Unrated> getUnrated_v2() {
        final HttpEntity<String> request = new HttpEntity<>(getHeaders());

        final ResponseEntity<List<Unrated>> result = restTemplate.exchange(UNRATED_LIST_URL_5_D, HttpMethod.GET, request, new ParameterizedTypeReference<>() {
        });
        log.info("getUnrated_5 result " + result.getStatusCode().getReasonPhrase() + ":" + result);
        return result.getBody();
    }


    public boolean rateProduct(String checkId, String productId) {
        String requestUrl = RATE_URL_D.concat(checkId).concat("/products/").concat(productId).concat("/rate/");
        final HttpEntity<String> request = new HttpEntity<>(RATE, getHeaders());

        final ResponseEntity<String> result = restTemplate.postForEntity(requestUrl, request, String.class);
        log.info("rateProduct result " + result.getStatusCode().getReasonPhrase() + ":" + result);
        return result.getStatusCode() == HttpStatus.OK;
    }


    public Transactions getTransactions(final long offset) {
        final String requestUrl = TRAN_D.concat(Long.toString(offset));
        final HttpEntity<String> request = new HttpEntity<>(getHeaders());

        ResponseEntity<Transactions> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, new ParameterizedTypeReference<Transactions>() {
        });
        log.info("getTransactions result " + result.getStatusCode().getReasonPhrase() + ":" + result);
        return result.getBody();
    }


    public DetailCheck getDetail(final String id) {
        log.debug("getDetail:" + id);
        final String requestUrl = CHECK_DETAIL_D.concat(id).concat("/");
        final HttpEntity<String> request = new HttpEntity<>(getHeaders());

        final ResponseEntity<DetailCheck> result = restTemplate.exchange(requestUrl, HttpMethod.GET, request, DetailCheck.class);
        log.info("getDetail result " + result.getStatusCode().getReasonPhrase() + ":" + result);
        return result.getBody();
    }


    public boolean rateProducts(String json) {
        log.debug("rateProducts:" + json);
        final HttpEntity<String> request = new HttpEntity<>(json, getHeaders());

        final ResponseEntity<ObjectNode> result = restTemplate.postForEntity(RATINGS_URL_D, request, ObjectNode.class);
        log.info("rateProducts result " + result.getStatusCode().getReasonPhrase() + ":" + result);

        return result.getStatusCode() == HttpStatus.OK && result.getBody() != null && result.getBody().isEmpty();
    }


    private MultiValueMap<String, String> getHeaders() {
        final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        headers.set("X-Authorization", authorization);
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
        headers.set("Accept", "application/json, text/plain, */*");
        headers.set("Content-Type", "application/json;charset=UTF-8");

        return headers;
    }

}
