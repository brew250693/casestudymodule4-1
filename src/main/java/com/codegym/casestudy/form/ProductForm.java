package com.codegym.casestudy.form;

import com.codegym.casestudy.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {
    private Long id;

    private String name;

    private Long price;

    private Long quantity;

    private MultipartFile avatar;

    private Category category;

}
