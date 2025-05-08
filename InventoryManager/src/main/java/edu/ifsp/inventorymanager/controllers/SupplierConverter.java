package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.Supplier;
import edu.ifsp.inventorymanager.models.repositories.SupplierRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter implements Converter<String, Supplier> {

    private final SupplierRepository supplierRepository;

    public SupplierConverter(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier convert(String source) {

        var code = Long.parseLong(source);
        return supplierRepository.findById(code).get();
    }
}