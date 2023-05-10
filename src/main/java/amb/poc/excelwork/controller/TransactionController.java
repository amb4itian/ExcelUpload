package amb.poc.excelwork.controller;

import amb.poc.excelwork.entity.MyTransaction;
import amb.poc.excelwork.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepo repo;

    @GetMapping("/transaction")
    public List<MyTransaction> get() {
        return repo.findAll();
    }

    @PostMapping("/transaction")
    public MyTransaction get(@RequestBody MyTransaction t) {
        List<MyTransaction> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            list.add(new MyTransaction(null, t.getDebitAccountId(), t.getCreditAccountId(), t.getDebitAmount(),
                    t.getCreditAmount()
            ));
        }
        
        repo.saveAll(list);
        return repo.save(t);
    }

}
