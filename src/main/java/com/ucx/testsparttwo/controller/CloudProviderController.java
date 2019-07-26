package com.ucx.testsparttwo.controller;

import com.ucx.testsparttwo.util.EntityUtil;
import com.ucx.testsparttwo.entity.CloudProvider;
import com.ucx.testsparttwo.service.CloudProviderService;
import com.ucx.testsparttwo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudProviders")
public class CloudProviderController {

    private CloudProviderService cloudProviderService;
    private ProductService productService;

    private CloudProviderController(CloudProviderService cloudProviderService, ProductService productService) {
        this.cloudProviderService = cloudProviderService;
        this.productService = productService;
    }

    @PostMapping
    public CloudProvider create(@RequestBody CloudProvider cloudProvider) {
        cloudProvider = cloudProviderService.save(cloudProvider);
        return cloudProvider;
    }

    @PutMapping("/products/{cloudProviderId}")
    public void update(@RequestBody CloudProvider cloudProvider, @PathVariable Integer cloudProviderId) {
        cloudProviderService.update(cloudProvider, cloudProviderId);
    }


    @GetMapping("/products/locations")
    public List<Map<String, Object>> getLocations()
    {
        List<Map<String, Object>> mapList = null;
        List<Tuple> tuple = cloudProviderService.readLocation();
        for(int i=0; i<tuple.size(); i++)
        {
            mapList.add(EntityUtil.toList(tuple.get(i)));
        }
        return mapList;
    }
}
