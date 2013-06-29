package core;

/**
 * Class executes primitive mathematical operations.
 * @author Fabian Wagner
 * @since 03/07/12
 * @version 1.0
 */
public abstract class Calculator {

	/**
	 * This sign is describing a addition.
	 */
	public final static String SIGN_ADD = "+";
	
	/**
	 * This sign is describing a subtraction.
	 */
	public final static String SIGN_SUB = "-";
	
	/**
	 * This sign is describing a multiplication.
	 */
	public final static String SIGN_MUL = "*";
	
	/**
	 * This sign is describing a division.
	 */
	public final static String SIGN_DIV = "/";
	
	/**
	 * This sign is describing a swap.
	 */
	public final static String SIGN_SWAP= "#";	
	
	/**
	 * This sign is describing a beginning of a function definition.
	 */
	public final static String SIGN_BEGIN_FUNCTION_DEFINITION = ":";
	
	
	/**
	 * Method is doing an addition given by a IListElement. While computing the result the method is accessing
	 * the next and the after next IListElement.<br>
	 * <b>Short</b> description of the method:<br>
	 * <i>IListElement</i>: ->leftOperand->operator->rightOperand-> => <i>IListElement</i>: ->result-> <br>
	 * with: result=leftOperand+rightOperand
	 * 
	 * @param leftOperand
	 * 			describes the left operand of the addition and maintains the pointer for the operator 
	 * (the operator has to maintain the pointer of the right operand)
	 * 
	 * @throws IllegalArgumentException
	 * 			throws an IllegalArgumentException if the left operand or right operand is no number
	 * 			OR the operand sign is no SIGN_ADD
	 * @see SIGN_ADD
	 * @see IListElement
	 */
	public abstract void add(IListElement leftOperand) throws IllegalArgumentException;
	
	/**
	 * Method is doing a subtraction given by a IListElement. While computing the result the method is accessing
	 * the next and the after next IListElement.<br>
	 * <b>Short</b> description of the method:<br>
	 * <i>IListElement</i>: ->leftOperand->operator->rightOperand-> => <i>IListElement</i>: ->result-> <br>
	 * with: result=leftOperand-rightOperand
	 * 
	 * @param leftOperand
	 * 			describes the left operand of the subtraction and maintains the pointer for the operator 
	 * (the operator has to maintain the pointer of the right operand)
	 * 
	 * @throws IllegalArgumentException
	 * 			throws an IllegalArgumentException if the left operand or right operand is no number
	 * 			OR the operand sign is no SIGN_SUB
	 * @see SIGN_SUB
	 * @see IListElement
	 */
	public abstract void sub(IListElement leftOperand) throws IllegalArgumentException;
	
	/**
	 * Method is doing a multiplication given by a IListElement. While computing the result the method is accessing
	 * the next and the after next IListElement.<br>
	 * <b>Short</b> description of the method:<br>
	 * <i>IListElement</i>: ->leftOperand->operator->rightOperand-> => <i>IListElement</i>: ->result-> <br>
	 * with: result=leftOperand*rightOperand
	 * 
	 * @param leftOperand
	 * 			describes the left operand of the multiplication and maintains the pointer for the operator 
	 * (the operator has to maintain the pointer of the right operand)
	 * 
	 * @throws IllegalArgumentException
	 * 			throws an IllegalArgumentException if the left operand or right operand is no number
	 * 			OR the operand sign is no SIGN_MUL
	 * @see SIGN_MUL
	 * @see IListElement
	 */
	public abstract void mul(IListElement leftOperand) throws IllegalArgumentException;
	
	/**
	 * Method is doing a division given by a IListElement. While computing the result the method is accessing
	 * the next and the after next IListElement.<br>
	 * <b>Short</b> description of the method:<br>
	 * <i>IListElement</i>: ->leftOperand->operator->rightOperand-> => <i>IListElement</i>: ->result-> <br>
	 * with: result=leftOperand/rightOperand
	 * 
	 * @param leftOperand
	 * 			describes the left operand of the division and maintains the pointer for the operator 
	 * (the operator has to maintain the pointer of the right operand)
	 * 
	 * @throws IllegalArgumentException
	 * 			throws an IllegalArgumentException if the left operand or right operand is no number
	 * 			OR the operand sign is no SIGN_DIV
	 * @see SIGN_DIV
	 * @see IListElement
	 */
	public abstract void div(IListElement leftOperand) throws IllegalArgumentException;

	
	/**
	 * Method is doing a swap operation given by a IListElement. While doing the swap the method is accessing
	 * the next and the after next IListElement.<br>
	 * <b>Short</b> description of the method:<br>
	 * <i>IListElement</i>: ->leftOperand->#->operator->rightOperand-> => <i>rightOperand->operator->leftOperand</i>: ->result-> <br>
	 * 
	 * @param leftOperand
	 * 			describes the left operand of the swap operation and maintains the pointer for the operator 
	 * (the operator has to maintain the pointer of operation and so on)
	 * 
	 * @throws IllegalArgumentException
	 * 			throws an IllegalArgumentException if the left operand or right operand is no number
	 * 			OR the operand sign is no SIGN_SWAP
	 * @see SIGN_DIV
	 * @see IListElement
	 */
	public void swap(IListElement leftOperand) throws IllegalArgumentException {
		// TODO implement this method in task 3.
	}

	
	
}
