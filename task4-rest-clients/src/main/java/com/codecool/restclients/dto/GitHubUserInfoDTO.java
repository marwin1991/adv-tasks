package com.codecool.restclients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubUserInfoDTO {
    private String login;
    private String name;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("public_repos")
    private int publicRepos;
}
