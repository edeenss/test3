package com.kh.app404.soccer.vo;

import lombok.Data;
import java.util.Date;

@Data
public class MatchVo {
    private int matchId;        //매치아이디
    private Date matchDate;     //매치날짜
    private String homeTeam;    //홈팀
    private String awayTeam;    //어웨이 팀
    private int homeScore;      //홈 필드골
    private int awayScore;      //원정 골
    private String stadium;     //경기장
    private Date createdAt;     //경기 날짜
} 