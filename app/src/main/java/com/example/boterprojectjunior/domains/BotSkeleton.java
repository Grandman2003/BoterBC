package com.example.boterprojectjunior.domains;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class BotSkeleton implements Parcelable {
    String BOT_NAME;
    String BOT_TOKEN;
    String script;
    //ArrayList<Bot_Functions> functions=new ArrayList<Bot_Functions>();

    public BotSkeleton( String BOT_API_KEY,String botName,String script) {
        this.BOT_NAME = botName;
        this.BOT_TOKEN = BOT_API_KEY;
        this.script=script;
    }

    protected BotSkeleton(Parcel in) {
        BOT_NAME = in.readString();
        BOT_TOKEN = in.readString();
        script = in.readString();
    }

    public static final Creator<BotSkeleton> CREATOR = new Creator<BotSkeleton>() {
        @Override
        public BotSkeleton createFromParcel(Parcel in) {
            return new BotSkeleton(in);
        }

        @Override
        public BotSkeleton[] newArray(int size) {
            return new BotSkeleton[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle=new Bundle();
        bundle.putString("BOT_NAME",BOT_NAME);
        bundle.putString("BOT_TOKEN",BOT_TOKEN);
        bundle.putString("script",script);
        dest.writeBundle(bundle);
    }
}
