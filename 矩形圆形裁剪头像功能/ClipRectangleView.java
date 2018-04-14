package com.tongju.common.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.tongju.common.R;
import com.tongju.common.util.ResourceUtil;

/**
 * 矩形的图片剪裁面
 *
 * @author AC
 */
public class ClipRectangleView extends View {

    public static final int BORDERDISTANCE = 45;////矩形距离左边边框的距离

    public static final int mHorizontalPadding = ResourceUtil.getDimen(R.dimen.x45);
    public static int mVerticalPadding = 0;
    public static final int mBorderWidth = ResourceUtil.getDimen(R.dimen.x1);
    public static final int mBorderColor = Color.parseColor("#FFFFFF");
    private int mWidth;//矩形宽度

    private Paint mPaint;
    private Context mContext;

    public ClipRectangleView(Context context) {
        this(context, null);
        mContext = context;
    }

    public ClipRectangleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        mContext = context;
    }

    public ClipRectangleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();

        mWidth = width - mHorizontalPadding * 2;
        mVerticalPadding = (height - mWidth) / 2;
        mPaint.setColor(0xaa000000);
        //绘制左边
        canvas.drawRect(0, 0, mHorizontalPadding, height, mPaint);
        //绘制上边
        canvas.drawRect(mHorizontalPadding, 0, width - mHorizontalPadding, mVerticalPadding, mPaint);
        //绘制底部
        canvas.drawRect(mHorizontalPadding, height - mVerticalPadding, width - mHorizontalPadding, height, mPaint);
        //绘制右边
        canvas.drawRect(width - mHorizontalPadding, 0, width, height, mPaint);
        //绘制矩形边框
        mPaint.setColor(mBorderColor);
        mPaint.setStrokeWidth(mBorderWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(mHorizontalPadding, mVerticalPadding, width - mHorizontalPadding, height - mVerticalPadding, mPaint);
    }

    /* �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����) */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
