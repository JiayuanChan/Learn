package com.adrian.own.learn;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/23 09:01
 * Des：
 */
public class MainItem implements Parcelable {

    private String title;
    private Class<?> activity;
    private int imageResource;
    private String link;
    private String className;

    public MainItem() {
    }


    protected MainItem(Parcel in) {
        title = in.readString();
        imageResource = in.readInt();
        link = in.readString();
        className = in.readString();
    }

    public static final Creator<MainItem> CREATOR = new Creator<MainItem>() {
        @Override
        public MainItem createFromParcel(Parcel in) {
            return new MainItem(in);
        }

        @Override
        public MainItem[] newArray(int size) {
            return new MainItem[size];
        }
    };

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getActivity() {
        if (!TextUtils.isEmpty(className) && !TextUtils.equals("null", className)) {
            Class clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return clazz;
        }
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(imageResource);
        dest.writeString(link);
        dest.writeString(className);
    }
}
