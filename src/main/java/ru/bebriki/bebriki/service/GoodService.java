package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.bebriki.Errors.GoodNotFoundException;
import ru.bebriki.bebriki.dtos.CreateGoodWrapperDto;
import ru.bebriki.bebriki.dtos.UpdateGoodDto;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.repositories.GoodRepository;
import ru.bebriki.bebriki.responses.CategoryItemResponse;
import ru.bebriki.bebriki.responses.GoodResponse;

import java.util.List;
import java.util.Optional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
@Service

public interface GoodService {
    Good saveGood(Good good);

    List<Good> saveGoods(List<Good> goods);

    List<Good> getAllGoods();

    List<GoodResponse> findAll();

    GoodResponse findById(int id);

    List<GoodResponse> findByTitle(String title);

//    List<CategoryItemResponse> findGoodsCategories();

    GoodResponse create(CreateGoodWrapperDto dto);

    GoodResponse update(int id, UpdateGoodDto dto) throws GoodNotFoundException;

    GoodResponse updatePhotoById(int id);

    GoodResponse deleteById(int id);

    List<GoodResponse> deleteByTitle(String title);
}
