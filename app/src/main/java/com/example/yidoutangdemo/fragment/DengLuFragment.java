package com.example.yidoutangdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.ui.LogingActivity;
import com.example.yidoutangdemo.ui.ZhuCeActivity;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * Created by 天一 on 2016/10/31.
 */
public class DengLuFragment extends BaseFragment implements View.OnClickListener, PlatformActionListener, CompoundButton.OnCheckedChangeListener {
    private ImageView wechat;
    private ImageView qq;
    private ImageView weibo;
    private ImageView douban;

    private EditText accountEditText, passwordEditText;
    private CheckBox rememberBox;
    private TextView zhuCeTextView;
    private Button loginButton;
    // 输入的帐号密码信息
    private String account = "";
    private String password = "";

    // 模拟服务端待验证的帐号密码信息
    private final String ACCOUNT = "admin";
    private final String PASSWORD = "admin";

    // 用于记住帐号密码
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    // 是否记住帐号信息
    private boolean isRememberInfo;

    public DengLuFragment() {
    }

    public static DengLuFragment newInstance() {

        Bundle args = new Bundle();

        DengLuFragment fragment = new DengLuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.denglufragment,container,false);
        wechat= (ImageView) rootView.findViewById(R.id.fragment_denglu_wechat);
        qq= (ImageView) rootView.findViewById(R.id.fragment_denglu_qq);
        weibo= (ImageView) rootView.findViewById(R.id.fragment_denglu_weibo);
        douban= (ImageView) rootView.findViewById(R.id.fragment_denglu_douban);

        accountEditText = (EditText) rootView.findViewById(R.id.fragment_account_et);
        passwordEditText = (EditText) rootView.findViewById(R.id.fragment_password_et);
        rememberBox = (CheckBox) rootView.findViewById(R.id.fragment_remember_box);
        zhuCeTextView = (TextView) rootView.findViewById(R.id.fragment_zhuce_textview);
        zhuCeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ZhuCeActivity.class);
                startActivity(intent);
            }
        });
        loginButton = (Button) rootView.findViewById(R.id.fragment_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入的帐号密码信息
                account = accountEditText.getText().toString();
                password = passwordEditText.getText().toString();
                // 判断帐号密码是否正确
                if (ACCOUNT.equals(account) && PASSWORD.equals(password)) {
                    // 如果用户选择记住信息，则保存
                    if (isRememberInfo) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.commit();
                    }
                    Intent intent = new Intent(getActivity(),LogingActivity.class);
                    intent.putExtra("flag",true);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
                    editor.putBoolean("isRemember", false);
                    editor.commit();
                }
            }
        });
        rememberBox.setOnCheckedChangeListener(this);
        sharedPreferences = getContext().getSharedPreferences("user_info", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        // 如果上一次保存帐号信息，则下一次读取
        isRememberInfo = sharedPreferences.getBoolean("isRememberInfo", false);
        if (isRememberInfo) {
            account = sharedPreferences.getString("account", "");
            password = sharedPreferences.getString("password", "");
            accountEditText.setText(account);
            passwordEditText.setText(password);
            // 如果帐号未登录，则不记住信息
            if (!"".equals(account) && !"".equals(password)) {
                rememberBox.setChecked(true);
            }
        } else {
            // 如果上一次未记录帐号信息，清除旧数据
            editor.remove("account");
            editor.remove("password");
            editor.commit();
        }

        wechat.setOnClickListener(this);
        qq.setOnClickListener(this);
        weibo.setOnClickListener(this);
        douban.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_denglu_wechat:
                loginDeal(new Wechat(getActivity()));
                break;
            case R.id.fragment_denglu_qq:
                loginDeal(new QQ(getActivity()));
                break;
            case R.id.fragment_denglu_weibo:
                loginDeal(new SinaWeibo(getActivity()));
                break;
            case R.id.fragment_denglu_douban:
                Toast.makeText(getActivity(), "暂不支持", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDestroy() {
        ShareSDK.stopSDK();
        super.onDestroy();
    }
    private void loginDeal(Platform platform) {
        //通过网页来授权
        //platform.SSOSetting(true);
        String userId = platform.getDb().getUserId();
        if(!TextUtils.isEmpty(userId))//表示登录过
        {
            //直接跳转到成功的界面
        }
        else
        {
            platform.setPlatformActionListener(this);
            //要数据不要功能
            platform.showUser(null);
            //要功能，不要数据
            //platform.authorize();
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if(i == Platform.ACTION_AUTHORIZING)//要功能，不要数据
        {

        }
        else if(i == Platform.ACTION_USER_INFOR)//要数据，不要功能
        {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

            }
        }

    }
    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }
    @Override
    public void onCancel(Platform platform, int i) {

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isRememberInfo = isChecked;

        // 记录是否保存信息的状态
        editor.putBoolean("isRememberInfo", isRememberInfo);
//		// 如果不记住帐号信息，清除就数据
//		if () {
//
//		}
        editor.commit();
    }
}
