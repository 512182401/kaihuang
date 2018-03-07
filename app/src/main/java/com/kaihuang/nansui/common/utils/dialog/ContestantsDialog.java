//package com.kaihuang.nansui.common.utils.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.view.Display;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//import com.quchangkeji.qusheng.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
////import com.quchangkeji.tosing.R;
//
//
///**
// * 参赛者名单信息详情：
// */
//public class ContestantsDialog {
//    private Context context;
//    private Dialog dialog;
//    private TextView txt_title;//标题
//    private TextView txt_cancel;//关闭
//    private TextView contestants_phone;//tv_contestants_phone
//    private TextView contestants_call;//tv_contestants_call
//    private TextView contestants_namephone;//tv_contestants_namephone
//    private TextView contestants_address;//tv_contestants_address
//    private LinearLayout lLayout_content;
//    private ScrollView sLayout_content;
//    private boolean showTitle = false;
//    private List<SheetItem> sheetItemList;
//    private Display display;
//
//    public ContestantsDialog(Context context) {
//        this.context = context;
//        WindowManager windowManager = (WindowManager) context
//                .getSystemService(Context.WINDOW_SERVICE);
//        display = windowManager.getDefaultDisplay();
//    }
//
//    public ContestantsDialog builder() {
//        // 获取Dialog布局
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.contestants_dialog_actionsheet, null);
//
//        // 设置Dialog最小宽度为屏幕宽度
//        view.setMinimumWidth(display.getWidth());
//
//        // 获取自定义Dialog布局中的控件
//        sLayout_content = (ScrollView) view.findViewById(R.id.sLayout_content);
//        lLayout_content = (LinearLayout) view
//                .findViewById(R.id.lLayout_content);
//        txt_title = (TextView) view.findViewById(R.id.txt_title);
//
//
//        contestants_phone = (TextView) view.findViewById(R.id.tv_contestants_phone);
//        contestants_call = (TextView) view.findViewById(R.id.tv_contestants_call);
//        contestants_namephone = (TextView) view.findViewById(R.id.tv_contestants_namephone);
//        contestants_address = (TextView) view.findViewById(R.id.tv_contestants_address);
//        txt_cancel = (TextView) view.findViewById(R.id.txt_cancel);
//
//        txt_cancel.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        // 定义Dialog布局和参数
//        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
//        dialog.setContentView(view);
//        Window dialogWindow = dialog.getWindow();
//        dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.x = 0;
//        lp.y = 0;
//        dialogWindow.setAttributes(lp);
//
//        return this;
//    }
//
//    public ContestantsDialog setAdress(String adress) {
//        contestants_address.setVisibility(View.VISIBLE);
//        contestants_address.setText(adress);
//        return this;
//    }
//
//    public ContestantsDialog setNamePhone(String name, String phone, final OnSheetItemClickListener listener) {
//
//        final OnSheetItemClickListener itemClickListener;
//        if (sheetItemList == null) {
//            sheetItemList = new ArrayList<SheetItem>();
//        }
//        itemClickListener = listener;
//        contestants_phone.setVisibility(View.VISIBLE);
//        contestants_phone.setText("TA的手机号：" + phone);
//        contestants_namephone.setText(name + " " + phone);
//        contestants_call.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemClickListener.onClick(0);
//                dialog.dismiss();
//            }
//        });
////        sheetItemList.add(new SheetItem(phone, ContestantsDialog.SheetItemColor.Blue, listener));
//        return this;
//    }
//
//    public ContestantsDialog setTitle(String title) {
//        showTitle = true;
//        txt_title.setVisibility(View.VISIBLE);
//        txt_title.setText(title);
//        return this;
//    }
//
//    public ContestantsDialog setCancelable(boolean cancel) {
//        dialog.setCancelable(cancel);
//        return this;
//    }
//
//    public ContestantsDialog setCanceledOnTouchOutside(boolean cancel) {
//        dialog.setCanceledOnTouchOutside(cancel);
//        return this;
//    }
//
//    /**
//     * @param strItem  条目名称
//     * @param color    条目字体颜色，设置null则默认蓝色
//     * @param listener
//     * @return
//     */
//    public ContestantsDialog addSheetItem(String strItem, SheetItemColor color,
//                                          OnSheetItemClickListener listener) {
//        if (sheetItemList == null) {
//            sheetItemList = new ArrayList<SheetItem>();
//        }
//        sheetItemList.add(new SheetItem(strItem, color, listener));
//        return this;
//    }
//
//    public ContestantsDialog removeAllItem() {
//        if (sheetItemList != null) {
//            sheetItemList.clear();
//            sheetItemList = null;
//        }
//        lLayout_content.removeAllViews();//清空之前添加的view
//        return this;
//    }
//
//
//    /**
//     * 设置条目布局
//     */
//    private void setSheetItems() {
//        if (sheetItemList == null || sheetItemList.size() <= 0) {
//            return;
//        }
//
//        int size = sheetItemList.size();
//
//        // TODO 高度控制，非最佳解决办法
//        // 添加条目过多的时候控制高度
//        if (size >= 7) {
//            LayoutParams params = (LayoutParams) sLayout_content
//                    .getLayoutParams();
//            params.height = display.getHeight() / 2;
//            sLayout_content.setLayoutParams(params);
//        }
//
//        // 循环添加条目
//        for (int i = 1; i <= size; i++) {
//            final int index = i;
//            SheetItem sheetItem = sheetItemList.get(i - 1);
//            String strItem = sheetItem.name;
//            SheetItemColor color = sheetItem.color;
//            final OnSheetItemClickListener listener = (OnSheetItemClickListener) sheetItem.itemClickListener;
//
//            TextView textView = new TextView(context);
//            textView.setText(strItem);
//            textView.setTextSize(18);
//            textView.setGravity(Gravity.CENTER);
//
//            // 背景图片
//            if (size == 1) {
//                if (showTitle) {
//                    textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//                } else {
//                    textView.setBackgroundResource(R.drawable.actionsheet_single_selector);
//                }
//            } else {
//                if (showTitle) {
//                    if (i >= 1 && i < size) {
//                        textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
//                    } else {
//                        textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//                    }
//                } else {
//                    if (i == 1) {
//                        textView.setBackgroundResource(R.drawable.actionsheet_top_selector);
//                    } else if (i < size) {
//                        textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
//                    } else {
//                        textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//                    }
//                }
//            }
//
//            // 字体颜色
//            if (color == null) {
//                textView.setTextColor(Color.parseColor(SheetItemColor.Blue
//                        .getName()));
//            } else {
//                textView.setTextColor(Color.parseColor(color.getName()));
//            }
//
//            // 高度
//            float scale = context.getResources().getDisplayMetrics().density;
//            int height = (int) (45 * scale + 0.5f);
//            textView.setLayoutParams(new LayoutParams(
//                    LayoutParams.MATCH_PARENT, height));
//
//            // 点击事件
//            textView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onClick(index);
//                    dialog.dismiss();
//                }
//            });
//
//            lLayout_content.addView(textView);
//        }
//    }
//
//    public void show() {
//        setSheetItems();
//        dialog.show();
//    }
//
//    public boolean isShow() {
//        boolean isShow = false;
//        if (dialog != null) {
//            if (dialog.isShowing()) {
//                isShow = true;
//            } else {
//                isShow = false;
//            }
//
//        } else {
//            isShow = false;
//        }
//        return isShow;
//    }
//
//    public interface OnSheetItemClickListener {
//        void onClick(int which);
//    }
//
//    public class SheetItem {
//        String name;
//        OnSheetItemClickListener itemClickListener;
//        SheetItemColor color;
//
//        public SheetItem(String name, SheetItemColor color,
//                         OnSheetItemClickListener itemClickListener) {
//            this.name = name;
//            this.color = color;
//            this.itemClickListener = itemClickListener;
//        }
//    }
//
//    public enum SheetItemColor {
//        Blue("#037BFF"), Red("#FD4A2E");
//
//        private String name;
//
//        private SheetItemColor(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//}
