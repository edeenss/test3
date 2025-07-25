package com.kh.app404.soccer.vo;

import lombok.Data;
import java.util.Date;

@Data
public class TeamVo {
    private int teamId;         //팀 아이디
    private String teamName;    //팀이름
    private String city;        //시티
    private String coach;       //코치
    private Date createdAt;     //날짜
} 