package com.master.products_services.services;


import com.master.products_services.message.ResponseFile;
import com.master.products_services.models.Product_Photos;
import com.master.products_services.repository.Product_PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class Product_PhotosService {

    @Autowired
    private Product_PhotosRepository product_photosRepository;


    //view images of business by businessID
//    public Stream<Product_Photos> getImagesByPruductId(Long id) {
//        return product_photosRepository.findByPruductId(id);
//    }

    public Stream<Product_Photos> getAllFiles() {
        return product_photosRepository.findAll().stream();
    }

    /*
        Store Img for business
    */
    public Product_Photos storeImg(MultipartFile file, Long businessId,Long productId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Product_Photos FileDB = new Product_Photos(fileName, file.getContentType(), productId,businessId,file.getBytes());
        return product_photosRepository.save(FileDB);
    }

    //delete img by id
    public void deleteImg(String id){
        product_photosRepository.deleteById(id);
    }

    /*
    *  List images for a business
    * */
    public List<ResponseFile> getAllFilesByBusinessID(Long id) {

        Stream<Product_Photos> pp = product_photosRepository.findAll().stream();
        List<ResponseFile> files = pp.map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/product_services/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getId(),
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getProductId(),
                    dbFile.getBusinessId());
        }).collect(Collectors.toList());

        List<ResponseFile> images = new ArrayList<>();
        for(ResponseFile res : files){
            //System.out.println(res.getBusinessId()+" - "+ res.getName());
            if( id == res.getBusinessId()){
                images.add(res);
            }
        }

    return images;
    }

    public Product_Photos getFile(String id) {
        return product_photosRepository.findById(id).get();
    }


}
