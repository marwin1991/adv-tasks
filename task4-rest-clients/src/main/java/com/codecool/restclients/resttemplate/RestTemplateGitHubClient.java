package com.codecool.restclients.resttemplate;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import com.codecool.restclients.github.GitHubClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Profile("restTemplate")
@Slf4j
@Component
class RestTemplateGitHubClient implements GitHubClient {

    private static final String BASE_URL = "https://api.github.com/";

    private final RestTemplate restTemplate;

    public RestTemplateGitHubClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public GitHubUserInfoDTO getInfo(String nick){
        String url = BASE_URL + "users/" + nick;

        GitHubUserInfoDTO response = restTemplate.getForObject(url, GitHubUserInfoDTO.class);

        return response;
    }

}
