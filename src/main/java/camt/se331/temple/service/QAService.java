package camt.se331.temple.service;

import camt.se331.temple.entity.Activity;
import camt.se331.temple.entity.QA;

import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface QAService {
    QA findById(Long id);
    List<QA> getQAs();
    List<QA> getQABetween(Date stateDate, Date stopDate);
    QA addQA(QA QA);
    QA deleteQA(QA QA);
    QA addSelectedProduct(QA QA,Activity activity);
}
