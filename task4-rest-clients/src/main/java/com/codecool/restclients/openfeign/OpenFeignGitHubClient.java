package com.codecool.restclients.openfeign;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import com.codecool.restclients.github.GitHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("feign")
@Component
class OpenFeignGitHubClient implements GitHubClient {

    private final OpenFeignClient client;

    @Autowired
    OpenFeignGitHubClient(OpenFeignClient client) {
        this.client = client;
    }

    @Override
    public GitHubUserInfoDTO getInfo(String nick) {
        return client.get(nick);
    }

}
