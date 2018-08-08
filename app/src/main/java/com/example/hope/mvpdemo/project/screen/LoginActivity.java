package com.example.hope.mvpdemo.project.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hope.mvpdemo.R;
import com.example.hope.mvpdemo.project.screen.model.LoginResponse;
import com.example.hope.mvpdemo.project.util.StringUtil;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button btnSubmit;
    String email, pass;
    ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        btnSubmit = findViewById(R.id.email_sign_in_button);
        btnSubmit.setOnClickListener(this);
        init();
    }

    @Override
    public void init() {
        presenter = new LoginPresenter(this);
    }

    @Override
    public void submitLogin() {
        if (presenter.validate(email, pass)){
            showProgress();
            presenter.callLoginApi(email, pass);
        }

        else
            Toast.makeText(this, "please enter required inputs", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errMsg(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginRes(LoginResponse loginRes) {
        if (loginRes != null && StringUtil.isValidString(loginRes.getMessage())) {
            Toast.makeText(this, loginRes.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                email = mEmailView.getText().toString();
                pass = mPasswordView.getText().toString();
                submitLogin();
                break;
        }
    }
}

