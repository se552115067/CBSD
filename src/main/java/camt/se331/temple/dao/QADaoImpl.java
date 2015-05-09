package camt.se331.temple.dao;

import camt.se331.temple.entity.QA;
import camt.se331.temple.repository.QARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@Repository
public class QADaoImpl implements QADao {
    @Autowired
    QARepository qaRepository;

    @Override
    public QA findById(Long id) {
        return qaRepository.findOne(id);
    }

    @Override
    public List<QA> getQAs() {
        return null;
    }

    @Override
    public List<QA> getQABefore(Date stateDate) {
        return null;
    }

    @Override
    public List<QA> getQABetween(Date stateDate, Date stopDate) {
        return null;
    }

    @Override
    public QA addQA(QA qa) {
        return qaRepository.save(qa);
    }

    @Override
    public QA deleteQA(QA qa) {
        return null;
    }
}
