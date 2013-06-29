package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import math.MathElement;
import math.MathList;
import math.PointNumberCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPart1 {

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

	//-----------------------------------------------------------------------------------------------------------

	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionBuildListSize() {
		assertEquals(16, EXPRESSIONS.get("simpleIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionBuildListSize() {
		assertEquals(32, EXPRESSIONS.get("simplePointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testLongIntegerExpressionBuildListSize() {
		assertEquals(61, EXPRESSIONS.get("longIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testLongPointNumberExpressionBuildListSize() {
		assertEquals(61, EXPRESSIONS.get("longPointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testBigIntegerExpressionBuildListSize() {
		assertEquals(115, EXPRESSIONS.get("bigIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testBigPointNumberExpressionBuildListSize() {
		assertEquals(125, EXPRESSIONS.get("bigPointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionBuildListElements() {
		boolean aFlag = true;
		for(int i = 0; i<16; i++) {
			if(!EXPRESSIONS.get("simpleIntegerExpression").get(i).data().equals(Character.toString(this.exp1.charAt(i)))) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionBuildListElements() {
		boolean aFlag = true;
		aFlag = true;
		for(int i = 0; i<32; i++) {
			if(!EXPRESSIONS.get("simplePointNumberExpression").get(i).data().equals(Character.toString(this.exp2.charAt(i)))) {
				aFlag = false;
			}
			aFlag &= aFlag;
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testLongIntegerExpressionBuildListElements() {
		boolean aFlag = true;
		aFlag = true;
		for(int i = 0; i<61; i++) {
			if(!EXPRESSIONS.get("longIntegerExpression").get(i).data().equals(Character.toString(this.exp3.charAt(i)))) {
				aFlag = false;
			}
			aFlag &= aFlag;
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testLongPointNumberExpressionBuildListElements() {
		boolean aFlag = true;
		aFlag = true;
		for(int i = 0; i<61; i++) {
			if(!EXPRESSIONS.get("longPointNumberExpression").get(i).data().equals(Character.toString(this.exp4.charAt(i)))) {
				aFlag = false;
			}
			aFlag &= aFlag;
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testBigIntegerExpressionBuildListElements() {
		boolean aFlag = true;
		aFlag = true;
		for(int i = 0; i<115; i++) {
			if(!EXPRESSIONS.get("bigIntegerExpression").get(i).data().equals(Character.toString(this.exp5.charAt(i)))) {
				aFlag = false;
			}
			aFlag &= aFlag;
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testBigPointNumberExpressionBuildListElements() {
		boolean aFlag = true;
		aFlag = true;
		for(int i = 0; i<115; i++) {
			if(!EXPRESSIONS.get("bigPointNumberExpression").get(i).data().equals(Character.toString(this.exp6.charAt(i)))) {
				aFlag = false;
			}
			aFlag &= aFlag;
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("simpleIntegerExpression").assembleNumbers();
		assertEquals(13, EXPRESSIONS.get("simpleIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("simplePointNumberExpression").assembleNumbers();
		assertEquals(27, EXPRESSIONS.get("simplePointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testLongIntegerExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("longIntegerExpression").assembleNumbers();
		assertEquals(51, EXPRESSIONS.get("longIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testLongPointNumberExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("longPointNumberExpression").assembleNumbers();
		assertEquals(45, EXPRESSIONS.get("longPointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testBigIntegerExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("bigIntegerExpression").assembleNumbers();
		assertEquals(9, EXPRESSIONS.get("bigIntegerExpression").size());
	}

	@Test(timeout = 10000)
	public void testBigPointNumberExpressionAssembleNumbersSize() {
		EXPRESSIONS.get("bigPointNumberExpression").assembleNumbers();
		assertEquals(15, EXPRESSIONS.get("bigPointNumberExpression").size());
	}

	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("simpleIntegerExpression").assembleNumbers();
		MathList list = new MathList();
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("6"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("100"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("2"));

		boolean aFlag = true;
		for(int i = 0; i<13; i++) {
			if(!EXPRESSIONS.get("simpleIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("simplePointNumberExpression").assembleNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("1"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("17"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("4"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("7"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("4"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("2354"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("7"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("7"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("1"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));

		aFlag = true;
		for(int i = 0; i<27; i++) {
			if(!EXPRESSIONS.get("simplePointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testLongIntegerExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("longIntegerExpression").assembleNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("33"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("43"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("434"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("45"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("52"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("6"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("100"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("1"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));

		aFlag = true;
		for(int i = 0; i<51; i++) {
			if(!EXPRESSIONS.get("longIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);	
	}

	@Test(timeout = 10000)
	public void testLongPointNumberExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("longPointNumberExpression").assembleNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("42"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("24"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("12686"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("6343"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("123"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("232"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("23"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("43"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("4"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("12"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("6"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("9"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));

		aFlag = true;
		for(int i = 0; i<45; i++) {
			if(!EXPRESSIONS.get("longPointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}

	@Test(timeout = 10000)
	public void testBigIntegerExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("bigIntegerExpression").assembleNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("8923747823478892340892304"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("47823748927394789"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("253728457832423423424"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("12312312312313123123123"));

		aFlag = true;
		for(int i = 0; i<9; i++) {
			if(!EXPRESSIONS.get("bigIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);

	}

	@Test(timeout = 10000)
	public void testBigPointNumberExpressionAssembleNumbersElements() {
		EXPRESSIONS.get("bigPointNumberExpression").assembleNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("8923747823478892340892304"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("47823748927394789"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("12312312312313123123123"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2"));
		list.addElement(new MathElement("."));
		list.addElement(new MathElement("3"));

		aFlag = true;
		for(int i = 0; i<15; i++) {
			if(!EXPRESSIONS.get("bigPointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}

		assertTrue(aFlag);
	}


	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("simpleIntegerExpression").assemblePointNumbers();
		assertEquals(13, EXPRESSIONS.get("simpleIntegerExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("simplePointNumberExpression").assemblePointNumbers();
		assertEquals(19, EXPRESSIONS.get("simplePointNumberExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testLongIntegerExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("longIntegerExpression").assemblePointNumbers();
		assertEquals(51, EXPRESSIONS.get("longIntegerExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testLongPointNumberExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("longPointNumberExpression").assemblePointNumbers();
		assertEquals(35, EXPRESSIONS.get("longPointNumberExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testBigIntegerExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("bigIntegerExpression").assemblePointNumbers();
		assertEquals(9, EXPRESSIONS.get("bigIntegerExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testBigPointNumberExpressionAssemblePointNumbersSize() {
		EXPRESSIONS.get("bigPointNumberExpression").assemblePointNumbers();
		assertEquals(13, EXPRESSIONS.get("bigPointNumberExpression").size());
	}
	
	@Test(timeout = 10000)
	public void testSimpleIntegerExpressionAssemblePointNumbersElements() {
		EXPRESSIONS.get("simpleIntegerExpression").assemblePointNumbers();
		MathList list = new MathList();
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("6"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("100"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("2"));

		boolean aFlag = true;
		for(int i = 0; i<13; i++) {
			if(!EXPRESSIONS.get("simpleIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}
	
	@Test(timeout = 10000)
	public void testSimplePointNumberExpressionAssemblePointNumbersElements() {
		EXPRESSIONS.get("simplePointNumberExpression").assemblePointNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("3.5"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("5.1"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("17"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("4.7"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("4"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("2354"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("7"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("7.0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("1"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));

		aFlag = true;
		for(int i = 0; i<19; i++) {
			if(!EXPRESSIONS.get("simplePointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}
	
	@Test(timeout = 10000)
	public void testLongIntegerExpressionAssemblePointNumbersElements() {
		EXPRESSIONS.get("longIntegerExpression").assemblePointNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("33"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("43"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("434"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("45"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("10"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("52"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("6"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("100"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("1"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("5"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));

		aFlag = true;
		for(int i = 0; i<51; i++) {
			if(!EXPRESSIONS.get("longIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}
	
	@Test(timeout = 10000)
	public void testLongPointNumberExpressionAssemblePointNumbersElements() {
		EXPRESSIONS.get("longPointNumberExpression").assemblePointNumbers();

		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("42.0"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("24"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("12686"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("6343"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("123.232"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("23"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("43"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("4.0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("0"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("3"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("12.0"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("6.9"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement(")"));
	
		aFlag = true;
		for(int i = 0; i<35; i++) {
			if(!EXPRESSIONS.get("longPointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		
		assertTrue(aFlag);
	}
	
	@Test(timeout = 10000)
	public void testBigIntegerExpressionAssemblePointNumbersElements() {
		EXPRESSIONS.get("bigIntegerExpression").assemblePointNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("8923747823478892340892304"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("47823748927394789"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("253728457832423423424"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("12312312312313123123123"));

		aFlag = true;
		for(int i = 0; i<9; i++) {
			if(!EXPRESSIONS.get("bigIntegerExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
	}
	
	@Test(timeout = 10000)
	public void testBigPointNumberExpressionAssemblePointNumbersElements() {
		
		EXPRESSIONS.get("bigPointNumberExpression").assemblePointNumbers();
		boolean aFlag;
		MathList list = new MathList();
		list.addElement(new MathElement("("));
		list.addElement(new MathElement("8923747823478892340892304"));
		list.addElement(new MathElement("+"));
		list.addElement(new MathElement("47823748927394789"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("/"));
		list.addElement(new MathElement("2347283479233434343434344"));
		list.addElement(new MathElement("-"));
		list.addElement(new MathElement("12312312312313123123123"));
		list.addElement(new MathElement(")"));
		list.addElement(new MathElement("*"));
		list.addElement(new MathElement("2.3"));

		aFlag = true;
		for(int i = 0; i<13; i++) {
			if(!EXPRESSIONS.get("bigPointNumberExpression").get(i).data().equals(list.get(i).data())) {
				aFlag = false;
			}
		}
		assertTrue(aFlag);
		
	}
	
}
