package wat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wat.dao.HistoryDAO;
import wat.entity.History;
import wat.entity.Image;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
@Autowired
HistoryDAO historyDAO;

    @Override
    public List<History> getHistorys() {
        return historyDAO.getHistorys();
    }

    @Override
    public History add(History history) {
        return historyDAO.addHistory(history);
    }


    @Override
    public History getHistory(Long id) {
        return historyDAO.getHistory(id);
    }


    @Override
    public History updateHistory(History history) {
        return historyDAO.updateHistory(history);
    }



    @Override

    public History addImage(History history, Image image) {
        history.getImages().add(image);
        historyDAO.updateHistory(history);
        return history;
    }
}
