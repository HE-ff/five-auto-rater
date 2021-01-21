package ru.gk.fiveautorater.service;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.io.IOException;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import ru.gk.fiveautorater.config.FiveAutoRaterConfig;
import ru.gk.fiveautorater.model.DetailCheck;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {FiveAutoRaterConfig.class, RequestService.class})
@EnableAutoConfiguration
class RequestServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestService requestService;

    private MockRestServiceServer mockRestServiceServer;

    @BeforeEach
    public void setUp() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void response4xx() throws IOException {
        final Resource resourceFile = new ClassPathResource("detail.json");
        final String result = StreamUtils.copyToString(resourceFile.getInputStream(), UTF_8);

        mockRestServiceServer
                .expect(requestTo(StringContains.containsString("transactions/")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(result, MediaType.APPLICATION_JSON));

        final DetailCheck res = requestService.getDetail("1");
        assertEquals(res.getLocation().getAddress(), "0000");
    }

}