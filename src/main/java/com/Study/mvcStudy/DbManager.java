package com.Study.mvcStudy;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class DbManager {

    static public   Connection          conn =null;
    static  public   PreparedStatement   pstmt = null;
    static  public   ResultSet           rs;
    static Scanner sc = new Scanner(System.in);

    public static void main (String... args){
        dbConnectInfo dbInfo = new dbConnectInfo();
        Date dateInfo= new Date();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = transFormat.format(dateInfo);
        try {
            Class.forName(dbInfo.driver);
            conn=   DriverManager.getConnection(dbInfo.url, dbInfo.uId, dbInfo.uPwd  );
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
