package com.codecool.restclients.github;

import com.codecool.restclients.dto.GitHubUserInfoDTO;

public interface GitHubClient {

    GitHubUserInfoDTO getInfo(String nick);

    void createRepo(String name);

}
