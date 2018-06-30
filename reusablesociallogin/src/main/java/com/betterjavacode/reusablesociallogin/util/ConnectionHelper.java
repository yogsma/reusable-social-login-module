package com.betterjavacode.reusablesociallogin.util;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.google.api.Google;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.twitter.api.Twitter;

public class ConnectionHelper
{
    public static ConnectionType getConnectionType(Connection<?> connection)
    {
        Object api = connection.getApi();

        if (api instanceof Twitter)
        {
            return ConnectionType.TWITTER;
        }
        else if (api instanceof Facebook)
        {
            return ConnectionType.FACEBOOK;
        }
        else if (api instanceof Google)
        {
            return ConnectionType.GOOGLE;
        }
        else if (api instanceof GitHub)
        {
            return ConnectionType.GITHUB;
        }
        else if (api instanceof LinkedIn)
        {
            return ConnectionType.LINKEDIN;
        }
        else
        {
            throw new RuntimeException("Unknown API!");
        }
    }
}
