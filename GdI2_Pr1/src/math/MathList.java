package math;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.hamcrest.core.IsNull;

import core.Calculator;
import core.IListElement;
import core.LinkedList;


/**
 * Class for computing primitive operations.
 * 
 * @author Fabian Wagner
 * @since 03/07/12
 * @version 1.0
 */
public class MathList extends LinkedList<MathElement> {

	private Calculator calc = null;

	/**
	 * Creates a new empty MathList. The Calculator will be set to an
	 * IntegerCalculator.
	 * 
	 * @see IntegerCalculator
	 * @see LinkedList
	 */
	public MathList() {
		this.calc = new IntegerCalculator();
	}

	/**
	 * Creates a new MathList by given the first element. The Calculator will be
	 * set to an IntegerCalculator.
	 * 
	 * @param first
	 *            describes the first element of the MathList
	 * 
	 * @see IntegerCalculator
	 * @see LinkedList
	 * @see MathElement
	 */
	public MathList(MathElement first) {
		this.calc = new IntegerCalculator();
		this.first = first;
		this.last = first;
	}

	/**
	 * Creates a new MathList by given matching Calculator
	 * 
	 * @param calculator
	 *            describes the calculator which is needed
	 * @see Calculator
	 * @see LinkedList
	 * @see MathElement
	 */
	public MathList(Calculator calculator) {
		this.calc = calculator;
	}

