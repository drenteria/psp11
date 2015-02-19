package edu.uniandes.ecos.psp11.model;

import java.util.Hashtable;
import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RelativeSizeCalculatorTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public RelativeSizeCalculatorTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(RelativeSizeCalculatorTest.class);
	}

	/**
	 * Performs the Test 01 (LOC/Method relative size Ranges)
	 */
	public void testLOCByMethodRelativeRanges() {
		
		System.out.println("Test 01: LOC/Method");
		
		LinkedList<Double> locByMethod = new LinkedList<Double>();
		locByMethod.add(6.0000D);
		locByMethod.add(6.0000D);
		locByMethod.add(8.3333D);
		locByMethod.add(10.3333D);
		locByMethod.add(12.3333D);
		locByMethod.add(16.4000D);
		locByMethod.add(20.5000D);
		locByMethod.add(21.7500D);
		locByMethod.add(22.2500D);
		locByMethod.add(23.0000D);
		locByMethod.add(28.3333D);
		locByMethod.add(29.0000D);
		locByMethod.add(55.8000D);

		RelativeSizeCalculator relativeCalc = new RelativeSizeCalculator();
		Hashtable<String, Double> relativeRanges = relativeCalc
				.calculateRelativeSizeRanges(locByMethod);

		System.out.println("Input Data: " + locByMethod.toString());
		System.out.println("RelativeRanges: " + relativeRanges.toString());

		assertEquals(4.3953D, relativeRanges.get(RelativeSizeCalculator.VS), 0.0001);
		assertEquals(8.5081D, relativeRanges.get(RelativeSizeCalculator.S), 0.0001);
		assertEquals(16.4696D, relativeRanges.get(RelativeSizeCalculator.M), 0.0001);
		assertEquals(31.8811D, relativeRanges.get(RelativeSizeCalculator.L), 0.0001);
		assertEquals(61.7137D, relativeRanges.get(RelativeSizeCalculator.VL), 0.0001);

	}

	/**
	 * Performs the Test 02 (Pages per chapter relative size ranges)
	 */
	public void testPagesPerChapterRelativeRanges() {

		System.out.println("Test 02: Pages Per Chapter");

		LinkedList<Double> pagesPerChapter = new LinkedList<Double>();
		pagesPerChapter.add(7D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(10D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(10D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(12D);
		pagesPerChapter.add(8D);
		pagesPerChapter.add(8D);
		pagesPerChapter.add(8D);
		pagesPerChapter.add(20D);
		pagesPerChapter.add(14D);
		pagesPerChapter.add(18D);
		pagesPerChapter.add(12D);

		RelativeSizeCalculator relativeCalc = new RelativeSizeCalculator();
		Hashtable<String, Double> relativeRanges = relativeCalc
				.calculateRelativeSizeRanges(pagesPerChapter);

		System.out.println("Input Data: " + pagesPerChapter.toString());
		System.out.println("RelativeRanges: " + relativeRanges.toString());

		assertEquals(6.3375D, relativeRanges.get(RelativeSizeCalculator.VS), 0.0001);
		assertEquals(8.4393D, relativeRanges.get(RelativeSizeCalculator.S), 0.0001);
		assertEquals(11.2381D, relativeRanges.get(RelativeSizeCalculator.M), 0.0001);
		assertEquals(14.9650D, relativeRanges.get(RelativeSizeCalculator.L), 0.0001);
		assertEquals(19.9280D, relativeRanges.get(RelativeSizeCalculator.VL), 0.0001);
	}

}
