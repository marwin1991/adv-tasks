package com.codecool.restclients.openfeign;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import com.codecool.restclients.github.GitHubClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("feign")
@Slf4j
@Component
class OpenFeignGitHubClient implements GitHubClient {

    private final OpenFeignClient client;

    @Autowired
    OpenFeignGitHubClient(OpenFeignClient client) {
        this.client = client;
    }

    @Override
    public GitHubUserInfoDTO getInfo(String nick) {
        log.info("WebClient test");
        return client.get(nick);
    }

    @Override
    public void createRepo(String name) {
        throw new RuntimeException("Not implemented yet");
    }

}