	/**
	 * Creates a new MathList by given the first element and a matching
	 * Calculator
	 * 
	 * @param first
	 *            describes the first element of the MathList
	 * @param calculator
	 *            describes the calculator which is needed
	 * @see Calculator
	 * @see LinkedList
	 * @see MathElement
	 */
	public MathList(MathElement first, Calculator calculator) {
		this.calc = calculator;
		this.first = first;
		this.last = first;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public void addElement(MathElement mathElement) {
		if(this.first == null){
			this.first = mathElement;
			this.last = mathElement;
		}else{
			last.setNext(mathElement);
			last = mathElement;
		}
	}

	/**
	 * Builds a <tt>MathList</tt> by a given string. Each character will added
	 * as one Element in the returned list.
	 * 
	 * @param term
	 *            represents a mathematical term as a string
	 */
	public void buildList(String term) {
		
		for (int i = 0; i < term.length(); i++) {
			String substring = term.substring(i,i+1);
			this.addElement(new MathElement(substring));
		}
		
		
	}

	/**
	 * Assembles all consecutive digits in the list.
	 * 
	 * @see Calculator
	 */
	public void assembleNumbers() {

		
		IListElement candidatePointer = null;
		StringBuffer sb = new StringBuffer();
		
		if(this.first != null){
		IListElement pivot = this.first;

		//Go through the List
		while(true){
			//Number? 
			if(checkIfNumber(pivot.data())){

					//Seen a Number before?
					if(candidatePointer == null){
						candidatePointer = pivot;
					}	
					//append to build a Number
					sb.append(pivot.data());
				
			}else{
					//No Number,
					//end of a Number?
					if(candidatePointer != null){
					candidatePointer.setData(sb.toString());
					sb = new StringBuffer();
					candidatePointer.setNext(pivot);
					candidatePointer = null;
					}
				}
			
			if(pivot.hasNext()){
				pivot = pivot.next();
			}else{
				//No Number,
				//end of a Number?
				if(candidatePointer != null){
				candidatePointer.setData(sb.toString());
				candidatePointer.setNext(null);
				
				}
				break;
			}
			
		}

		}
	}
	
	public boolean checkIfNumber(String in) {
		//System.out.println(in+" :"+in.matches("[0-9]+"));
			return in.matches("[0-9]+");
    }

	/**
	 * Extracts all consecutive digits and dots in the list.
	 * 
	 * @see Calculator
	 */
	public void assemblePointNumbers() {
		IListElement candidatePointer = null;
		StringBuffer sb = new StringBuffer();
		
		if(this.first != null){
		IListElement pivot = this.first;

		//Go through the List
		while(true){
			//Number? 
			if(checkIfNumber(pivot.data())){

					//Seen a Number before?
					if(candidatePointer == null){
						candidatePointer = pivot;
					}	
					//append to build a Number
					sb.append(pivot.data());
				
			}else{
					if(pivot.data().compareTo(".") == 0){
						//append to build a Number
						sb.append(pivot.data());
					}else{
						//No Number,
						//end of a Number?
						if(candidatePointer != null){
						candidatePointer.setData(sb.toString());
						sb = new StringBuffer();
						candidatePointer.setNext(pivot);
						candidatePointer = null;
						}
					}
				}
			
			if(pivot.hasNext()){
				pivot = pivot.next();
			}else{
				//No Number,
				//end of a Number?
				if(candidatePointer != null){
				candidatePointer.setData(sb.toString());
				candidatePointer.setNext(null);
				
				}
				break;
			}
			
		}

		}
		
	}

	/**
	 * Extracts all function names in the list.
	 * 
	 * @see Calculator
	 */
	public void assembleFunctionNames() {
		// TODO implement this in task 3
	}

	/**
	 * Tells if the MathList holds only a simple atom number or a simple atom
	 * point number by using the RegEx-stirng of Calculator.
	 * 
	 * @return true if the MathList is atom otherwise false.
	 * @see Calculator
	 */
	public boolean isAtom() {
		// TODO implement this in task 2
		return false;
	}

	/**
	 * Returns a pointer to the left operator of an multiplication or a
	 * division.
	 * 
	 * @return a pointer to a left operator
	 */
	public IListElement findMulOrDivOperation() {
		// TODO implement this in task 2
		return null;
	}

	/**
	 * Returns a pointer to the left operator of an addition or a subtraction.
	 * 
	 * @return a pointer to a left operator
	 */
	public IListElement findAddOrSubOperation() {
		// TODO implement this in task 2
		return null;
	}

	/**
	 * Returns the beginning of the first innermost expression of the entire
	 * expression.
	 * 
	 * @return the beginning of the first innermost expression.
	 */
	public IListElement findInnermostExpression() {
		// TODO implement this in task 2
		return null;
	}

	/**
	 * Evaluates a simple expression.
	 * 
	 * @param begin
	 *            represents the beginning of the simple expression. The method
	 *            expects an opening parenthesis if there are any parentheses in
	 *            the expression. Otherwise the begin must be the first left
	 *            operand of the expression.
	 */
	public void evaluateSimpleExpression(IListElement begin) {
		// TODO implement this in task 2
	}

	/**
	 * Evaluates a math. expression without functions. The result is a MathList
	 * with one number inside. This element is the result of the expression.
	 */
	public void evaluate() {
		// TODO implement this in task 2
	}


	/**
	 * Decomposes all function by a given function definition. Defined functions
	 * must be a MathList with following pattern: <br>
	 * <b>function name 1</b>|parameter 1|...|parameter n|:|definition|
	 * <b>function name 2</b>|...<br>
	 * Definition describes an math. term with primitive operations and the
	 * parameters of the function.
	 * 
	 * @param functions
	 *            describes the definition of the functions.
	 */
	public void inlineFunctions(MathList functions) {
		// TODO implement this in task 3
	}

	/**
	 * Interprets the function definitions and returns a HashMap which is
	 * holding all functions.
	 * 
	 * @param functions
	 *            describes the given function definitions
	 * @return a HashMap which describes all functions with the function name as
	 *         key.
	 */
	public HashMap<String, String> interpretFunctionDefinitions(
			MathList functions) {
		// TODO implement this in task 3
		return null;
	}

	/**
	 * Returns the size of the MathList.
	 * 
	 * @return the size of the list.
	 */
	public int size() {
		IListElement pivot = this.first;
		int size = 0;
		while (pivot != null) {
			size++;
			pivot = pivot.next();
		}
		return size;
	}


	public int hashCode() {
		int hashCode = 0;
		IListElement pivot = this.first;
		while(pivot != null) {
			hashCode += pivot.data().hashCode();
			pivot = pivot.next();
		}
		return hashCode;
	}

	/**
	 * Tells if two MathList are equal.
	 */
	public boolean equals(Object obj) {

		if (!(obj instanceof MathList))
			return false;
		MathList list = (MathList) obj;
		if (this.size() != list.size())
			return false;

		IListElement pivot = this.first;
		IListElement pivot2 = list.first;

		while (pivot != null) {
			if (!pivot.data().equals(pivot2.data()))
				return false;

			pivot = pivot.next();
			pivot2 = pivot2.next();
		}
		return true;

	}
}
