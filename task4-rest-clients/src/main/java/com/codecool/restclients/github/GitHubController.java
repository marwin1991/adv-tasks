package com.codecool.restclients.github;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GitHubController {

    private final GitHubClient client;

    @Autowired
    public GitHubController(GitHubClient client) {
        this.client = client;
    }

    @GetMapping("${info-path}/{nick}")
    public GitHubUserInfoDTO getInfo(@PathVariable String nick){
        log.info("Passed nick: " + nick);
        return client.getInfo(nick);
    }

}
