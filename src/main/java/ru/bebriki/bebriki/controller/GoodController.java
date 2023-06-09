package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    private GoodService goodService;
//    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> create(@ModelAttribute CreateGoodWrapperDto dto) {
//        if (goodService.findByTitle(dto.getTitle()).size() != 0)
//            return ResponseEntity.status(400).body(new ErrorMessageResponce("Product with that title already exist"));
//
//        return ResponseEntity.status(201).body(goodService.create(dto));
//    }
    @PostMapping("/addGood")
    public String add(@RequestBody Good product ){
        goodService.saveGood(product);
        return "New product is added";
    }

    @PostMapping("/addGoods")
    public List<Good> addGoods(@RequestBody List<Good> goods){
        return goodService.saveGoods(goods);
    }


    @GetMapping("/getAllGoods")
    public ResponseEntity<List<GoodResponse>> findAll() {
        return ResponseEntity.ok(goodService.findAll());
    }

    @GetMapping("/goodById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        GoodResponse good = goodService.findById(id);

        if (good == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this id is not found"));

        return ResponseEntity.ok(good);
    }


    @GetMapping("/goodByTittle/{title}")
    public ResponseEntity<?> findByTitle(@RequestParam String title) {
        List<GoodResponse> goods = goodService.findByTitle(title);

        if (goods.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this title is not found"));

        return ResponseEntity.ok(goods);
    }
    @GetMapping("/goodByCategory/{category}")
    public ResponseEntity<?> findByCategory(@RequestParam String category) {
        List<GoodResponse> goods = goodService.findByCategory(category);

        if (goods.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this category is not found"));

        return ResponseEntity.ok(goods);
    }
//    @GetMapping("/categories")
////       @PreAuthorize("hasRole('USER') or hasRole('EMPLOYEE') or hasRole('ADMIN')")
//    public ResponseEntity<?> findPizzaCategories() {
//        List<CategoryItemResponse> categories = goodService.findGoodsCategories();
//
//        if (categories.size() == 0)
//            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this category is not found"));
//
//        return ResponseEntity.ok(categories);
//    }

    @PutMapping("/update/{id}")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @RequestBody UpdateGoodDto dto) throws GoodNotFoundException {

        GoodResponse pizza = goodService.update(id, dto);

        if (pizza == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Product with this id is not found"));

        return ResponseEntity.ok(pizza);
    }
//    @PutMapping("{id}/photo")
//    //   @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> updatePhoto(
//            @PathVariable int id,
//            @RequestParam("file") MultipartFile file) {
//
//        GoodResponse good = goodService.updatePhotoById(id, file);
//
//        if (good == null)
//            return ResponseEntity.status(404).body(new ErrorMessageResponce("product with this id is not found"));
//
//        return ResponseEntity.ok(good);
//    }

    @DeleteMapping("{id}")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable int id) {
        GoodResponse pizza = goodService.deleteById(id);

        if (pizza == null)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("product with this id is not found"));

        return ResponseEntity.ok(pizza);
    }
    @DeleteMapping("")
    //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteByTitle(@RequestParam String title) {
        List<GoodResponse> pizzas = goodService.deleteByTitle(title);

        if (pizzas.size() == 0)
            return ResponseEntity.status(404).body(new ErrorMessageResponce("Pizza(s) with this title not found"));

        return ResponseEntity.ok(pizzas);
    }


}