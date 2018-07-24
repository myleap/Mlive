package org.myleap.mlive.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

public class UIUtils {
	/** 得到上下文 */
	public static Context getContext() {
		return MliveApp.getContext();
	}

	/** 得到Resource对象 */
	public static Resources getResources() {
		return getContext().getResources();
	}

	/** 得到String.xml中定义的字符 */
	public static String getString(int resId) {
		return getResources().getString(resId);
	}

	/** 得到String.xml中定义的字符,带占位符 */
	public static String getString(int resId, Object... formatArgs) {
		return getResources().getString(resId, formatArgs);
	}

	/** 得到String.xml中定义的字符数组 */
	public static String[] getStringArr(int resId) {
		return getResources().getStringArray(resId);
	}

	/** 得到color.xml中定义的颜色值 */
	public static int getColor(int resId) {
		return getResources().getColor(resId);
	}

	/** 得到应用程序的包名 */
	public static String getPackageName() {
		return getContext().getPackageName();
	}

	/** 得到主线程的id */
	public static long getMainThreadId() {
		return MliveApp.getMainThreadId();
	}

	/** 得到主线中中的一个handler */
	public static Handler getMainThreadHandler() {
		return MliveApp.getHandler();
	}

	/** 安全的执行一个task */
	public static void postTaskSafely(Runnable task) {
		// 得到当前线程的线程id
		long curThreadId = android.os.Process.myTid();
		/**
		 * T:thread P:process U:user
		 */
		// 如果当前线程的线程id==主线程线程id
		if (curThreadId == getMainThreadId()) {
			task.run();
		} else { // 如果当前线程的线程id!=主线程线程id
			getMainThreadHandler().post(task);
		}
	}

	/**
	 * dip-->px
	 * 
	 * @param dip
	 * @return
	 */
	public static int dip2Px(int dip) {
		// px/dp = density;
		// px和dp比例关系
		float density = getResources().getDisplayMetrics().density;

		// ppi
		// float densityDpi = getResources().getDisplayMetrics().densityDpi;

		// LogUtils.s("density: " + density);
		// LogUtils.s("densityDpi: " + densityDpi);
		int px = (int) (density * dip + .5f);
		return px;
		// dp = px/(ppi/160)

		// 320x480 ppi = 160 1px = 1dp
		// 480x800 ppi = 240 1.5px = 1dp
		// 1280 x720 ppi = 320 2px = 1dp
	}

	/**
	 * px-->dp
	 * 
	 * @param px
	 * @return
	 */
	public static int px2Dip(int px) {
		// px/dp = density;
		float density = getResources().getDisplayMetrics().density;
		int dp = (int) (px / density + .5f);
		return dp;
	}

	/** 延迟执行一个任务 */
	public static void postTaskDelay(Runnable task, long delayMillis) {
		getMainThreadHandler().postDelayed(task, delayMillis);
	}

	/** 移除任务 */
	public static void removeTask(Runnable task) {
		getMainThreadHandler().removeCallbacks(task);
	}

	public static int getStatusBarHeight() {
		return Resources.getSystem()
				.getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
	}
}
