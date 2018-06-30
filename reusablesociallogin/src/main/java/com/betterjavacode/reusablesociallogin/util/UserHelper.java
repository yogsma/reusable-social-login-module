package com.betterjavacode.reusablesociallogin.util;

import com.betterjavacode.reusablesociallogin.entity.User;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.google.api.Google;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

@Component
public class UserHelper
{
    public User getUser(Connection<?> connection)
    {
        User user = null;

        //get the connection type
        ConnectionType type = ConnectionHelper.getConnectionType(connection);

        if (type.equals(ConnectionType.TWITTER)) {
            user = getTwitterUser(connection);
        } else if (type.equals(ConnectionType.FACEBOOK)) {
            user = getFacebookUser(connection);
        } else if (type.equals(ConnectionType.GOOGLE)) {
            user = getGoogleUser(connection);
        } else if (type.equals(ConnectionType.GITHUB)) {
            user = getGithubUser(connection);
        } else if (type.equals(ConnectionType.LINKEDIN)){
            user = getLinkedInUser(connection);
        }

        return user;
    }

    private User getTwitterUser(Connection<?> connection)
    {
        User user = new User();
        Twitter twitterApi = (Twitter)connection.getApi();

        String name = twitterApi.userOperations().getUserProfile().getName();

        user.setName(name);

        return user;
    }

    private User getFacebookUser(Connection<?> connection)
    {
        User user = new User();
        Facebook facebookApi = (Facebook)connection.getApi();
        String [] fields = { "name" };
        User userProfile = facebookApi.fetchObject("me", User.class, fields);

        String name = userProfile.getName();

        user.setName(name);

        return user;
    }

    private User getGoogleUser(Connection<?> connection)
    {
        User user = new User();
        Google googleApi = (Google) connection.getApi();
        String name = googleApi.plusOperations().getGoogleProfile().getDisplayName();
        user.setName(name);
        return user;
    }

    private User getGithubUser(Connection<?> connection)
    {
        User user = new User();
        GitHub githubApi = (GitHub) connection.getApi();
        String name = githubApi.userOperations().getUserProfile().getName();
        user.setName(name);
        return user;
    }

    private User getLinkedInUser(Connection<?> connection)
    {
        User user = new User();
        LinkedIn linkedInApi = (LinkedIn) connection.getApi();
        String name = linkedInApi.profileOperations().getUserProfile().getFirstName();
        user.setName(name);
        return user;
    }
}
