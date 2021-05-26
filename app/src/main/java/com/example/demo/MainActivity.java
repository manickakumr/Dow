//package com.example.demo;
//
//import android.annotation.SuppressLint;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.android.volley.RequestQueue;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//    static final String EXTRA_SPEC = "specializationid";
//    static final String EXTRA_SPEC1 = "Specialization1";
//    static final String EXTRA_STATE = "State_name";
//    static final String EXTRA_CITY = "Country_name";
//    static final String EXTRA_EXCEPSAL = "expectsal";
//    static final String EXTRA_EXP = "experience";
//    static final String EXTRA_NOTICE = "noticep";
//    private static final String EXTRA_EMAIL = "email";
//    static final String EXTRA_PROFILE = "Profile";
//    private static final String EXTRA_ID = "CandidateId";
//    static final String EXTRA_COMP = "CompanyName";
//    static final String EXTRA_CANID = "canid";
//    static final String EXTRA_CONCANID = "ConnectCandidateId";
//    static final String EXTRA_CONSTU = "ConnectStatus";
//    static final String EXTRA_CONID = "ConnectionId";
//    static final String EXTRA_DES = "Description";
//    static final String EXTRA_SDATE = "StartDate";
//    static final String EXTRA_EDATE = "EndDate";
//    static final String EXTRA_SKILLS = "Skills";
//    static final String EXTRA_UNI = "CollegeName";
//    static final String EXTRA_DEGREE = "Graduate";
//    static final String EXTRA_COURCE = "CourseName";
//    static final String EXTRA_STPEORI = "Startperiod";
//    static final String EXTRA_ENPEORI = "Endperiod";
//    static final String EXTRA_SALARY = "ExpectedSalary";
//    static final String EXTRA_CURRENCY = "Currency";
//    static final String EXTRA_EXPERIENCE = "Experience";
//    static final String EXTRA_AVALIABLE = "NoticePeriod";
//    public static final String desc = "Description:";
//    private TextView email;
//    LinearLayout linearLayout;
//    private String a, c;
//    public static final String TAG_NAME = "email";
//    public static final String ID = "CandidateId";
//    private String URLline1 = "http://dowtechie.com/career/dev/api/profile/get_id";
//    private String jsonURL = "http://dowtechie.com/career/dev/api/profile/update?em=" + email;
//    private final int jsoncode = 1;
//    private final int jsoncode1 = 1;
//    private String Description = "Description";
//    private static final String TAG_USERS = "email";
//    private TextView fname, lname, email1, id;
//    private RequestQueue rQueue;
//    //    private Button menuItem1;
//    private Button btnregister;
//    private TextView tvlogin;
//    SharedPreferences prf;
//    SharedPreferences pref;
//    Intent intent;
//    private Menu menu;
//    private RecyclerView recyclerView, count;
//    ArrayList<ModelView> rogerModelArrayList;
//    ArrayList<ModelView> filtr;
//    private AdapterClass rogerAdapter;
//    private static ProgressDialog mProgressDialog;
//    Button btn1, btn2, btn3;
//    //    private boolean loading = true;
//    private TextView tv;
//    private View badge;
//    //    private boolean loading = true;
//    private int pagenumber = 10;
//    //private   LinearLayoutManager mLayoutManager;
////    private int previousTotal = 0;
//    private boolean loading = true;
//    //    private int visibleThreshold = 10;
////    int firstVisibleItem, visibleItemCount, totalItemCount;
////pager
//    private int page = 1, limit = 15;
//    private int firstVisibleItem, visibleItemCount, totalItemCount, pastVisibleItems;
//    private int previousTotal = 0;
//    private int visibleThreshold = 10;
//    private RecyclerView.LayoutManager layoutManager;
//    private RecyclerView.Adapter adapter;
//    private int requestCount = 1;
//    //pagination
//    //    int limit = 10;
////    int offset = 0;
//    private String requesturl = "http://www.dowtechie.com/test/career/api/api/list2/";
//    private ImageView log;
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.list);
//        rogerModelArrayList = new ArrayList<>();
//        rogerAdapter = new AdapterClass(this, rogerModelArrayList);
//        recyclerView.setAdapter(rogerAdapter);
////        fetchJSON();
//
//
//    }
//
//}