package io.ao9.demoapp.api.user.ui.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumResponseModel {

    private String albumId;
    private String userId; 
    private String title;
    private String description;

}
