package zgt.com.example.myzq.model.common.home;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import zgt.com.example.myzq.R;
import zgt.com.example.myzq.base.BaseActivity;
import zgt.com.example.myzq.bean.Review;
import zgt.com.example.myzq.utils.SPUtil;

public class ReviewDetailActivity extends BaseActivity {
    @BindView(R.id.webview)
    WebView webview;

    @BindView(R.id.Rl_progress)
    RelativeLayout Rl_progress;
//
//    @BindView(R.id.pro)
//    ProgressBar pro;
    private List<Review> list;
    private String url;
    int status = 0;

    @Override
    public void initViews(Bundle savedInstanceState) {
        WebSettings webSettings = webview.getSettings();
        webSettings.setUseWideViewPort(true);
//        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        status = getIntent().getIntExtra("status",0);
        list = (List<Review>) getIntent().getSerializableExtra("list");
        webview.loadUrl(SPUtil.getServerAddress().substring(0,SPUtil.getServerAddress().length()-5)+list.get(status).getUrl());
            webview.setWebViewClient(new WebViewClient() {
//                @Override
//                public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                    Rl_progress.setVisibility(View.VISIBLE);
//                    super.onPageStarted(view, url, favicon);
//                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    // TODO Auto-generated method stub
//                    pro.setVisibility(View.GONE);
                    Rl_progress.setVisibility(View.GONE);
//                    view.loadUrl(url);
                    super.onPageFinished(view, url);

                }
            });
        webview.addJavascriptInterface(new APPInterface(), "android");//增加js接口交互ext
    }


    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_review_detail;
    }

    @Override
    public void onBackPressed() {
        return;
//        super.onBackPressed();
//        if (webview != null) {
//            webview.stopLoading();
////            webView.setWebViewListener(null);
////            webView.clearHistory();
//            webview.clearCache(true);
//            webview.loadUrl("about:blank");
////            webView.pauseTimers();
////            webView = null;
//        }
    }

    class APPInterface{
        @JavascriptInterface
        public void ConfirmReturnVisit(){
//            if(list.size()>(status+1)){
                finish();
//                status+=1;
//                startActivity(new Intent().setClass(ReviewDetailActivity.this, ReviewDetailActivity.class).putExtra("list",(Serializable) list).putExtra("status",status));
//               finish();
////                webview.stopLoading();
////                webview.clearCache(true);
//                webview.loadUrl(SPUtil.getServerAddress().substring(0,SPUtil.getServerAddress().length()-5)+list.get(status).getUrl());
//                webview.reload();
//            }else {
//                finish();
//            }
        }
    }
}
