package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.ExpenseDTO;
import br.com.unifacef.ijb.models.entities.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseMapper {
    public static Expense convertExpenseDTOIntoExpense(ExpenseDTO expenseDTO){
        return new Expense(
                PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(expenseDTO.getPurchasedMaterialDTO()),
                ConstructionMapper.convertConstructionDTOIntoConstruction(expenseDTO.getConstructionDTO()),
                expenseDTO.getReceiptDate(),
                expenseDTO.getExpiryDate()
        );
    }

    public static ExpenseDTO convertExpenseIntoExpenseDTO(Expense expense){
        return new ExpenseDTO(
                expense.getId(),
                PurchasedMaterialMapper.convertPurchasedMaterialIntoPurchasedMaterialDTO(expense.getPurchasedMaterial()),
                ConstructionMapper.convertConstructionIntoConstructionDTO(expense.getConstruction()),
                expense.getReceiptDate(),
                expense.getExpiryDate()
        );
    }

    public static List<ExpenseDTO> convertListOfExpenseIntoListOfExpenseDTO(List<Expense> expenses) {
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();
        for (Expense expense : expenses) {
            expenseDTOs.add(convertExpenseIntoExpenseDTO(expense));
        }
        return expenseDTOs;
    }

    public static void updateExpense(ExpenseDTO expenseUpdate, Expense expense) {
        expense.setPurchasedMaterial(PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(expenseUpdate.getPurchasedMaterialDTO()));
        expense.setConstruction(ConstructionMapper.convertConstructionDTOIntoConstruction(expenseUpdate.getConstructionDTO()));
        expense.setReceiptDate(expenseUpdate.getReceiptDate());
        expense.setExpiryDate(expenseUpdate.getExpiryDate());
    }


}
