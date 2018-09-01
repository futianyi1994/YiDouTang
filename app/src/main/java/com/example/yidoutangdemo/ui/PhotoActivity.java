package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.utils.CloseStreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PhotoActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    SurfaceView surfaceView;
    Camera camera;
    private byte[] cameraData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        surfaceView = ((SurfaceView) findViewById(R.id.activity_photo_surfaceViewId));
        //加速图形绘制
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        //保持屏幕常亮
        surfaceView.getHolder().setKeepScreenOn(true);
        //设置监听
        surfaceView.getHolder().addCallback(this);

        //申请像头资源
        //获取像头的数量
//        int numberOfCameras = Camera.getNumberOfCameras();
        /**
         * 0:表示后置摄像头
         * 1:表示前置摄像头
         */
        camera = Camera.open(0);
    }
    /**
     * Surface被创建
     *
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(camera!=null)
        {
            try {
                //给Camera提供画面展示平台
                camera.setPreviewDisplay(holder);
                //旋转像头
                camera.setDisplayOrientation(90);

                Camera.Parameters parameters = camera.getParameters();

                List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();

                parameters.setPictureSize(3264,2448);

                camera.setParameters(parameters);

                //开启预览
                camera.startPreview();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * surface的状态改变
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * surface销毁
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(camera!=null)
        {
            //停止预览
            camera.stopPreview();
        }
    }
    //释放资源
    @Override
    protected void onDestroy() {
        if(camera!=null)
        {
            camera.release();
            camera = null;
        }
        super.onDestroy();
    }

    /**
     * 拍照
     * @param view
     */
    public void takePhotoClick(View view)
    {
        /**
         * 参数一：快门接口
         * 参数二：接收原生数据的接口
         * 参数三：接收处理后的数据
         */
        camera.takePicture(
                null,
                null,
                new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        //停止预览
                        camera.stopPreview();
                        cameraData = data;
                    }
                }
        );
    }

    /**
     * 取消
     * @param view
     */
    public void cancelPhotoClick(View view)
    {
        if(camera!=null)
        {
            camera.startPreview();
            cameraData = null;
        }
    }

    /**
     * 保存照片
     * @param view
     */
    public void savePhotoClick(View view)
    {
        if(cameraData!=null)
        {
            new SaveCamreaDataAsync().execute(cameraData);
            cameraData = null;
            //开启预览
            camera.startPreview();
        }else
        {
            Toast.makeText(this, "当前没有可以保存的图片资源", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 查看照片
     * @param view
     */
    public void lookPhotoClick(View view)
    {
        startActivity(new Intent(this,Main4Activity.class));
    }

    class SaveCamreaDataAsync extends AsyncTask<byte[],Void,String>
    {
        @Override
        protected String doInBackground(byte[]... params) {
            byte[] param = params[0];
            Bitmap bitmap = BitmapFactory.decodeByteArray(param, 0, param.length);
            Matrix matrix = new Matrix();
            matrix.setRotate(90);
            Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsoluteFile();
            File file1 = new File(file, System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                bitmap1.compress(Bitmap.CompressFormat.JPEG,80,fileOutputStream);
                CloseStreamUtils.close(fileOutputStream);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "fail";
        }
        @Override
        protected void onPostExecute(String s) {
            if(s.equals("success"))
            {
                Toast.makeText(PhotoActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
