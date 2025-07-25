package com.kh.app404.soccer.service;

import com.kh.app404.soccer.mappper.PlayerVoMapper;
import com.kh.app404.soccer.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService {
    private final PlayerVoMapper mapper;

    public int addPlayer(PlayerVo player) {
        return mapper.insertPlayer(player);
    }
    public List<PlayerVo> getPlayerList() {
        return mapper.selectPlayerList();
    }
    public PlayerVo getPlayerByNo(int playerId) {
        return mapper.selectPlayerByNo(playerId);
    }
    public int updatePlayer(PlayerVo player) {
        return mapper.updatePlayer(player);
    }
    public int deletePlayer(int playerId) {
        return mapper.deletePlayer(playerId);
    }
}
