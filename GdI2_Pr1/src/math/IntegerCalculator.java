package math;

import java.math.BigInteger;

import core.Calculator;
import core.IListElement;

/**
 * Class for computing primitive operations with numbers.
 * @author Fabian Wagner
 * @since 03/07/12
 * @version 1.0
 */
public class IntegerCalculator extends Calculator {

	public void toSomething(){
		return;
	}
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
		if(!checkIfNumber(leftOperand.data())){
			throw new IllegalArgumentException("Left operand is not an Integer Number.");

		}
		if(!checkIfNumber(leftOperand.next().next().data())){
			throw new IllegalArgumentException("Right operand is not an Integer Number.");

		}
		
		
		BigInteger leftOperandInteger = new BigInteger(leftOperand.data());
		BigInteger rightOperandInteger = new BigInteger(leftOperand.next().next().data());
		BigInteger result = leftOperandInteger.add(rightOperandInteger);
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
		
		if(!checkIfNumber(leftOperand.data())){
			throw new IllegalArgumentException("Left operand is not an Integer Number.");

		}
		if(!checkIfNumber(leftOperand.next().next().data())){
			throw new IllegalArgumentException("Right operand is not an Integer Number.");

		}
		
		
		BigInteger leftOperandInteger = new BigInteger(leftOperand.data());
		BigInteger rightOperandInteger = new BigInteger(leftOperand.next().next().data());
		BigInteger result = leftOperandInteger.subtract(rightOperandInteger);
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
		
		if(!checkIfNumber(leftOperand.data())){
			throw new IllegalArgumentException("Left operand is not an Integer Number.");

		}
		if(!checkIfNumber(leftOperand.next().next().data())){
			throw new IllegalArgumentException("Right operand is not an Integer Number.");

		}
		
		
		BigInteger leftOperandInteger = new BigInteger(leftOperand.data());
		BigInteger rightOperandInteger = new BigInteger(leftOperand.next().next().data());
		BigInteger result = leftOperandInteger.multiply(rightOperandInteger);
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
		
		if(!checkIfNumber(leftOperand.data())){
			throw new IllegalArgumentException("Left operand is not an Integer Number.");

		}
		if(!checkIfNumber(leftOperand.next().next().data())){
			throw new IllegalArgumentException("Right operand is not an Integer Number.");

		}
		
		
		BigInteger leftOperandInteger = new BigInteger(leftOperand.data());
		BigInteger rightOperandInteger = new BigInteger(leftOperand.next().next().data());
		BigInteger result = leftOperandInteger.divide(rightOperandInteger);
		leftOperand.setData(result.toString());
		leftOperand.setNext(leftOperand.next().next().next());
		return;		
	}

	public boolean checkIfNumber(String in) {
			return in.matches("[0-9]+");
    }


}
