package com.codecool.restclients.openfeign;

import com.codecool.restclients.dto.GitHubUserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "github", url = "https://api.github.com/")
public interface OpenFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/{nick}")
    GitHubUserInfoDTO get(@PathVariable String nick);

}