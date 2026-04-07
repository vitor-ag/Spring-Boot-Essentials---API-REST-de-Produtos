package br.com.aguiar.spring_boot_essencials.database.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductEntity {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
