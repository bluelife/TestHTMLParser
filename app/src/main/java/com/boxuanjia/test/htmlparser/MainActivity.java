package com.boxuanjia.test.htmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String LOGIN_URL = "http://12iphone.mobi";

    private String account = "cheersgo";

    private String password = "iE6jXfB";

    private AsyncHttpClient client;

    private static final String LOCATION = "Location";

    private String baseUrl;

    private String lastUrl;

    private String url;

    private String id;

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.text_content);
        // 初始化
        init();
        // 获得地址
        getUrl();
    }

    private void init() {
        client = new AsyncHttpClient();
        client.setEnableRedirects(false);
    }

    private void getUrl() {
        client.get(LOGIN_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("getUrl", "onSuccess");
                for (Header header : headers) {
                    Log.d("getUrl", header.getName());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("getUrl", "onFailure");
                for (Header header : headers) {
                    Log.d("getUrl", header.getName());
                    if (header.getName().equals(LOCATION)) {
                        Log.d("getUrl", header.getValue());
                        url = header.getValue();
                        break;
                    }
                }
                getUrlWithQueryString();
            }
        });
    }

    private void getUrlWithQueryString() {

        client.post(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Document doc = Jsoup.parse(responseString);
                Log.d("requestLogin", doc.outerHtml());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Document doc = Jsoup.parse(responseString);
                Log.d("getUrlWithQueryString", doc.outerHtml());
                Element formEle = doc.getElementById("frmLogin");
                Log.d("getUrlWithQueryString", formEle.attr("action"));
                id = formEle.attr("action").replace("default.aspx", "");
                baseUrl = url.replace("default.aspx", "");
                lastUrl = url;
                url = url + id;
                Log.d("getUrlWithQueryString", url);
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        RequestParams params = new RequestParams();
        client.addHeader("Host", "12iphone.mobi");
        client.addHeader("Content-Length", "120");
        client.addHeader("Cache-Control", "max-age=0");
        client.addHeader("Origin", "12iphone.mobi");
        client.addHeader("Upgrade-Insecure-Requests", "1");
        client.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        client.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=GBK; charset=UTF-8");
        client.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        client.addHeader("Referer", lastUrl);
        client.addHeader("Accept-Encoding", "gzip, deflate");
        client.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        params.put("__EVENTTARGET", "");
        params.put("__EVENTARGUMENT", "");
        params.put("txtUsername", account);
        params.put("txtPassword", password);
        params.put("cmdCSlogin", "简体中文");
        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Document doc = Jsoup.parse(responseString);
                Log.d("requestLogin", doc.outerHtml());
            }
        });
    }

    private void onClickOK() {

    }

}
