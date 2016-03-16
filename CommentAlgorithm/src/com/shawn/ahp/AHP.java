package com.shawn.ahp;

public class AHP {

	private final static String matrixLine[] = {
			// 0 1 2 3 4 5 6 7
			"1", "1", "1", "1", "1", "1", "1", "1", // 0
			"1", "1", "1", "1", "1", "1", "1", "1",// 1
			"1", "1", "1", "1", "1", "1", "1", "1",// 2
			"1", "1", "1", "1", "1", "1", "1", "1",// 3
			"1", "1", "1", "1", "1", "1", "1", "1",// 4
			"1", "1", "1", "1", "1", "1", "1", "1",// 5
			"1", "1", "1", "1", "1", "1", "1", "1",// 6
			"1", "1", "1", "1", "1", "1", "1", "1"// 7
	};

	private final static int rowNum = 8; //行数
	private final static int columnNum = 8; //列数
	private static double[][] matrix = new double[rowNum][columnNum];

	public static void main(String[] args) {
		int idx = 0;
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				matrix[i][j] = AHPUtil.CalculationFormula(matrixLine[idx]);
				idx++;
			}
		}

		CheckResult cr = AHPUtil.checkCR(matrix);
		System.out.println(cr.toString());
	}

}
