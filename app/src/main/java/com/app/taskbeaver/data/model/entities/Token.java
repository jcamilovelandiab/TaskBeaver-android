package com.app.taskbeaver.data.model.entities;

/**
 * @author Camilo Velandia
 */
public class Token
{
    String accessToken;

    public Token(){}

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken( String accessToken )
    {
        this.accessToken = accessToken;
    }

    @Override
    public String toString(){
        return "Token[accessToken="+accessToken+"]";
    }

}