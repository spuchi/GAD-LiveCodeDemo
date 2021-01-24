package com.example.gad.livedemoapp.domain.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("UnusedDeclaration")
public class Task
{
    @SerializedName("title")
    private String  mTitle;

    @SerializedName("desc")
    private String  mDescription;

    @SerializedName("date_due")
    private long    mDateDue;

    @SerializedName("completed")
    private boolean mCompleted;

    //region SETTERS
    public void setTitle       (String  value) { mTitle         = value; }
    public void setDescription (String  value) { mDescription   = value; }
    public void setDateDue     (long    value) { mDateDue       = value; }
    public void setCompleted   (boolean value) { mCompleted     = value; }
    //endregion

    //region GETTERS
    public String  getTitle       () { return mTitle;       }
    public String  getDescription () { return mDescription; }
    public long    getDateDue     () { return mDateDue;     }
    public boolean getCompleted   () { return mCompleted;   }
    //endregion
}
