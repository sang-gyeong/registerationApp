package org.techtown.registeration;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class StatisticsCourseListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;
    private String userID = MainActivity.userID;


    public StatisticsCourseListAdapter(Context context, List<Course> courseList, Fragment parent) {
        this.context = context;
        this.courseList = courseList;
        this.parent = parent;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.statistics, null);
        TextView courseGrade = (TextView) v.findViewById(R.id.courseGrade);
        TextView courseTitle = (TextView) v.findViewById(R.id.courseTitle);
        TextView courseDivide = (TextView) v.findViewById(R.id.courseDivide);
        TextView coursePersonnel = (TextView) v.findViewById(R.id.coursePersonnel);
        TextView courseRate = (TextView) v.findViewById(R.id.courseRate);

        if (courseList.get(i).getCourseGrade().equals("제한 없음") || courseList.get(i).getCourseGrade().equals("")) {
            courseGrade.setText("모든 학년");
        } else {
            courseGrade.setText(courseList.get(i).getCourseGrade() + "학년");
        }
        courseTitle.setText(courseList.get(i).getCourseTitle());
        courseDivide.setText(courseList.get(i).getCourseDivide() + "분반");
        if (courseList.get(i).getCoursePersonnel() == 0) {
            coursePersonnel.setText("인원 제한 없음");
            courseRate.setText("");
        } else {
            coursePersonnel.setText("신청인원: " + courseList.get(i).getCourseRival() + "/" + courseList.get(i).getCoursePersonnel());
            int rate = ((int) (((double) courseList.get(i).getCourseRival() * 100 / courseList.get(i).getCoursePersonnel()) + 0.5)); //0.5를 더해서 반올림이 되도록 함
            courseRate.setText("경쟁률: " + rate + "%");
            if (rate < 20)
            { //경쟁률이 낮음
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorSafe));
            } else if (rate <= 50)
            { //경쟁률이 좀더 높음
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorWarning));
            } else if (rate <= 100)
            { //경쟁률이 높음
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorOrange));
            } else if (rate <= 150)
            { //경쟁률이 위험
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorRed));
            } else
                { //경쟁률 폭발
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorDanger));
            }
        }

        v.setTag(courseList.get(i).getCourseID());

        //삭제버튼 이벤트 추가

        Button deleteButton = (Button)v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try
                            {
                                JSONObject jsonResponse = new JSONObject(response);
                                Boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                    AlertDialog dialog = builder.setMessage("강의가 삭제되었습니다.")
                                            .setPositiveButton("확인", null)
                                            .create();
                                    dialog.show();

                                   StatisticsFragment.totalCredit -= courseList.get(i).getCourseCredit();
                                   StatisticsFragment.credit.setText(StatisticsFragment.totalCredit + "학점");
                                   courseList.remove(i);
                                   notifyDataSetChanged();

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                    AlertDialog dialog = builder.setMessage("강의 삭제에 실패하였습니다.")
                                            .setNegativeButton("다시 시도", null)
                                            .create();
                                    dialog.show();
                                }
                            }
                            catch (Exception e)
                            {

                                e.printStackTrace();
                            }
                        }

                    };
                    DeleteRequest deleteRequest = new DeleteRequest(userID, courseList.get(i).getCourseID() + "", responseListener);
                    RequestQueue queue = Volley.newRequestQueue(parent.getActivity());
                    queue.add(deleteRequest);

            }

        });

        return v;
    }

}
