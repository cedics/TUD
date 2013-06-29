package math;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import core.Calculator;
import core.IListElement;

/**
 * Class for computing primitive operations with point numbers.
 * @author Fabian Wagner
 * @since 03/07/12
 * @version 1.0
 */
public class PointNumberCalculator extends Calculator
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(IListElement leftOperand) {
		if(leftOperand == null || !leftOperand.hasNext() || !leftOperand.next().hasNext())
			throw new IllegalArgumentException("Syntax Error");

		if(!leftOperand.next().data().equals(Calculator.SIGN_ADD)){
			throw new IllegalArgumentException("Wrong operator in add operation.");
			
		}
			
		Double leftOperandDouble = new Double(leftOperand.data());
		Double rightOperandDouble = new Double(leftOperand.next().next().data());
		Double result = leftOperandDouble + rightOperandDouble;
		leftOperand.setData(result.toString());
		leftOperand.setNext(leftOperand.next().next().next());
		return;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sub(IListElement leftOperand) {
		if(leftOperand == null || !leftOperand.hasNext() || !leftOperand.next().hasNext())
			throw new IllegalArgumentException("Syntax Error");

		if(!leftOperand.next().data().equals(Calculator.SIGN_SUB))
			throw new IllegalArgumentException("Wrong operator in sub operation.");
		
		Double leftOperandDouble = new Double(leftOperand.data());
		Double rightOperandDouble = new Double(leftOperand.next().next().data());
		Double result = leftOperandDouble - rightOperandDouble;
		leftOperand.setData(result.toString());
		leftOperand.setNext(leftOperand.next().next().next());
		return;		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mul(IListElement leftOperand) {
		if(leftOperand == null || !leftOperand.hasNext() || !leftOperand.next().hasNext())
			throw new IllegalArgumentException("Syntax Error");

		if(!leftOperand.next().data().equals(Calculator.SIGN_MUL))
			throw new IllegalArgumentException("Wrong operator in mul operation.");
		
		Double leftOperandDouble = new Double(leftOperand.data());
		Double rightOperandDouble = new Double(leftOperand.next().next().data());
		Double result = leftOperandDouble * rightOperandDouble;
		leftOperand.setData(result.toString());
		leftOperand.setNext(leftOperand.next().next().next());
		return;		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void div(IListElement leftOperand) {
		if(leftOperand == null || !leftOperand.hasNext() || !leftOperand.next().hasNext())
			throw new IllegalArgumentException("Syntax Error");

		if(!leftOperand.next().data().equals(Calculator.SIGN_DIV))
			throw new IllegalArgumentException("Wrong operator in div operation.");
		
		Double leftOperandDouble = new Double(leftOperand.data());
		Double rightOperandDouble = new Double(leftOperand.next().next().data());
		Double result = leftOperandDouble / rightOperandDouble;
		leftOperand.setData(result.toString());
		leftOperand.setNext(leftOperand.next().next().next());
		return;		
	}
	
	public boolean checkIfNumber(String in) {
			return in.matches("[0-9]+");
    }

}
