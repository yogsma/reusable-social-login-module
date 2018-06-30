package com.betterjavacode.reusablesociallogin.social;

import com.betterjavacode.reusablesociallogin.entity.User;
import com.betterjavacode.reusablesociallogin.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class SocialConnectionSignup implements ConnectionSignUp
{
    @Autowired
    UserHelper userHelper;

    @Override
    public String execute(Connection<?> connection)
    {
        User user = userHelper.getUser(connection);

        return user.getName();
    }
}
