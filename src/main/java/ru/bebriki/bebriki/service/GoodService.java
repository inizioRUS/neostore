package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.repositories.GoodRepository;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    private GoodRepository repository;

    public Good saveGood(Good good){
        return repository.save(good);
    }

    public List<Good> saveGoods(List<Good> goods){
        return repository.saveAll(goods);
    }
    public List<Good> getGoods(){
        return repository.findAll();
    }
    public Good getGoodById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Good> getGoodsByName(String name){
        return repository.findByName(name);
    }
    public String deleteGood(int id){
        repository.deleteById(id);
        return "Good has been deleted "+ id;
    }
    public Good updateGood(Good good){
        Good existingGood = repository.findById(good.getId()).orElse(null);
        existingGood.setTitle(good.getTitle());
        existingGood.setAmount(good.getAmount());
        existingGood.setPrice(good.getPrice());
        return repository.save(existingGood);

    }

}
