package com.example.tiktok;

import android.net.Uri;

public class Model {
    private Uri url;

    public Model(Uri url) {
        this.url = url;
    }

    public Uri getUrl() {
        return url;
    }
}
