package com.codecool.restclients.resttemplate;

import com.codecool.restclients.dto.GitHubCreateRepoDTO;
import com.codecool.restclients.dto.GitHubUserInfoDTO;
import com.codecool.restclients.github.GitHubClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Profile("restTemplate")
@Slf4j
@Component
class RestTemplateGitHubClient implements GitHubClient {

    private static final String BASE_URL = "https://api.github.com/";

    private final RestTemplate restTemplate;

    @Value("${github.personal-token}")
    private String token;

    public RestTemplateGitHubClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public GitHubUserInfoDTO getInfo(String nick){
        log.info("RestTemplate test");
        String url = BASE_URL + "users/" + nick;

        GitHubUserInfoDTO response = restTemplate.getForObject(url, GitHubUserInfoDTO.class);

        return response;
    }

    @Override
    public void createRepo(String name) {
        log.info("RestTemplate post test");
        String url = BASE_URL + "/user/repos";

        GitHubCreateRepoDTO requestBody = new GitHubCreateRepoDTO(name);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + token);

        HttpEntity<GitHubCreateRepoDTO> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        log.info(String.valueOf(responseEntity.getStatusCode()));
        log.info(responseEntity.getBody());
    }


}
