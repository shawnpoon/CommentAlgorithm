package com.shawn.ahp;

public class AHPUtil {

	// 经验RI数组
	public static double[] RI = { 0, 0, 0.58, 0.9, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1.51 };

	// 对比较矩阵进行归一化，返回特征向量W
	public static double[] normalize(double[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		double[] Sum_column = new double[column];
		for (int i = 0; i < column; i++) {
			Sum_column[i] = 0;
			for (int j = 0; j < row; j++) {
				Sum_column[i] += matrix[j][i];
			}
		}
		// 进行归一化,计算特征向量W
		double[] w = new double[row];
		for (int i = 0; i < row; i++) {
			w[i] = 0;
			for (int j = 0; j < column; j++) {
				w[i] += matrix[i][j] / Sum_column[j];
			}
			w[i] /= row;
		}
		return w;
	}

	// 进行一致性校验
	public static CheckResult checkCR(double[][] matrix) {
		CheckResult res = new CheckResult();
		int row = matrix.length;
		int column = matrix[0].length;
		res.w = AHPUtil.normalize(matrix);
		// 计算AW
		double[] aw = new double[row];
		for (int i = 0; i < row; i++) {
			aw[i] = 0;
			for (int j = 0; j < column; j++) {
				aw[i] += matrix[i][j] * res.w[j];
			}
		}
		res.body = matrix;
		// 求和
		double sum = 0;
		for (int i = 0; i < row; i++) {
			sum += aw[i] / res.w[i];
		}
		// 最大特征根
		res.r = sum / column;
		// 一致性指标
		res.CI = (res.r - column) / (column - 1);
		// 当前节点的检验系数
		res.CR = res.CI / AHPUtil.RI[column - 1];
		if (res.CR < 0.1) {
			res.success = true;
		}
		return res;
	}

	// 将类似1/3格式的字符串转为数字
	public static double CalculationFormula(String formula) {
		if (formula.indexOf('/') > 0) {
			String[] kt = formula.split("/");
			return Double.parseDouble(kt[0]) / Double.parseDouble(kt[1]);
		}
		return Double.parseDouble(formula);
	}

	public static double[] weight(double[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		double[] weight = new double[row];
		double[] sum = new double[row];
		double sumTotal = 0d;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				sum[i] += matrix[i][j];
			}
			sumTotal += sum[i];
		}
		for (int i = 0; i < sum.length; i++) {
			weight[i] = sum[i] / sumTotal;
		}
		return weight;
	}

}
