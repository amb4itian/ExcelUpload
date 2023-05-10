package amb.poc.excelwork.repo;

import amb.poc.excelwork.entity.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepo extends JpaRepository<MyTransaction, UUID> {
}
