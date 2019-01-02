package com.Study.mvcStudy;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class DbManager {

    static    String driver  ;
    static    String url     ;
    static    String uId;
    static    String uPwd      ;

    static    Connection          conn =null;
    static    PreparedStatement   pstmt = null;
    static    ResultSet           rs;
    static Scanner sc = new Scanner(System.in);

    public static void main (String... args){
        Date dataInfo= new Date();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = transFormat.format(dataInfo);
        try {
            Class.forName(driver);
            conn=   DriverManager.getConnection(url, uId, uPwd  );
            if( conn != null ){ System.out.println("데이터 베이스 접속 성공");

                    System.out.println("이름을 입력해주세요");
                     String name= sc.nextLine();
                    insert(name);
            }

        } catch (ClassNotFoundException e) { System.out.println("드라이버 로드 실패");
                }
        catch (SQLException e) { System.out.println("데이터 베이스 접속 실패"); }finally {
            if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement 객체 해제
            if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection 해제

        }

    }
    //insert
        public static void insert(String name){

            Date dataInfo= new Date();
            SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
            String data = transFormat.format(dataInfo);



        try {

            String sql ="INSERT INTO first(name, date)" ;
                    sql = sql+" VALUES(?,?)";


                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,""+name+"" );
                pstmt.setString(2,""+data+"" );


            int result =pstmt.executeUpdate();
                System.out.println("result="+result);
                pstmt.close();
                conn.close();
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("안들어갔습니다.");
        }finally {
            if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement 객체 해제
            if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection 해제

        }


        }// insert/

    //select

    public static void list(){
        String sql = "show tables like 'first'";

    }

}
