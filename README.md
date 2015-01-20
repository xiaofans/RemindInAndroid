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

 











