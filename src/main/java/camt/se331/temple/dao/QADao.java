package camt.se331.temple.dao;

import camt.se331.temple.entity.QA;

import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface QADao {
    QA findById(Long id);
    List<QA> getQAs();
    List<QA> getQABefore(Date stateDate);
    List<QA> getQABetween(Date stateDate, Date stopDate);
    QA addQA(QA qa);
    QA deleteQA(QA qa);
}
