package com.ucx.testsparttwo.service;

import com.ucx.testsparttwo.entity.CloudProvider;
import com.ucx.testsparttwo.entity.Product;
import com.ucx.testsparttwo.repository.CloudProviderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.Iterator;
import java.util.List;

@Service
public class CloudProviderService extends BaseService<CloudProvider, Integer>  {

    CloudProviderRepository cloudProviderRepository;
    ProductService productService;

    CloudProviderService(CloudProviderRepository cloudProviderRepository, ProductService productService)
    {
        this.cloudProviderRepository = cloudProviderRepository;
        this.productService = productService;
    }
    @Override
    public CloudProvider save(CloudProvider cloudProvider) {
        if (cloudProvider.getProducts() == null) {
            throw new IllegalArgumentException("You must have at least one product.");
        }
        cloudProvider.getProducts().forEach(e -> e.setCloudProvider(cloudProvider));
        return super.save(cloudProvider);
    }

    public void update(CloudProvider cloudProvider, Integer id) {
        CloudProvider foundCloudProvider = findById(id);

        List<Product> previousProduct = foundCloudProvider.getProducts();
        List<Product> receivedProducts = cloudProvider.getProducts();
        if (receivedProducts != null) {
            previousProduct.stream().forEach((e) -> {
                Iterator<Product> iterator = receivedProducts.iterator();
                while (iterator.hasNext()) {
                    Product i = iterator.next();
                    try {
                        if (e.getId().equals(i.getId())) {
                            BeanUtils.copyProperties(i, e, BaseService.getNullPropertyNames(i));
                            iterator.remove();
                        }
                    } catch (Exception m) {
                    }
                }
            });
        }
        receivedProducts.forEach((e) -> {
            e.setCloudProvider(foundCloudProvider);
            productService.save(e);
        });
        cloudProvider.setProducts(null);
        BeanUtils.copyProperties(cloudProvider,foundCloudProvider, BaseService.getNullPropertyNames(cloudProvider));
    }

    public List<Tuple> readLocation() {
        return cloudProviderRepository.readLocation();
    }
}
