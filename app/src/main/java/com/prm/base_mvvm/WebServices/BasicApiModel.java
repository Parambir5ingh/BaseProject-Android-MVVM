/*
 * Copyright (c) 2017. Code by PRM . Happy coding
 */

package com.prm.base_mvvm.WebServices;

import com.google.gson.annotations.SerializedName;

public class BasicApiModel
{
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public boolean getStatus()
    {
        return status.equals(Web.Keys.SUCCESS);
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }


}
