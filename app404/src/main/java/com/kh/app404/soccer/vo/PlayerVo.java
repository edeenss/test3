package com.kh.app404.soccer.vo;


import lombok.Data;

import java.util.Date;

@Data
public class PlayerVo {

    private int playerId;       //플레이어아이디
    private String name;        //이름
    private String team;        //팀
    private String position;        //포지션
    private int age;                //나이
    private int goals;              //골
    private int assists;               //어시스트
    private Date createdAt; // DATE -> String (프론트와의 JSON 통신 편의성)
}
