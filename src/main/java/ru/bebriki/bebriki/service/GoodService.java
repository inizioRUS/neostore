package ru.bebriki.bebriki.service;

import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.bebriki.Errors.GoodNotFoundException;
import ru.bebriki.bebriki.dtos.CreateGoodWrapperDto;
import ru.bebriki.bebriki.dtos.UpdateGoodDto;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.responses.CategoryItemResponse;
import ru.bebriki.bebriki.responses.GoodResponse;

import java.util.List;

public interface GoodService {
    public Good saveGood(Good good);
    public List<Good> saveGoods(List<Good> goods);
    public List<Good> getAllGoods();
    public List<GoodResponse> findAll();
    public GoodResponse findById(int id);
    public List<GoodResponse> findByTitle(String title);
    public List<CategoryItemResponse> findGoodsCategories();
    public GoodResponse create(CreateGoodWrapperDto dto);
    public GoodResponse update(int id, UpdateGoodDto dto) throws GoodNotFoundException;
    public GoodResponse updatePhotoById(int id, MultipartFile file);
    public GoodResponse deleteById(int id);
    public List<GoodResponse> deleteByTitle(String title);
}
