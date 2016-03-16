package com.shawn.ahp;

import java.util.Arrays;

public class CheckResult {
	public double[][] body;
	public double[] w;
	public double r;
	public double CI;
	public double CR;
	public boolean success = false;

	@Override
	public String toString() {
		char r = 13;
		char n = 10;
		StringBuffer sb = new StringBuffer();
		sb.append("AHP矩阵={").append(r).append(n);
		for (int i = 0; i < body.length; i++) {
			String bodyLine = Arrays.toString(body[i]);
			sb.append(bodyLine).append(r).append(n);
		}
		sb.append("}").append(r).append(n);
		sb.append("权重计算").append(r).append(n);
		sb.append("特征向量W=").append(Arrays.toString(w)).append(r).append(n);
		sb.append("最大特征根r=" + this.r + ", 一致性指标CI=" + CI + ", 当前节点的检验系数CR=" + CR + ", 一致性达标=" + success);
		return sb.toString();
	}

}
