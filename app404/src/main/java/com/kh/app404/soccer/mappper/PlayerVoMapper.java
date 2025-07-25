package com.kh.app404.soccer.mappper;

import com.kh.app404.soccer.vo.PlayerVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PlayerVoMapper {
    @Insert("INSERT INTO PLAYER (PLAYER_ID, NAME, TEAM, POSITION, AGE) VALUES (SEQ_PLAYER.NEXTVAL, #{name}, #{team}, #{position}, #{age})")
    int insertPlayer(PlayerVo player); // INSERT

    @Select("SELECT * FROM PLAYER ORDER BY PLAYER_ID")
    List<PlayerVo> selectPlayerList(); // SELECT LIST

    @Select("SELECT * FROM PLAYER WHERE PLAYER_ID = #{playerId}")
    PlayerVo selectPlayerByNo(@Param("playerId") int playerId); // SELECT ONE BY NO

    @Update("UPDATE PLAYER SET NAME=#{name}, TEAM=#{team}, POSITION=#{position}, AGE=#{age}, GOALS=#{goals}, ASSISTS=#{assists} WHERE PLAYER_ID=#{playerId}")
    int updatePlayer(PlayerVo player); // UPDATE

    @Delete("DELETE FROM PLAYER WHERE PLAYER_ID=#{playerId}")
    int deletePlayer(@Param("playerId") int playerId); // DELETE
}
