# 第一次初始化，主要是平时学的知识点总结在一块

## 1.volley网络框架的学习

1.加入网络权限

`<uses-permission android:name="android.permission.INTERNET"/>`

2.add app/build.gradle `compile 'com.mcxiaoke.volley:library:1.0.19'`

`dependencies {    compile fileTree(dir: 'libs', include: ['*.jar'])    testCompile 'junit:junit:4.12'    compile 'com.android.support:appcompat-v7:23.3.0'    compile 'com.mcxiaoke.volley:1.0.19'}`

rebuild project;

3.创建Application

`public class MyApplication extends Application {    private static RequestQueue queue;    @Override    public void onCreate() {        super.onCreate();        queue = Volley.newRequestQueue(this);    }    public static <T> void add2Queue(Object tag, Request<T> request){        request.setTag(tag);        queue.add(request);    }}`

并在AndroidManifest.xml注册Application

`<application    android:name=".MyApplication" ...`

4.使用

`private void volley_get_json() {    MyApplication.add2Queue("MainActivity_json_req",new JsonObjectRequest(Request.Method.POST,            Constant.URL_SERVER + "/user",            "",            new Response.Listener<JSONObject>() {                @Override                public void onResponse(JSONObject response) {                    textView.setText(response.toString());                }            }, new Response.ErrorListener() {        @Override        public void onErrorResponse(VolleyError error) {            textView.setText(error.getMessage());        }    }));}`