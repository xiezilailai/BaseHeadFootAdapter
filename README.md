# BaseHeadFootAdapter
BaseHeadFootAdapter for Android RecyclerView（自定义RecyclerView.Adapter，你可以像ListView一样addHeaderView()和addFooterView()）

welcome to star me or follow me on Github 

**Github：**[xiezilailai的github][1]

You alse can follow my weibo and communicate with me!

**Weibo：**[xiezilailai的微博][2]

**效果**

![这里写图片描述](http://img.blog.csdn.net/20160922005354273)

**使用**

首先你需要将项目中的BaseHeadFootAdapter拷贝到你的工程中，然后继承这个基类并实现它的一些方法。
里面的几个方法与RecyclerView.Adapter原生的几个方法是相对应的，只是名称不同，作用是完全一样的

|BaseHeadFootAdapter   |  RecyclerView.Adapter|
|:--------------------:|:--------------------:|
|getItemNum()          |getItemCount()        |
|onBindView(···)       |onBindViewHolder(···) |
|getViewType()         |     getItemViewType()|

另外两个onBindHeaderView(View headerView),onBindFooterView(View footerView)，
如果你添加了HeaderView或者是FooterView那么你可以在里面获取到你所添加的View
并对其进行操作，比如添加点击事件，为View里面的控件赋值等等，
下面是一个为HeaderView添加点击事件的例子
```
@Override
    protected void onBindHeaderView(View headerView) {
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"head was clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
```

好了，这些都完成后，你就可以在Acitvity中使用你所继承的那个Adapter
，添加HeaderView和FooterVIew的代码如下(你可以自己决定是否添加HeaderVIew或者FooterView)

```
        adapter=new MyBaseHeadFootAdapter(this,list);
        adapter.addHeaderView(headView);
        adapter.addFooterView(footView);
        recyclerView.setAdapter(adapter);
```
最后，你可以参考我的project中的实例。如果我的项目对你有一丢丢的帮助，记得star或者follow我，
有任何问题也欢迎和我交流

**Weibo：**[xiezilailai的微博][2]













[1]: https://github.com/xiezilailai
[2]: http://weibo.com/xiezilailai
