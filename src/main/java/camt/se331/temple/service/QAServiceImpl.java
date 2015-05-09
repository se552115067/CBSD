package camt.se331.temple.service;

import camt.se331.temple.dao.QADao;
import camt.se331.temple.entity.Activity;
import camt.se331.temple.entity.SelectedProduct;
import camt.se331.temple.entity.QA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@Service
public class QAServiceImpl implements QAService {

    @Autowired
    QADao QADao;

    @Override
    @Transactional
    public QA findById(Long id) {
        return QADao.findById(id);
    }

    @Override
    public List<QA> getQAs() {
        return null;
    }

    @Override
    public List<QA> getQABetween(Date stateDate, Date stopDate) {
        return null;
    }

    @Override
    public QA addQA(QA QA) {
        return QADao.addQA(QA);
    }

    @Override
    public QA deleteQA(QA QA) {
       return null;
    }

    @Override
    public QA addSelectedProduct(QA QA,Activity activity) {
        for(SelectedProduct selectedProduct: QA.getSelectedProducts()){
            if (selectedProduct.getActivity().equals(activity)){
                selectedProduct.setAmount(selectedProduct.getAmount()+1);
                return QA;
            }
        }
        SelectedProduct selectedProduct = new SelectedProduct(activity,1);
        QA.getSelectedProducts().add(selectedProduct);
        return QA;
    }
}
