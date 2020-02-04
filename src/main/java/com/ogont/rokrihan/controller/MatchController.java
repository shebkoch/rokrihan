package com.ogont.rokrihan.controller;

import com.ogont.rokrihan.model.util.DistributeData;
import com.ogont.rokrihan.model.faction.FactionEntity;
import com.ogont.rokrihan.model.match.FullMatch;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.service.IFactionDistributorService;
import com.ogont.rokrihan.service.IFullMatchService;
import com.ogont.rokrihan.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class MatchController {
    @Resource
    IFullMatchService fullMatchService;
    @Resource
    IFactionDistributorService factionDistributorService;

    @PostMapping("/match")
    @ResponseStatus(HttpStatus.OK)
    public void matchSave(@RequestBody FullMatch match) {
        fullMatchService.save(match);
    }

    @RequestMapping(value = "/distribute", method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Pair<PlayerEntity, FactionEntity>> distribute(@RequestBody DistributeData data) {
        return distribute2(data);
    }

    @RequestMapping(value = "/distribute", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Pair<PlayerEntity, FactionEntity>> distribute2(@RequestBody DistributeData data) {
        Map<PlayerEntity, FactionEntity> map = factionDistributorService.distribute(data);
        List<Pair<PlayerEntity, FactionEntity>> list = new ArrayList<>();
        for (Map.Entry<PlayerEntity, FactionEntity> entry : map.entrySet()) {
            list.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    @GetMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    FullMatch getMatch(@PathVariable Integer id) {
        return fullMatchService.getByMatchId(id);
    }

    @GetMapping("/matches")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<FullMatch> getMatches() {
        List<FullMatch> list = fullMatchService.getAll();
        list.sort(Comparator.comparing(x -> x.getMatchEntity().getEtime(), Comparator.reverseOrder()));
        return list;
    }
}
