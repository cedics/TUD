package test;

import static org.junit.Assert.*;

import java.util.HashMap;


import math.IntegerCalculator;
import math.MathElement;
import math.MathList;
import math.PointNumberCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Calculator;
import core.IListElement;

public class TestPart2 {

	private HashMap<String, MathList> EXPRESSIONS = new HashMap<String, MathList>();

	private String exp1 = "3+5*6-5/10*100+2";
	private String exp2 = "3.5+5.1/17-4.7+4-2354*7/7.0-1/10";
	private String exp3 = "(33+43)*434-45/10+((10-52)*(6-100)*(0-1)+(5*(5*(5*(((5)))))))";
	private String exp4 = "42.0*24+(12686/6343*123.232-23+(43*4.0-(0-3)-(3/12.0*(6.9))))";
	private String exp5 = "8923747823478892340892304+47823748927394789*2347283479233434343434344/253728457832423423424-12312312312313123123123";
	private String exp6 = "(8923747823478892340892304+47823748927394789*2347283479233434343434344/2347283479233434343434344-12312312312313123123123)*2.3";

	@Before
	@After
	public void setUp() throws Exception {
		EXPRESSIONS.put("simpleIntegerExpression", new MathList());
		EXPRESSIONS.put("simplePointNumberExpression", new MathList(new PointNumberCalculator()));

		EXPRESSIONS.put("longIntegerExpression", new MathList());
		EXPRESSIONS.put("longPointNumberExpression", new MathList(new PointNumberCalculator()));

		EXPRESSIONS.put("bigIntegerExpression", new MathList());
		EXPRESSIONS.put("bigPointNumberExpression", new MathList(new PointNumberCalculator()));


		EXPRESSIONS.get("simpleIntegerExpression").buildList(this.exp1);
		EXPRESSIONS.get("simplePointNumberExpression").buildList(this.exp2);

		EXPRESSIONS.get("longIntegerExpression").buildList(this.exp3);
		EXPRESSIONS.get("longPointNumberExpression").buildList(this.exp4);

		EXPRESSIONS.get("bigIntegerExpression").buildList(this.exp5);
		EXPRESSIONS.get("bigPointNumberExpression").buildList(this.exp6);
	}
	//----------------------------------------------------------------------------------------------------------


	@Test(timeout = 10000)
	public void testExecuteOperationIntegerCalc() {
		IListElement leftOperand = EXPRESSIONS.get("simpleIntegerExpression").get(2);
		EXPRESSIONS.get("simpleIntegerExpression").assemblePointNumbers();


		Calculator calcInt = new IntegerCalculator();
		calcInt.mul(leftOperand);
		assertEquals("30", leftOperand.data());

		calcInt.sub(leftOperand);
		assertEquals("25", leftOperand.data());

		calcInt.div(leftOperand);
		assertEquals("2", leftOperand.data());

		leftOperand = EXPRESSIONS.get("simpleIntegerExpression").get(0);
		calcInt.add(leftOperand);
		assertEquals("5", leftOperand.data());	

	}
	@Test(timeout = 10000)
	public void testExecuteOperationPointNumberCalc() {
		EXPRESSIONS.get("simplePointNumberExpression").assemblePointNumbers();
		IListElement leftOperand = EXPRESSIONS.get("simplePointNumberExpression").get(2);

		Calculator calcPointNumber = new PointNumberCalculator();

		calcPointNumber.div(leftOperand);
		assertEquals("0.3", leftOperand.data());

		calcPointNumber.sub(leftOperand);
		assertEquals("-4.4", leftOperand.data());

		calcPointNumber.add(leftOperand);
		assertEquals("-0.4", leftOperand.data());

		leftOperand = EXPRESSIONS.get("simplePointNumberExpression").get(4);
		calcPointNumber.mul(leftOperand);
		assertEquals("16478", leftOperand.data());
	}


	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionEvaluate() {
		EXPRESSIONS.get("simpleIntegerExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("35"));
		assertEquals(resultMathList, EXPRESSIONS.get("simpleIntegerExpression"));
	}

	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionEvaluate() {
		EXPRESSIONS.get("simplePointNumberExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("-2351.0"));
		assertEquals(resultMathList, EXPRESSIONS.get("simplePointNumberExpression"));
	}

	@Test(timeout = 10000)
	public void testLongIntegerExpressionEvaluate() {
		EXPRESSIONS.get("longIntegerExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("29657"));
		assertEquals(resultMathList, EXPRESSIONS.get("longIntegerExpression"));
	}

	@Test(timeout = 10000)
	public void testLongPointNumberExpressionEvaluate() {
		EXPRESSIONS.get("longPointNumberExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("1404.739"));
		assertEquals(resultMathList, EXPRESSIONS.get("longPointNumberExpression"));
	}

	@Test(timeout = 10000)
	public void testBigIntegerExpressionEvaluate() {
		EXPRESSIONS.get("bigIntegerExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("8911877936492974499711696"));
		assertEquals(resultMathList, EXPRESSIONS.get("bigIntegerExpression"));
	}
	

	@Test(timeout = 10000)
	public void testBigPointNumberExpressionEvaluate() {
		EXPRESSIONS.get("bigPointNumberExpression").evaluate();
		MathList resultMathList = new MathList(new MathElement("20496301785677754733877131.0"));
		assertEquals(resultMathList, EXPRESSIONS.get("bigPointNumberExpression"));
	}
	
}
