package com.sma.demo.trans;


import com.sma.demo.trans.data.Config;
import com.sma.demo.trans.data.Language;
import com.sma.demo.trans.doc.DocTranslate;
import com.sma.demo.trans.http.HttpStringCallback;

public class Main {

    public static void main(String[] args) {
        // demo仅供测试，文档翻译调用需要花钱
        Config config = new Config(Const.APPID, Const.SECRET_KEY);
        config.lang(Language.ZH, Language.EN);
        config.file(Const.FILE_PATH);

        DocTranslate docTranslate = new DocTranslate();
        docTranslate.setConfig(config);


//        docTranslate.docCount(new HttpStringCallback() {
//            @Override
//            protected void onSuccess(String response) {
//                super.onSuccess(response);
//                System.out.println("response:" + response);
//            }
//
//            @Override
//            protected void onFailure(Throwable e) {
//                super.onFailure(e);
//            }
//        });

        docTranslate.docTrans(new HttpStringCallback() {


            @Override
            protected void onSuccess(String response) {
                super.onSuccess(response);
                System.out.println("response:" + response);
            }

            @Override
            protected void onFailure(Throwable e) {
                super.onFailure(e);
            }
        });


    }
}
