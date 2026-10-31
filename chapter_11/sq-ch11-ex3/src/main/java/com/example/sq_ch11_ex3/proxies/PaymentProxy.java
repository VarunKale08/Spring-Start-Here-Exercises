package com.example.sq_ch11_ex3.proxies;

import com.example.sq_ch11_ex3.models.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component // <-- No @Controller or @PostMapping here!
public class PaymentProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    public PaymentProxy(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment){
        return webClient.post()
                .uri(url + "/payment")
                .header("requestId", requestId) // <-- Header Name, Header Value
                .contentType(MediaType.APPLICATION_JSON) // <-- Tell provider it's JSON
                .bodyValue(payment) // <-- Simplified body
                .retrieve()
                .bodyToMono(Payment.class);
    }
}