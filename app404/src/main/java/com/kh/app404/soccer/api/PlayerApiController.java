package com.kh.app404.soccer.api;

import com.kh.app404.soccer.service.PlayerService;
import com.kh.app404.soccer.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://192.168.200.166:5501") // 모든 오리진 허용
public class PlayerApiController {
    private final PlayerService service;

    @PostMapping
    public void insertPlay(@RequestBody PlayerVo player) {
        service.addPlayer(player);
    }

    @GetMapping
    public List<PlayerVo> selectPlay() {
        return service.getPlayerList();
    }

    @GetMapping("/{playerId}")
    public PlayerVo selectOne(@PathVariable int playerId) {
        return service.getPlayerByNo(playerId);
    }

    @PutMapping("/{playerId}")
    public void updatePlay(@PathVariable int playerId, @RequestBody PlayerVo player) {
        player.setPlayerId(playerId);
        service.updatePlayer(player);
    }

    @DeleteMapping("/{playerId}")
    public void deletePlay(@PathVariable int playerId) {
        service.deletePlayer(playerId);
    }
}
