package wat.service;

import wat.entity.History;
import wat.entity.Image;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
public interface HistoryService {
    List<History> getHistorys();
History add(History history);
    History getHistory(Long id);

    History updateHistory(History history);


    History addImage(History history, Image image);
}
