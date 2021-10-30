package com.codecool.marwin1991.secuirty.oauth.user;

import com.codecool.marwin1991.exception.OAuth2AuthenticationProcessingException;
import com.codecool.marwin1991.model.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes){
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())){
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException(registrationId + " is not supproted!");
        }
    }
}
