package org.techtown.registeration;

import android.content.Context;

public class Schedule {

    private String monday[] = new String[14];
    private String tuesday[] = new String[14];
    private String wednesday[] = new String[14];
    private String thursday[] = new String[14];
    private String friday[] = new String[14];

    public Schedule(){ //생성자에서 초기화
        for (int i=0; i<14; i++){
            monday[i] = "";
            tuesday[i] = "";
            wednesday[i] = "";
            thursday[i] = "";
            friday[i] = "";

        }
    }//스케쥴 정보를 담는 특성한 데이터가 있을 때 데이터를 파싱해서 강의정보가 들어가는 배열에 넣어줄 수 잇도록 함
    public void addSchedule(String scheduleText) {
        int temp;
        //월:[3][4][5] 화:[4][5] '월'이라는 데이터를 기준으로 파싱.
        if ((temp = scheduleText.indexOf("월")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("수")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("목")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("금")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
    }

    //추가하려는 스케쥴이 현재 선택된 스케쥴과 중복되지 않는지 검사
    public boolean validate(String scheduleText){
        if(scheduleText.equals("")){
            return true;
        }
        int temp;
        if ((temp = scheduleText.indexOf("월")) > -1) {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    //현재값이 공백이 아니라면 (중복이라면)
                    if (!monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")){
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    //현재값이 공백이 아니라면 (중복이라면)
                    if (!tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")){
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("수")) > -1) {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    //현재값이 공백이 아니라면 (중복이라면)
                    if (!wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")){
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("목")) > -1) {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    //현재값이 공백이 아니라면 (중복이라면)
                    if (!thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")){
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("금")) > -1) {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    //현재값이 공백이 아니라면 (중복이라면)
                    if (!friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void addSchedule( String scheduleText, String courseTitle, String courseProfessor) {
        String professor;
        if(courseProfessor.equals("")){
            professor = "";
        }else{
            professor = "(" + courseProfessor + ")";
        }
        int temp;
        //월:[3][4][5] 화:[4][5] '월'이라는 데이터를 기준으로 파싱.
        if ((temp = scheduleText.indexOf("월")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("수")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("목")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("금")) > -1) {  //temp안에 월이라는 단어가 포함되어있을 때 스케쥴 텍스트에 그 위치를 반환
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i=temp ; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++){ //괄호사이 숫자를 파싱
                if (scheduleText.charAt(i)=='['){
                    startPoint = i;
                }
                if(scheduleText.charAt(i)==']'){
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
    }
    //실제 텍스트 뷰에 해당 강의목록들을 보여줄 수 있도록 세팅하는 함수
    public void setting(AutoResizeTextView[]monday, AutoResizeTextView[]tuesday, AutoResizeTextView[]wednesday, AutoResizeTextView[]thursday, AutoResizeTextView[]friday, Context context){
        int maxLength = 0; //가나다라마바사아자차를 넣는 편법보다는 가장 긴 텍스트를 넣어줄 것
        String maxString = "";
        for (int i=0; i<14; i++){
            if(this.monday[i].length()>maxLength){
                maxLength = this.monday[i].length();
                maxString = this.monday[i];
            }
            if(this.tuesday[i].length()>maxLength){
                maxLength = this.tuesday[i].length();
                maxString = this.tuesday[i];
            }
            if(this.wednesday[i].length()>maxLength){
                maxLength = this.wednesday[i].length();
                maxString = this.wednesday[i];
            }
            if(this.thursday[i].length()>maxLength){
                maxLength = this.thursday[i].length();
                maxString = this.thursday[i];
            }
            if(this.friday[i].length()>maxLength){
                maxLength = this.friday[i].length();
                maxString = this.friday[i];
            }
        }
        for (int i=0; i<14; i++){
            if(!this.monday[i].equals("")){
                monday[i].setText(this.monday[i]);
                monday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }else{//가나다라마바사아자차를 넣을 수도 있음. 비어있을 경우, 적절한 크기를 가질 수 있도록 (일종의 편법)
                monday[i].setText(maxString);
            }

            if(!this.tuesday[i].equals("")){
                tuesday[i].setText(this.tuesday[i]);
                tuesday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else{
                tuesday[i].setText(maxString);
            }

            if(!this.wednesday[i].equals("")){
                wednesday[i].setText(this.wednesday[i]);
                wednesday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else{
                wednesday[i].setText(maxString);
            }

            if(!this.thursday[i].equals("")){
                thursday[i].setText(this.thursday[i]);
                thursday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else{
                thursday[i].setText(maxString);
            }
            if(!this.friday[i].equals("")){
                friday[i].setText(this.friday[i]);
                friday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else{
                friday[i].setText(maxString);
            }

            monday[i].resizeText();
            tuesday[i].resizeText();
            wednesday[i].resizeText();
            thursday[i].resizeText();
            friday[i].resizeText(); //텍스트뷰 크기에 맞추기
        }
    }
}
