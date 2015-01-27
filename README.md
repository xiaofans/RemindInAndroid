RemindInAndroid Write To Remember.
===============
1.继承PagerAdapter需要override instantiateItem destroyItem isViewFromObject方法，在instantiateItem中，必须调用container.addview(your view)方法，要不然不会显示.  
2.android api level quick look    ![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/api_level_quick_look.png)  
3.凡事预则立，不预则废，谨记谨记，谨言慎行。  
4.屏幕密度density与各分辨率drawable对应关系      ![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/density.png)    
5.退出程序的方法(clean activity task)  
 		Intent intent = new Intent(context, class);  
 		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);  
 		startActivity(intent);  
6.activity背景设置为透明的方法  
 url:http://stackoverflow.com/questions/2176922/how-to-create-transparent-activity-in-android
![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/activity_bg_transparent.png)  
7.activity设置dialog样式的时候，让其位于底部的方法(dialog在底部显示的方法)  
<code>
				getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);  
        getWindow().setGravity(Gravity.BOTTOM);
</code>  

8.listview item倒计时问题  

自己考虑了用CountDownTimer来实现，可是不行，刷新有问题，详细问题后来列出来//TODO  
在网上找到一个可行方法，使用handler发送延迟消息进行刷新，网址是  
<url>http://stackoverflow.com/questions/20265493/listview-and-items-with-countdown-timer</url>  

9.RelativeLayout 子view 居中方法 代码实现  addRule()  
<code>params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);</code>  

10.千万不要随便勾选as的offline work 选项!  
![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/as_offline_mod_warning.png)   

11.get status bar heigt  
![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/get_status_bar_height.png)   

12.需要思考的  
 ×service 连接保持  
 ×adapter里多线程 》》 getview 中的一个item 开启线程并刷新该item，不会引起别的item改变(UIL)  
 ×上传 下载 (图片 文件)等  
 ×数据库的同步问题  
 ×View的绘制    
 13 scrollable EditText. 可滑动的EditText，系统竟然可以自带srcollbar 好神奇  
 http://stackoverflow.com/questions/10896839/scroll-inside-an-edittext-which-is-in-a-scrollview  
 
 ![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/scrollable_edittext.png) 
 
 14.水平的listview (HorizontalListView)有两种开源的实现  
 ×https://github.com/mtparet/HorizontalListView   相对于第二个好用(可能是我的布局问题，item为RelativeLayout的时候并设置layout_alignParentRight的时候，第二个无法滑动，这个则fill screen)  
 ×https://github.com/MeetMe/Android-HorizontalListView  
 
 15.判断app是否在前台(对用户可见)  
```
 	public boolean isInForeground(){  
        try {  
            ActivityManager am = (ActivityManager)getSystemService(ACTIVITY_SERVICE);  
            // The first in the list of RunningTasks is always the foreground task.  
            ActivityManager.RunningTaskInfo foregroundTaskInfo = am.getRunningTasks(1).get(0);  
            String foregroundTaskPackageName = foregroundTaskInfo .topActivity.getPackageName();  
            PackageManager pm = getPackageManager();  
            PackageInfo foregroundAppPackageInfo = pm.getPackageInfo(foregroundTaskPackageName, 0);  
            String foregroundTaskAppName = foregroundAppPackageInfo.applicationInfo.loadLabel(pm).toString();  
            if(getResources().getString(R.string.app_name).equals(foregroundTaskAppName)){  
                return true;  
            }else{  
                return false;  
            }  
        }catch (Exception e){  
            return true;  
        }  
    }  
```   
16.GradientDrawable 使用
 xml
 ```  
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">

    <solid android:color="#FF7058" />
    <corners android:radius="7dp" />
</shape>
 
 ``` 
 code  
``` 
  GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,new int[]{Color.parseColor(startColor),Color.parseColor(endColor)});
``` 
17.moving a imageview follow with finger MARK  
	http://stackoverflow.com/questions/14814542/moving-imageview-with-touch-event
 
   
 
 
 


 











