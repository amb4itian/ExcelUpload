package amb.poc.excelwork.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * generating id from a table and
 */
@Entity
@Table
@Data
public class SalesOrder {


    @Id
    @Column(name = "so_id")
    private Integer soId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "gross_amount")
    private BigDecimal grossAmount;

    @Column(name = "net_amount")
    private BigDecimal netAmount;
}
