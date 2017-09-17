package com.example.ary.mimobakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ary on 9/15/17.
 */





public class Steps implements Parcelable {
    private String id;

    private String shortDescription;

    private String description;

    private String videoURL;

    private String thumbnailURL;

    public Steps(){


    }

    public Steps( String stepsId, String rShortDesc, String rDesc, String rVideoUrl, String rThumbUrl){


        this.id=stepsId;
        this.shortDescription=rShortDesc;
        this.description=rDesc;
        this.videoURL=rVideoUrl;
        this.thumbnailURL=rThumbUrl;

    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getShortDescription ()
    {
        return shortDescription;
    }

    public void setShortDescription (String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getVideoURL ()
    {
        return videoURL;
    }

    public void setVideoURL (String videoURL)
    {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL ()
    {
        return thumbnailURL;
    }

    public void setThumbnailURL (String thumbnailURL)
    {
        this.thumbnailURL = thumbnailURL;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", shortDescription = " + shortDescription + ", description = " + description + ", videoURL = " + videoURL + ", thumbnailURL = " + thumbnailURL + "]";
    }
    protected Steps(Parcel in) {
        id = in.readString();
        shortDescription = in.readString();
        description = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }

        @Override
        public int describeContents() {
        return 0;
    }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(shortDescription);
        dest.writeString(description);
        dest.writeString(videoURL);
        dest.writeString(thumbnailURL);
    }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Steps> CREATOR = new Parcelable.Creator<Steps>() {
            @Override
            public Steps createFromParcel(Parcel in) {
                return new Steps(in);
            }

            @Override
            public Steps[] newArray(int size) {
                return new Steps[size];
            }
        };
    }