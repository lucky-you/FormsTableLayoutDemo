package com.cnsunrun.formstablelayoutdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cnsunrun.formstablelayoutdemo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import win.smartown.android.library.tableLayout.TableAdapter;
import win.smartown.android.library.tableLayout.TableLayout;

public class MainActivity extends AppCompatActivity {
    private TableLayout tableLayout;

    private List<Content> contentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadData();
        firstRowAsTitle();
//        firstColumnAsTitle();
    }

    private void initViews() {
        tableLayout = (TableLayout) findViewById(R.id.tabLayout);
    }


    private void loadData() {
        contentList = new ArrayList<>();
        contentList.add(new Content("施工项目", "工程量", "单位", "小计", "备注"));
        contentList.add(new Content("铺设实木复合地板", "18.0", "M²", "$1259.00", ""));
        contentList.add(new Content("铺设实木防水复合地板", "39.0", "M²", "$1367.60", "暂时先不做"));
        contentList.add(new Content("铺设复合地板", "8.0", "M²", "$894.48", ""));
        contentList.add(new Content("铺设实木地板", "15.0", "M²", "$1258.35", ""));
        contentList.add(new Content("铺设橡胶板", "26.0", "M²", "$689.58", "要求工艺严格"));
    }

    //将第一行作为标题
    private void firstRowAsTitle() {
        //fields是表格中要显示的数据对应到Content类中的成员变量名，其定义顺序要与表格中显示的相同
        final String[] fields = {"施工项目", "工程量", "单位", "小计", "备注"};
        tableLayout.setAdapter(new TableAdapter() {
            @Override
            public int getColumnCount() {
                return fields.length;
            }

            @Override
            public String[] getColumnContent(int position) {
                int rowCount = contentList.size();
                String contents[] = new String[rowCount];
                try {
                    Field field = Content.class.getDeclaredField(fields[position]);
                    field.setAccessible(true);
                    for (int i = 0; i < rowCount; i++) {
                        contents[i] = (String) field.get(contentList.get(i));
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return contents;
            }
        });
    }

    //将第一列作为标题
    private void firstColumnAsTitle() {
        tableLayout.setAdapter(new TableAdapter() {
            @Override
            public int getColumnCount() {
                return contentList.size();
            }

            @Override
            public String[] getColumnContent(int position) {
                return contentList.get(position).toArray();
            }
        });
    }

    public static class Content {

        private String 施工项目;
        private String 工程量;
        private String 单位;
        private String 小计;
        private String 备注;

        public Content(String 施工项目, String 工程量, String 单位, String 小计, String 备注) {
            this.施工项目 = 施工项目;
            this.工程量 = 工程量;
            this.单位 = 单位;
            this.小计 = 小计;
            this.备注 = 备注;
        }

        public String[] toArray() {
            return new String[]{施工项目, 工程量, 单位, 小计, 备注};
        }

    }

}
