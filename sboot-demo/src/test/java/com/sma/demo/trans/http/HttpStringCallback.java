package com.sma.demo.trans.http;

import java.io.IOException;

import com.sma.demo.trans.utils.TextUtils;
import okhttp3.Call;
import okhttp3.Response;

public abstract class HttpStringCallback extends HttpCallback<String> {
    @Override
    public final void onResponse(Call call, Response response) throws IOException {
        super.onResponse(call, response);
        if (!response.isSuccessful()) {
            sendFailureMessage(new IOException("Response status code:" + response.code()));
        } else {
            String text = response.body().string();
            if (TextUtils.isEmpty(text)) {
                sendFailureMessage(new IOException("Response text is empty!"));
            } else {
                sendSuccessMessage(text);
            }
        }
        response.close();
    }

}
