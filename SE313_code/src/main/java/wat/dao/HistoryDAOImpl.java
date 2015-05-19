package wat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wat.entity.History;
import wat.repository.HistoryRepository;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Repository
public class HistoryDAOImpl implements HistoryDAO {
    @Autowired
    HistoryRepository historyRepository;

    @Override
    public List<History> getHistorys() {
        return historyRepository.findAll();
    }

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History getHistory(Long id) {
        return historyRepository.findOne(id);
    }



    @Override
    public History updateHistory(History history) {
        return historyRepository.save(history);
    }



}
