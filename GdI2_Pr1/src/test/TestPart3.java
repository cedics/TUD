package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import math.MathElement;
import math.MathList;
import math.PointNumberCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPart3 {

	private HashMap<String, MathList> EXPRESSIONS = new HashMap<String, MathList>();
	private MathList functions = new MathList();
	private MathList functions2 = new MathList();

	private String exp0 = "3#-4";
	private String exp1 = "(43#-44)#/(8-5)#*6#/5";
	private String exp2 = "(10+((30-(40.5))))*doubledif(54.3,85.3)+square(2)-doubledif(3,4)";
	private String exp3 = "(square(100)*21+((doubledif(100000,100000))))";

	private String fun1 = "x#*x";
	private String fun2 = "@parameter1@*2-2*@parameter2@";

	@Before
	@After
	public void setUp() {
		EXPRESSIONS.put("Expression0", new MathList(new PointNumberCalculator()));
		EXPRESSIONS.put("Expression1", new MathList(new PointNumberCalculator()));
		EXPRESSIONS.put("Expression2", new MathList(new PointNumberCalculator()));
		EXPRESSIONS.put("Expression3", new MathList(new PointNumberCalculator()));

		EXPRESSIONS.get("Expression0").buildList(this.exp0);
		EXPRESSIONS.get("Expression1").buildList(this.exp1);
		EXPRESSIONS.get("Expression2").buildList(this.exp2);
		EXPRESSIONS.get("Expression3").buildList(this.exp3);

		EXPRESSIONS.get("Expression0").assemblePointNumbers();
		EXPRESSIONS.get("Expression1").assemblePointNumbers();
		EXPRESSIONS.get("Expression2").assemblePointNumbers();
		EXPRESSIONS.get("Expression3").assemblePointNumbers();


		this.functions.addElement(new MathElement("square"));
		this.functions.addElement(new MathElement("x"));
		this.functions.addElement(new MathElement(":"));
		this.functions.addElement(new MathElement(this.fun1));


		this.functions.addElement(new MathElement("doubledif"));
		this.functions.addElement(new MathElement("@parameter1@"));
		this.functions.addElement(new MathElement("@parameter2@"));
		this.functions.addElement(new MathElement(":"));
		this.functions.addElement(new MathElement(this.fun2));

		this.functions2.addElement(new MathElement("square"));
		this.functions2.addElement(new MathElement("("));
		this.functions2.addElement(new MathElement("x"));
		this.functions2.addElement(new MathElement(")"));
		this.functions2.addElement(new MathElement(":"));
		this.functions2.addElement(new MathElement(this.fun1));
		this.functions2.addElement(new MathElement(""));


		this.functions2.addElement(new MathElement("doubledif"));
		this.functions2.addElement(new MathElement("("));
		this.functions2.addElement(new MathElement("@parameter1@"));
		this.functions2.addElement(new MathElement(","));
		this.functions2.addElement(new MathElement("@parameter2@"));
		this.functions2.addElement(new MathElement(")"));
		this.functions2.addElement(new MathElement(":"));
		this.functions2.addElement(new MathElement(this.fun2));

	}

	@Test(timeout = 10000)
	public void testSwapOperationSimple() {

		EXPRESSIONS.get("Expression0").evaluate();
		MathList resultMathList = new MathList(new MathElement("1"));
		assertTrue(resultMathList.equals(EXPRESSIONS.get("Expression0")));

	}

	@Test(timeout = 10000)
	public void testSwapOperationExtended() {

		EXPRESSIONS.get("Expression1").evaluate();
		MathList resultMathList = new MathList(new MathElement("2.5"));
		assertTrue(resultMathList.equals(EXPRESSIONS.get("Expression1")));

	}


	@Test(timeout = 10000)
	public void testExpression2AssembleFunctionNamesSize() {
		EXPRESSIONS.get("Expression2").assembleFunctionNames();
		assertEquals(32, EXPRESSIONS.get("Expression2").size());
	}

	@Test(timeout = 10000)
	public void testExpression3AssemembleFunctionNamesSize() {
		EXPRESSIONS.get("Expression3").assembleFunctionNames();
		assertEquals(19, EXPRESSIONS.get("Expression3").size());
	}


	@Test(timeout = 10000)
	public void testExpression2AssemembleFunctionNamesElements() {
		EXPRESSIONS.get("Expression2").assembleFunctionNames();
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("30"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("40.5"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("doubledif"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("54.3"));
		list.addElement(new MathElement(","));
		list.addElement(new MathElement("85.3"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("square"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("2"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("doubledif"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement(","));
		list.addElement(new MathElement("4"));
		list.addElement(new MathElement(")"));

		assertTrue(list.equals(EXPRESSIONS.get("Expression2")));
	}
	@Test(timeout = 10000)

	public void testExpression3AssemembleFunctionNamesElements() {
		EXPRESSIONS.get("Expression3").assembleFunctionNames();
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("square"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("100"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("21"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("doubledif"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("100000"));
		list.addElement(new MathElement(","));
		list.addElement(new MathElement("100000"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));

		assertTrue(list.equals(EXPRESSIONS.get("Expression3")));

	}

	@Test(timeout = 10000)
	public void testInterpretFunctionDefinitions() {
		boolean test1_1 = false, test1_2 = false, test2_1 = false, test2_2 = false;
		try {
			HashMap<String, String> def = EXPRESSIONS.get("Expression1").interpretFunctionDefinitions(this.functions);

			String funSquare = def.get("square");
			test1_1 = "x|x#*x".equals(funSquare);

			String funDoubleDif1 = "@parameter1@|@parameter2@|@parameter1@*2-2*@parameter2@";
			String funDoubleDif2 = "@parameter2@|@parameter1@|@parameter1@*2-2*@parameter2@";
			test1_2 = funDoubleDif1.equals(def.get("doubledif")) || funDoubleDif2.equals(def.get("doubledif"));
		} catch (Exception e) {}

		try {
			HashMap<String, String> def = EXPRESSIONS.get("Expression1").interpretFunctionDefinitions(this.functions2);

			String funSquare = def.get("square");
			test2_1 = "x|x#*x".equals(funSquare);

			String funDoubleDif1 = "@parameter1@|@parameter2@|@parameter1@*2-2*@parameter2@";
			String funDoubleDif2 = "@parameter2@|@parameter1@|@parameter1@*2-2*@parameter2@";
			test2_2 = funDoubleDif1.equals(def.get("doubledif")) || funDoubleDif2.equals(def.get("doubledif"));
		} catch (Exception e) {}

		assertTrue((test1_1 && test1_2) || (test2_1 && test2_2));
	}

	@Test(timeout = 10000)
	public void testExpression2InlineFunctions() {
		boolean test1_1 = false, test1_2 = false, test2_1 = false, test2_2 = false;
		EXPRESSIONS.get("Expression2").assembleFunctionNames();

		try {
			EXPRESSIONS.get("Expression2").inlineFunctions(this.functions);
			test1_1 = 40 ==  EXPRESSIONS.get("Expression2").size();


			MathList list = new MathList();
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("10"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("30"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("40.5"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("54.3"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("85.3"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("#"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("3"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("4"));
			list.addElement(new MathElement(")"));

			test1_2 = list.equals(EXPRESSIONS.get("Expression2"));
		}catch(Exception e) {}

		this.setUp();
		EXPRESSIONS.get("Expression2").assembleFunctionNames();
		try {
			EXPRESSIONS.get("Expression2").inlineFunctions(this.functions2);
			test2_1 = 40 == EXPRESSIONS.get("Expression2").size();


			MathList list = new MathList();
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("10"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("30"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("40.5"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("54.3"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("85.3"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("#"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("3"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("4"));
			list.addElement(new MathElement(")"));

			test2_2 = list.equals(EXPRESSIONS.get("Expression2"));
		}catch(Exception e) {}


		assertTrue((test1_1 && test1_2) || (test2_1 && test2_2));
	}

	@Test(timeout = 10000)
	public void testExpression3InlineFunctions() {
		boolean test1_1 = false, test1_2 = false, test2_1 = false, test2_2 = false;
		EXPRESSIONS.get("Expression3").assembleFunctionNames();

		try {
			EXPRESSIONS.get("Expression3").inlineFunctions(this.functions);
			test1_1 = 24 ==  EXPRESSIONS.get("Expression3").size();
			
			MathList list = new MathList();
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("100"));
			list.addElement(new MathElement("#"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("100"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("21"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("100000"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("100000"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));

			test1_2 = list.equals(EXPRESSIONS.get("Expression3"));
			
		}catch(Exception e) {}

		this.setUp();
		EXPRESSIONS.get("Expression3").assembleFunctionNames();
		try {
			EXPRESSIONS.get("Expression3").inlineFunctions(this.functions2);
			test2_1 = 24 == EXPRESSIONS.get("Expression3").size();


			MathList list = new MathList();
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("100"));
			list.addElement(new MathElement("#"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("100"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("21"));
			list.addElement(new MathElement("+"));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("("));
			list.addElement(new MathElement("100000"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("-"));
			list.addElement(new MathElement("2"));
			list.addElement(new MathElement("*"));
			list.addElement(new MathElement("100000"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));
			list.addElement(new MathElement(")"));

			test2_2 = list.equals(EXPRESSIONS.get("Expression3"));
		}catch(Exception e) {}


		assertTrue((test1_1 && test1_2) || (test2_1 && test2_2));
	}
}
