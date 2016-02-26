package hu.klayton.wade.sm.service;

import hu.klayton.wade.sm.dao.ProductRepository;
import hu.klayton.wade.sm.dao.StockMovementRepository;
import hu.klayton.wade.sm.domain.Product;
import hu.klayton.wade.sm.domain.StockMovement;
import hu.klayton.wade.sm.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;


    @PostConstruct
    private void initDummyData() {
        Product product = new Product("Alma", "Kicsit kukacos", new Date(), new Date(System.currentTimeMillis() + 1616927899));
        Product product2 = new Product("Körte", "Érett, finom", new Date(), new Date(System.currentTimeMillis() + 1789999899));
        productRepository.save(product);
        productRepository.save(product2);
    }

    @Override
    public List<ProductDTO> findAll() {
        final List<Product> products = productRepository.findAll();
        final List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(ProductDTO.createDTO(product));
        }
        return productDTOs;
    }

    @Override
    public void save(final ProductDTO productDTO) {
        final StockMovement stockMovement = stockMovementRepository.findByProductId(productDTO.getId());
        Product product = productDTO.createProduct();
        product.setStockMovement(stockMovement);
        if (product.getCreationDate() == null) {
            product.setCreationDate(new Date());
        }
        productRepository.save(product);
    }

    @Override
    public void delete(final Long id) {
        productRepository.delete(id);
    }

    @Override
    public ProductDTO findOne(final Long id) {
        Product product = productRepository.findOne(id);
        return ProductDTO.createDTO(product);
    }
}
