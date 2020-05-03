package io.ao9.flow.api.album.service;

import java.util.List;

import io.ao9.flow.api.album.data.AlbumEntity;

public interface AlbumService {

    List<AlbumEntity> findAlbumsByUserId(String userId);

}