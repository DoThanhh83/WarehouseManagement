package com.example.warehousemanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import okhttp3.*;

public class DangNhap extends AppCompatActivity {

//    private EditText editTextEmail;
//    private EditText editTextPassword;
//    private Button buttonLogin;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        editTextEmail = (EditText) findViewById(R.id.emailSignIn);
//        editTextPassword =(EditText) findViewById(R.id.password);
//        buttonLogin = findViewById(R.id.Login);
//
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Lấy dữ liệu từ EditText
//                String email = editTextEmail.getText().toString();
//                String password = editTextPassword.getText().toString();
//
//                // Tạo JSON object chứa dữ liệu đăng nhập
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("username", email);
//                    jsonObject.put("password", password);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                 //////
//                // Thực hiện yêu cầu POST API bằng AsyncTask
//                new LoginTask().execute(jsonObject.toString());
//            }
//        });
//    }
//
//    private class LoginTask extends AsyncTask<String, Void, String> {
//
//
//        @Override
//        protected String doInBackground(String... params) {
//            String urlString = "http://14.225.211.190:4001/api/auth/login";
//
//            try {
//                URL url = new URL(urlString);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                // Cấu hình yêu cầu POST
//                connection.setRequestMethod("POST");
////                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEwNSIsInVzZXJuYW1lIjoidGhhbmhudi5nciIsImVtYWlsIjoidGhhbmhudi5nckBnbWFpbC5jb20iLCJhY3RpdmUiOnRydWUsInZlcmlmaWVkIjp0cnVlLCJyb2xlcyI6WyJhZG1pbiJdLCJ0ZW5hbnRJZCI6bnVsbCwiZ3JhbnRlZFRlbmFudHMiOm51bGwsImlhdCI6MTY1MzczMjU1MCwiZXhwIjoxNzQwMTMyNTUwfQ.NFvZRwE01vgnm_RkUKXQODeMQ0uRAZrIEMePkrImCT0";
////                connection.setRequestProperty("Authorization", "Bearer " + token);
//
//                // Ghi dữ liệu JSON vào body của yêu cầu
//                String jsonInputString = params[0];
//                OutputStream outputStream = connection.getOutputStream();
//                outputStream.write(jsonInputString.getBytes());
//                outputStream.flush();
//                outputStream.close();
//
//                // Đọc phản hồi từ máy chủ
//                InputStream inputStream = connection.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                StringBuilder response = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//                reader.close();
//                connection.disconnect();
//        System.out.println(response);
//                return response.toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String response) {
//            if (response != null) {
//                // Xử lý phản hồi từ máy chủ
//                try {
//                    JSONObject jsonResponse = new JSONObject(response);
//                    String success = jsonResponse.getString("201");
//                    String message = jsonResponse.getString("message");
//
//                    if (success == "201") {
//                        // Đăng nhập thành công
//                        Toast.makeText(DangNhap.this, "Login successful", Toast.LENGTH_SHORT).show();
//                        // Chuyển sang TrangChuActivity
//                        Intent intent = new Intent(DangNhap.this, TrangChu.class);
//                        startActivity(intent);
//                        finish();
//                    } else {
//                        // Đăng nhập thất bại
//                        Toast.makeText(DangNhap.this, "Login failed: " + message, Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Toast.makeText(DangNhap.this, "Error occurred", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ các EditText
        editTextEmail = findViewById(R.id.emailSignIn);
        editTextPassword = findViewById(R.id.password);

         buttonLogin = findViewById(R.id.Login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị email và password từ EditText
                String email = "string";
                String password = "string";

                // Gọi phương thức gửi yêu cầu POST API
                loginAPI(email, password);
            }
        });
    }

    private void loginAPI(String email, String password) {
        // Tạo JSON body
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", email);
            jsonBody.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Tạo request body
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonBody.toString());

        // Tạo yêu cầu POST
        Request request = new Request.Builder()
                .url("http://14.225.211.190:4001/api/auth/login")
                .post(requestBody)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEwNSIsInVzZXJuYW1lIjoidGhhbmhudi5nciIsImVtYWlsIjoidGhhbmhudi5nckBnbWFpbC5jb20iLCJhY3RpdmUiOnRydWUsInZlcmlmaWVkIjp0cnVlLCJyb2xlcyI6WyJhZG1pbiJdLCJ0ZW5hbnRJZCI6bnVsbCwiZ3JhbnRlZFRlbmFudHMiOm51bGwsImlhdCI6MTY1MzczMjU1MCwiZXhwIjoxNzQwMTMyNTUwfQ.NFvZRwE01vgnm_RkUKXQODeMQ0uRAZrIEMePkrImCT0")
                .build();

        // Tạo OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Thực hiện yêu cầu bất đồng bộ
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Xử lý khi gặp lỗi
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Xử lý khi nhận được phản hồi từ server
                String responseData = response.body().string();
                        // Chuyển sang TrangChuActivity
                        Intent intent = new Intent(DangNhap.this, TrangChu.class);
                        startActivity(intent);


                // Tiếp tục xử lý dữ liệu phản hồi từ server
            }
        });
    }
}
