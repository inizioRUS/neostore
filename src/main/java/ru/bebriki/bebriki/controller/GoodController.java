package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.bebriki.Errors.GoodNotFoundException;
import ru.bebriki.bebriki.dtos.CreateGoodWrapperDto;
import ru.bebriki.bebriki.dtos.UpdateGoodDto;
import ru.bebriki.bebriki.models.Good;

import java.util.List;

import ru.bebriki.bebriki.responses.CategoryItemResponse;
import ru.bebriki.bebriki.responses.ErrorMessageResponce;
import ru.bebriki.bebriki.responses.GoodResponse;
import ru.bebriki.bebriki.service.GoodService;

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodController {
    @Autowired
    private GoodService service;
    public GoodController(final GoodService productService) {
        this.service = productService;
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@ModelAttribute CreateGoodWrapperDto dto) {
        if (service.findByTitle(dto.getTitle()).size() != 0)
            return ResponseEntity.status(400).body(new ErrorMessageResponce("Product with that title already exist"));

        return ResponseEntity.status(201).body(service.create(dto));
    }
    @PostMapping("/addGood")
    public String add(@RequestBody Good product ){
        service.saveGood(product);
        return "New product is added";
    }

    @PostMapping("/addGoods")
    public List<Good> addGoods(@RequestBody List<Good> goods){
        return service.saveGoods(goods);
    }


    @GetMapping("/getAllGoods")
    public ResponseEntity<List<GoodResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/goodById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        GoodResponse good = service.findById(id);

        if (good == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this id is not found"));

        return ResponseEntity.ok(good);
    }


    @GetMapping("/{title}")
    public ResponseEntity<?> findByTitle(@RequestParam String title) {
        List<GoodResponse> goods = service.findByTitle(title);

        if (goods.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this title is not found"));

        return ResponseEntity.ok(goods);
    }
    @GetMapping("/categories")
    //   @PreAuthorize("hasRole('USER') or hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public ResponseEntity<?> findPizzaCategories() {
        List<CategoryItemResponse> categories = service.findGoodsCategories();

        if (categories.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this category is not found"));

        return ResponseEntity.ok(categories);
    }

    @PatchMapping("/update/{id}")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @RequestBody UpdateGoodDto dto) throws GoodNotFoundException {

        GoodResponse pizza = service.update(id, dto);

        if (pizza == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this id is not found"));

        return ResponseEntity.ok(pizza);
    }
    @PatchMapping("{id}/photo")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updatePhoto(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file) {

        GoodResponse good = service.updatePhotoById(id, file);

        if (good == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("product with this id is not found"));

        return ResponseEntity.ok(good);
    }

    @DeleteMapping("{id}")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable int id) {
        GoodResponse pizza = service.deleteById(id);

        if (pizza == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("product with this id is not found"));

        return ResponseEntity.ok(pizza);
    }
    @DeleteMapping
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteByTitle(@RequestParam String title) {
        List<GoodResponse> pizzas = service.deleteByTitle(title);

        if (pizzas.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Pizza(s) with this title not found"));

        return ResponseEntity.ok(pizzas);
    }


}