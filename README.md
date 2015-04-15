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

18.TextView setSingleLine(true) 不显示...问题  
	 xml中加入android:ellipsize="end" 属性   
	 用代码设置single line省略号不显示，难道是android:ellipsize属性的默认值是end，代码设置系统把这个值给去掉了  
	  ![image](https://github.com/xiaofans/RemindInAndroid/blob/master/pics/ellipsize_use.jpg)   
19.TextView ellipse useage
https://github.com/xiaofans/RemindInAndroid/blob/master/class/EllipsizingTextView.java  

20.ListView item add pressed bg  
 code  
``` 
  <?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="true"
        android:drawable="@color/item_pressed_bg" />
    <item  android:state_focused="false"
        android:drawable="@color/item_normal_bg" />
</selector>
```  
21.ListView item 倒计时问题解决方案
``` 
	...........getView(){
				
		...
		...
		...
		// 把countdowntimer添加到viewholder中，取消该timer，防止一个item绑定多个timer，否则会出现倒计时乱的问题  
		if(viewHolder.countDownTimer != null){
				viewHolder.countDownTimer.cancel();
		}
		
		viewHolder.countDownTimer = new CountDownTimer(...){....}
	}
	
	ViewHolder{
		..
		..
		..
		CountDownTimer countDownTimer;
	}

```  


22.view动态设置padding(以前以为需要LayoutParams,现在才发现直接设置就可以)   
..View.setPadding(0,0,0,0);  

23.应用包app认领流程  
https://github.com/xiaofans/RemindInAndroid/blob/master/the%20others/yingyongbao_claim/%E5%BA%94%E7%94%A8%E5%8C%85%E8%AE%A4%E9%A2%86%E6%B5%81%E7%A8%8B.txt   

24.suppor librarys 的作用  (https://developer.android.com/tools/support-library)
	 -v4 Support Library 
	 		>App Components
	    		Fragment  
	    		NotificationCompat  富通知  
	    		LocalBroadcastManager  
	    		
	    >User Interface    
	    		ViewPager  
	    		PagerTitleStrip  
	    		PagerTabStrip  可滑动的tab  
	    		DrawerLayout  抽屉式布局  
	    		SlidingPaneLayout 类似SlidingMenu  
	    >Content  
	    		Loader  异步加载数据 包含CursorLoader AsyncTaskLoader 
	    		FileProvider  分享私有的文件在程序间  
	    		
25.Multidex Support Library 一个app打多个dex文件，为了防止在2.2上安装不上报limit methods 65536错误  Gradle only  
26.v7 support library  主要包含Action Bar 还有material design规范里的一些组件  
27.v7 cardview library CardView 组件 在Google的设计中较为流行  
28.v7 gridlayout library gridlayout组件  
29.v7 mediarouter library 暂时不明是干啥的  
30.v7 palette library 画板组件 可以根据一个bitmap得到图片的色调值 (感觉是根据material design的风格来的)  
31.v7 recyclerview library 据说性能比listiew好的一个数据集显示组件  
32.v8 Support Library 支持RenderScript  
33.V13 多出FragmentCompat类??  
34.v17 Leanback Library 主要是为tv设计  
35.Material Design设计学习  
	-什么是Material Design?
	Material Design 基于触觉现实,灵感来源于对纸张和墨水的研究,元素以印刷为基础进行设计.  用户进行操作的时候，吸引用户注意力并且连续性，反馈清晰，转变一致.

	-环境
	  3d空间 
	  光影与阴影
	-属性
	1.静态属性  
 			-可变的大小，均匀的厚度1dp  

36.ListView快速滑动到顶部的方法 listview.setSelectionAfterHeaderView()  
37.use ContentProvider with GreenDao https://github.com/greenrobot/greenDAO/blob/master/DaoGenerator/src-template/content-provider.ftl#L41  
38.TextView里面支持电话号码 网站识别 android:autoLink="phone|web" 改变连接字体的颜色 android:textColorLink="@color/white"   
39.自定义控件的规则:符合android标准;提供自定义xml属性;可发生无阻塞事件;多平台兼容.  
40.android下 utils or support v4 utils中新添的Sparse****系列可用来代替HashMap并且性能更加高效    
-SparseArray   SparseArrays map integers to Objects.  
-SparseBooleanArray  SparseBooleanArrays map integers to booleans.  
-SparseIntArray   SparseIntArrays map integers to integers.  
-SparseLongArray  SparseLongArrays map integers to longs.  


	
	
   
 
 
 


 











