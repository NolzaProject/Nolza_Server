package me.nolza.controller.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


/**
 * Created by gain on 2017. 8. 7..
 */
@Data
@NoArgsConstructor
public class CategoryRequest {

    private Long Id;

    @NotNull
    private String title;

    private String description;
}
