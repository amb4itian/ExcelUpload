package amb.poc.excelwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLType;
import java.util.UUID;

/**
 * primary key as UUID
 */

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
public class MyTransaction implements Serializable {
//
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @JdbcTypeCode(SqlTypes.BLOB)
//    @Column(name = "transaction_id", updatable = false, nullable = false)
//    private UUID transactionId;


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "transaction_id", columnDefinition = "VARCHAR(255)")
//    private UUID transactionId;


    @Column(name = "debit_account_id", length = 40)
    private String debitAccountId;

    @Column(name = "credit_account_id", length = 40)
    private String creditAccountId;

    @Column(name = "debit_amount")
    private BigDecimal debitAmount;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;


}
