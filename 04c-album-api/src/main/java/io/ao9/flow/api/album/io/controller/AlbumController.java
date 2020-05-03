package io.ao9.flow.api.album.io.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ao9.flow.api.album.data.AlbumEntity;
import io.ao9.flow.api.album.service.AlbumService;
import io.ao9.flow.api.album.ui.model.AlbumResponseModel;

@RestController
@RequestMapping("/users/{userId}/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping( 
        produces = { 
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
        }
    )
    public List<AlbumResponseModel> findAlbumsByUserId(@PathVariable String userId){
        List<AlbumResponseModel> albumResponseModels = new ArrayList<>();
        List<AlbumEntity> albumEntities = albumService.findAlbumsByUserId(userId);

        if(albumEntities == null || albumEntities.isEmpty()) {
            return albumResponseModels;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>(){}.getType();
        albumResponseModels = new ModelMapper().map(albumEntities, listType);

        return albumResponseModels;
    }

}