package hu.klayton.wade.sm.controller;

import hu.klayton.wade.sm.dao.StockMovementRepository;
import hu.klayton.wade.sm.domain.StockMovement;
import hu.klayton.wade.sm.dto.StockMovementDTO;
import hu.klayton.wade.sm.dto.WareHouseDTO;
import hu.klayton.wade.sm.service.StockMovementService;
import hu.klayton.wade.sm.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Controller
@RequestMapping(value = "/stockmovement")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @Autowired
    private WareHouseService wareHouseService;


    @RequestMapping(value = "/do_stockmovement/{productId}", method = RequestMethod.GET)
    public String doStockMovement(@PathVariable("productId") final Long id, final Model model) {
        final StockMovementDTO stockMovementDTO = new StockMovementDTO();
        stockMovementDTO.setProductId(id);
        model.addAttribute(stockMovementDTO);
        addComboBoxData(model);
        return "stockmovement/stockmovement_creator";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute final StockMovementDTO stockMovementDTO, final Errors errors, final Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(stockMovementDTO);
            addComboBoxData(model);
            return "stockmovement/stockmovement_creator";
        }
        stockMovementService.save(stockMovementDTO);
        return "redirect:/warehouse/list_warehouses";
    }


    @RequestMapping(value = "/list_stockmovement_block/{warehouseId}", method = RequestMethod.GET)
    public String showStockMovementBlock(final Model model, @PathVariable("warehouseId") final Long id) {
        model.addAttribute("stockMovementBlockList", stockMovementService.findByWareHouseId(id));
        return "fragments :: stockmovement_block";
    }

    private void addComboBoxData(final Model model) {
        StockMovement.Type[] allTypes = StockMovement.Type.values();
        model.addAttribute("allTypes", allTypes);
        List<WareHouseDTO> allWareHouseDTOs = wareHouseService.findAll();
        model.addAttribute("allWarehouses", allWareHouseDTOs);
    }
}
