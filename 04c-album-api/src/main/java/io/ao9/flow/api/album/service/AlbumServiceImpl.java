package io.ao9.flow.api.album.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ao9.flow.api.album.data.AlbumEntity;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Override
    public List<AlbumEntity> findAlbumsByUserId(String userId) {
        List<AlbumEntity> albumEntities = new ArrayList<>();
        
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setUserId(userId);
        albumEntity.setAlbumId("album1Id");
        albumEntity.setDescription("album 1 description");
        albumEntity.setId(1L);
        albumEntity.setTitle("album 1 title");
        
        AlbumEntity albumEntity2 = new AlbumEntity();
        albumEntity2.setUserId(userId);
        albumEntity2.setAlbumId("album2Id");
        albumEntity2.setDescription("album 2 description");
        albumEntity2.setId(2L);
        albumEntity2.setTitle("album 2 title");
        
        albumEntities.add(albumEntity);
        albumEntities.add(albumEntity2);
        
        return albumEntities;
    }

}