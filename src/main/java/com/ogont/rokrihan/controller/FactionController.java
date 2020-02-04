package com.ogont.rokrihan.controller;

import com.ogont.rokrihan.model.faction.FactionComboEntity;
import com.ogont.rokrihan.service.IFactionComboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FactionController {

    @Resource
    IFactionComboService factionComboService;

    @GetMapping("/factions")
    public @ResponseBody
    List<FactionComboEntity> factions() {
        return factionComboService.getAll();
    }
}