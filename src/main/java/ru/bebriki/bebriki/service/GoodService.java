package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bebriki.bebriki.Errors.GoodNotFoundException;
import ru.bebriki.bebriki.dtos.CreateGoodWrapperDto;
import ru.bebriki.bebriki.dtos.UpdateGoodDto;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.repositories.GoodRepository;
import ru.bebriki.bebriki.responses.CategoryItemResponse;
import ru.bebriki.bebriki.responses.GoodResponse;
import ru.bebriki.bebriki.responses.UploadFileResponse;

import java.util.List;
import java.util.Optional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class GoodService {
    @Value("${filesystem.url}")
    private String fileSystemBaseUrl;
    @Autowired
    private GoodRepository goodRepository;

    public Good saveGood(Good good){
        return goodRepository.save(good);
    }

    public List<Good> saveGoods(List<Good> goods){
        return goodRepository.saveAll(goods);
    }
    public List<Good> getAllGoods(){
        return goodRepository.findAll();
    }
    public List<GoodResponse> findAll() {
        return goodRepository.findAll(Sort.by(Sort.Direction.ASC, "title"))
                .stream()
                .map(GoodResponse::cast)
                .toList();
    }
    public GoodResponse findById(int id) {
        Optional<Good> product = goodRepository.findById(id);

        if (product.isEmpty())
            return null;

        return GoodResponse.cast(product.orElseThrow());
    }
    public List<GoodResponse> findByTitle(String title) {
        return goodRepository.findByTitle(title).stream().map(GoodResponse::cast).toList();
    }
    public List<CategoryItemResponse> findGoodsCategories() {
        return goodRepository.findProductCategories();
    }
    public GoodResponse create(CreateGoodWrapperDto dto) {
        UploadFileResponse response = uploadPictureRequest(dto.getTitle(), dto.getFile());

        Good product = goodRepository.save(Good.builder()
                .title(dto.getTitle())
                .categoryId(dto.getCategoryId())
                .price(dto.getPrice())
                .discount(dto.getDiscount())
                .description(dto.getDescription())
                .imageURL(dto.getImageURL())
                .amount(dto.getAmount())
                .build()
        );

        return GoodResponse.cast(product);
    }
    private UploadFileResponse uploadPictureRequest(String productTitle, MultipartFile file) {
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", file.getResource());
        multipartBodyBuilder.part("title", productTitle);

        WebClient webClient = WebClient.builder()
                .baseUrl(fileSystemBaseUrl)
                .build();

        UploadFileResponse response = webClient.post()
                .uri("/file")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
                .body(BodyInserters.fromMultipartData(multipartBodyBuilder.build()))
                .retrieve()
                .bodyToMono(UploadFileResponse.class)
                .block();

        if (response == null)
            throw new RuntimeException("Failed to save the file");

        return response;
    }
    public GoodResponse update(int id, UpdateGoodDto dto) throws GoodNotFoundException {
        Optional<Good> productOptional = goodRepository.findById(id);

        if (productOptional.isEmpty())
            throw new GoodNotFoundException("this no such good");

        Good product = productOptional.orElseThrow();

        product.setPrice(dto.getPrice());
        product = goodRepository.save(product);

        return GoodResponse.cast(product);
    }
    public GoodResponse updatePhotoById(int id, MultipartFile file) {
        Optional<Good> productOptional = goodRepository.findById(id);

        if (productOptional.isEmpty())
            return null;

        Good product = productOptional.orElseThrow();

        UploadFileResponse response = uploadPictureRequest(product.getTitle(), file);

        product.setImageURL(response.getUrl());
        product = goodRepository.save(product);

        return GoodResponse.cast(product);
    }
    public GoodResponse deleteById(int id) {
        Optional<Good> product = goodRepository.findById(id);

        if (product.isEmpty())
            return null;

        goodRepository.deleteById(id);

        return GoodResponse.cast(product.get());
    }
    public List<GoodResponse> deleteByTitle(String title) {
        List<Good> products = goodRepository.findByTitle(title);

        goodRepository.deleteByTitle(title);

        return products.stream().map(GoodResponse::cast).toList();
    }
}