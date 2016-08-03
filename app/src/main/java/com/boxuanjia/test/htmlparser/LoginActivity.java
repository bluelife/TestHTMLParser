package com.boxuanjia.test.htmlparser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boxuanjia.test.htmlparser.model.login.Login;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cz.msebera.android.httpclient.Header;

/**
 * Created by boxuanjia on 16/7/27.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String PRE_USER_INFO = "PRE_USER_INFO";

    private static final String USER_INFO = "USER_INFO";

    private static final String URL_LOGIN = "http://m.10bet100.com/pagemethods.aspx/Login";

    private static final String PARAMS_ACCOUNT = "__userName";

    private static final String PARAMS_PASSWORD = "password";

    private EditText mEditAccount;

    private EditText mEditPassword;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditAccount = (EditText) findViewById(R.id.edit_account);
        mEditPassword = (EditText) findViewById(R.id.edit_password);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(false);
        SharedPreferences sharedPreferences = getSharedPreferences(PRE_USER_INFO, MODE_PRIVATE);
        String userInfo = sharedPreferences.getString(USER_INFO, "");
        Gson gson = new Gson();
        Login login = gson.fromJson(userInfo, Login.class);
        if (login != null) {
            mEditAccount.setText(login.getAccount());
            mEditPassword.setText(login.getPassword());
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        mDialog.show();
        RequestParams params = new RequestParams();
        params.put(PARAMS_ACCOUNT, mEditAccount.getText().toString());
        params.put(PARAMS_PASSWORD, mEditPassword.getText().toString());
        ((MyApplication) getApplication()).getClient().post(URL_LOGIN, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                mDialog.dismiss();
                Log.d("getUserInfo", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getUserInfo", doc.outerHtml());
                if (responseString.equals("[]")) {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences(PRE_USER_INFO, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Login login = new Login();
                login.setAccount(mEditAccount.getText().toString());
                login.setPassword(mEditPassword.getText().toString());
                Gson gson = new Gson();
                editor.putString(USER_INFO, gson.toJson(login)).apply();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                mDialog.dismiss();
                Log.d("getUserInfo", "onFailure");
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
