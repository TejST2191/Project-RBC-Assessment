package com.be.assessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.assessment.model.Stock;
import com.be.assessment.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void createStock(Stock stock) {
        stockRepository.save(stock);
    }

    public Optional<Stock> getStock(String symbol) {
        return stockRepository.findById(symbol);
    }

    public Stock updateStock(Stock existingStock, Stock updatedStock) {
        existingStock.setHeadQuarter(updatedStock.getHeadQuarter());
        existingStock.setName(updatedStock.getName());
        existingStock.setSector(updatedStock.getSector());
        return stockRepository.save(existingStock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public void deleteStock(String symbol) {
        stockRepository.deleteById(symbol);
    }

    public void bulkInsert(List<Stock> lists) {
            stockRepository.saveAll(lists);
    }
}
