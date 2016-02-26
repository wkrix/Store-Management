package hu.klayton.wade.sm.service;

import hu.klayton.wade.sm.dto.StockMovementDTO;
import hu.klayton.wade.sm.dto.SummaryDTO;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
public interface StockMovementService {

    void save(StockMovementDTO stockMovementDTO);

    List<SummaryDTO> findByWareHouseId(Long id);
}
