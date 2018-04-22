package com.pramudana.sam.edubanten.loginregister;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pramudana.sam.edubanten.MainActivity;
import com.pramudana.sam.edubanten.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MyFuction {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener listener;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        auth =FirebaseAuth.getInstance();

        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user =firebaseAuth.getCurrentUser();
                if (user !=null){
                    if (user.isEmailVerified()){
                        myToast("selamat anda berhasil login"+ user.getEmail());
                        myIntent(MainActivity.class);
                        finish();
                    }else {
                        myToast("gagal login\n periksa email anda untuk verifikas");
                        myIntent(RegisterActivity.class);
                        FirebaseAuth.getInstance().signOut();
                        finish();
                    }
                }
            }
        };
    }

    @OnClick({R.id.btn_login , R.id.btn_signup})
    public void onViewClicked(View view) {
        final String em=email.getText().toString();
        String pw=password.getText().toString();
        switch (view.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(em)) {
                    email.setError("email harus diisi");
                    email.requestFocus();
                    myanimation(email);
                } else if (TextUtils.isEmpty(pw)) {
                    password.setError("passowrd harus diisi");
                    password.requestFocus();
                    myanimation(password);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    auth.signInWithEmailAndPassword(em,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()){
                                myIntent(MainActivity.class);
                                finish();
                            }else{
                                myToast("gagal login "+task.getException());
                            }
                        }
                    });
                }

                 break;
            case R.id.btn_signup:
                myIntent(RegisterActivity.class);
                break;
        }
    }

    //authentication selalu ada on start on stop
    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(listener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (listener!=null){
            auth.removeAuthStateListener(listener);
        }
    }

    public void onKlikRegisters(View view) {
        myIntent(RegisterActivity.class);
    }
}