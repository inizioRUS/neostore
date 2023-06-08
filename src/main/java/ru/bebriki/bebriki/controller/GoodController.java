package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.models.Good;

import java.util.List;

@RestController
public class GoodController {
    @Autowired
    private GoodService GoodService;

    @PostMapping("/addGood")
    public Good addGood(@RequestBody Good good){
        return service.saveGood(good);
    }

    @PostMapping("/addGoods")
    public List<Good> addGoods(@RequestBody List<Good> goods){
        return service.saveGoods(goods);
    }

    @GetMapping("/goods")
    public List<Good> findAllGoods(){
        return service.getGoods();
    }

    @GetMapping("/goodById/{id}")
    public Good findGoodById(@PathVariable int id){
        return service.getGoodById(id);
    }

    @GetMapping("/goods/{name}")
    public List<Good> findGoodsByName(@PathVariable String name){
        return service.getGoodsByName(name);
    }

    @PutMapping("/update")
    public Good updateGood(@RequestBody Good good){
        return service.updateGood(good);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGood(@PathVariable int id){
        return service.deleteGood(id);
    }


}

