package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.ExpenseDTO;
import br.com.unifacef.ijb.models.entities.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseMapper {
    public static Expense convertExpenseDTOIntoExpense(ExpenseDTO expenseDTO){
        return new Expense(
                MaterialMapper.convertMaterialDTOIntoMaterial(expenseDTO.getMaterial()),
                ConstructionMapper.convertConstructionDTOIntoConstruction(expenseDTO.getConstruction()),
                expenseDTO.getReceiptDate(),
                expenseDTO.getExpiryDate()
        );
    }

    public static ExpenseDTO convertExpenseIntoExpenseDTO(Expense expense){
        return new ExpenseDTO(
                expense.getId(),
                MaterialMapper.convertMaterialIntoMaterialDTO(expense.getMaterial()),
                ConstructionMapper.convertConstructionIntoConstructionDTO(expense.getConstruction()),
                expense.getReceiptDate(),
                expense.getExpiryDate()
        );
    }

    public static List<ExpenseDTO> convertListOfExpenseIntoListOfExpenseDTO(List<Expense> expenses) {
       List<ExpenseDTO> expenseDTOs = new ArrayList<>();

       expenses.forEach(expense -> expenseDTOs.add(convertExpenseIntoExpenseDTO(expense)));

       return expenseDTOs;
    }

    public static void updateExpense(ExpenseDTO expenseUpdate, Expense expense) {
        expense.setMaterial(MaterialMapper.convertMaterialDTOIntoMaterial(expenseUpdate.getMaterial()));
        expense.setConstruction(ConstructionMapper.convertConstructionDTOIntoConstruction(expenseUpdate.getConstruction()));
        expense.setReceiptDate(expenseUpdate.getReceiptDate());
        expense.setExpiryDate(expenseUpdate.getExpiryDate());
    }


}
