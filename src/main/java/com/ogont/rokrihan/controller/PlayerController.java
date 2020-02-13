package com.ogont.rokrihan.controller;

import com.ogont.rokrihan.model.player.LoginUser;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.player.PlayerInfoEntity;
import com.ogont.rokrihan.model.player.PlayerResultEntity;
import com.ogont.rokrihan.model.player.team.PlayersTeamEntity;
import com.ogont.rokrihan.model.player.team.TeamEntity;
import com.ogont.rokrihan.model.util.DistributeResult;
import com.ogont.rokrihan.service.impl.LoginService;
import com.ogont.rokrihan.service.impl.PlayerInfoService;
import com.ogont.rokrihan.service.impl.PlayerService;
import com.ogont.rokrihan.service.impl.PlayersTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PlayerController {
    @Resource
    PlayerService playerService;
    @Resource
    PlayersTeamService playersTeamService;
    @Resource
    LoginService loginService;
    @Resource
    PlayerInfoService playerInfoService;

    @GetMapping("/players/{count}")
    public @ResponseBody
    List<PlayerEntity> players(@PathVariable Integer count){
        return playerService.findTop(count);
    }
    @GetMapping("/players")
    public @ResponseBody
    List<PlayerEntity> players() {
        List<PlayerEntity> playerEntities = playerService.getAll();

        playerEntities.sort(Comparator.comparingInt(PlayerEntity::getMmr).reversed());
        return playerEntities;
    }
    @GetMapping("player/{id}/team_mates/")
    public @ResponseBody Map<String, List<PlayerEntity>> teamMates(@PathVariable Integer id){
        Map<TeamEntity, List<PlayerEntity>> teamMates = playersTeamService.getTeamMates(playerService.findById(id).get());
        return teamMates.entrySet().stream().collect(Collectors.toMap(x->x.getKey().getName(), Map.Entry::getValue));
    }
    @GetMapping("player/{id}/all_mates/")
    public @ResponseBody List<DistributeResult> allTeamMates(@PathVariable Integer id){
        List<DistributeResult> distributeResults = new ArrayList<>();
        Map<TeamEntity, List<PlayerEntity>> teamMates = playersTeamService.getTeamMates(playerService.findById(id).get());
        for(Map.Entry<TeamEntity, List<PlayerEntity>> entry : teamMates.entrySet()){
            for (PlayerEntity playerEntity : entry.getValue()) {
                distributeResults.add(new DistributeResult(playerEntity, playerInfoService.findByPlayerId(playerEntity.getId()), null));
            }
        }

        return distributeResults;
    }
    @GetMapping("best/in/team/{id}")
    public @ResponseBody List<PlayerEntity> bestByTeam(@PathVariable Integer id){
        return playersTeamService.getBestByTeam(id);
    }

    @GetMapping("/player/{id}")
    public @ResponseBody
    PlayerEntity player(@PathVariable Integer id) {
        return playerService.findById(id).get();
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody LoginUser user) throws LoginException {
        loginService.registerUser(user);
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

    @PostMapping("/player/{player_id}/team/{team_id}/sign")
    public void signTeam(@PathVariable Integer player_id, @PathVariable Integer team_id){
        PlayersTeamEntity playersTeamEntity = new PlayersTeamEntity();

        playersTeamEntity.setPlayerId(player_id);
        playersTeamEntity.setPlayerId(team_id);
        playersTeamService.save(playersTeamEntity);
    }
    @PostMapping("/player/{id}/avatar/upload")
    public void avatarUpload(@PathVariable Integer id,
                             @RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        PlayerInfoEntity playerInfoEntity = playerInfoService.findByPlayerId(id);
        playerInfoEntity.setAvatar(bytes);
        playerInfoService.save(playerInfoEntity);
    }
    @GetMapping("/player/{id}/info")
    @ResponseBody
    public PlayerInfoEntity playerInfoEntity(@PathVariable Integer id){
        return playerInfoService.findByPlayerId(id);
    }

    @RequestMapping(value = "/player/{id}/info", method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PlayerInfoEntity playerInfoEntity2(@PathVariable Integer id){
        return playerInfoService.findByPlayerId(id);
    }
}
