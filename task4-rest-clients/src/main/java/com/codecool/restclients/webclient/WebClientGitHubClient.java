package com.codecool.restclients.webclient;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import com.codecool.restclients.github.GitHubClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;

@Profile("webClient")
@Slf4j
@Component
public class WebClientGitHubClient implements GitHubClient {

    private static final String BASE_URL = "https://api.github.com/";

    @Override
    public GitHubUserInfoDTO getInfo(String nick) {
        log.info("WebClient test");
        WebClient client = WebClient.create(BASE_URL);


        GitHubUserInfoDTO response = client.get().uri("/users/" + nick)
                .retrieve()
                .bodyToMono(GitHubUserInfoDTO.class)
                .block();

        return response;
    }

    @Override
    public void createRepo(String name) {
        throw new RuntimeException("Not implemented yet");
    }
}
