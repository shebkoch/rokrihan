package com.ogont.rokrihan.controller;

import com.ogont.rokrihan.model.player.PlayerResultEntity;
import com.ogont.rokrihan.service.impl.MatchService;
import com.ogont.rokrihan.service.impl.PlayerResultService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@Controller
public class PlayerResultController {

    @Resource
    PlayerResultService playerResultService;
    @Resource
    MatchService matchService;

    @GetMapping("/last_info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    PlayerResultEntity lastInfo(@PathVariable Integer id) {
        return playerResultService.getLast(id);
    }

    @GetMapping("/results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<PlayerResultEntity> getAll(@PathVariable Integer id) {
        List<PlayerResultEntity> resultEntities = playerResultService.findAllByPlayerId(id);
        resultEntities.sort(Comparator.comparing(x -> x.getMatchEntity().getEtime(), Comparator.reverseOrder()));
        return resultEntities;
    }
}
