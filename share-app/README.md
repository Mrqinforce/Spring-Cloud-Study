# 基于微服务架构的知识分享小程序（下）

## 1.用户微信登录

微信小程序自带的登录，通过appid、secret获取到opernId（wxId），进行授权发送 res.code 到后台换取 openId, sessionKey, unionId，已经授权，可以直接调用 getUserInfo 获取头像昵称，授权后不会有弹框出现，可以将 res 发送给后台解码出 unionId



![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/345.jpg)

# 2.用户微信登录成功

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E7%99%BB%E5%BD%95%E6%88%90%E5%8A%9F.jpg)

# 3.我的页面

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/我的页面.jpg)

# 4.退出登录（返回到登录页面）

将原本登录后获得的user、token赋值为null，并更新userInfo为null

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/345.jpg)

# 5.我的兑换

通过userId（登录后获得的userId）来查找属于我的兑换

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/我的兑换】.jpg)

# 6.积分明细

通过调用后端的查询积分明细接口来实现

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E7%A7%AF%E5%88%86%E6%98%8E%E7%BB%86.jpg)

# 6.我的投稿

通过调用后端接口来获得pageNo、pageSize、userId（登录后获得的userId）

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/我的投稿.jpg)

# 7.进行签到

通过判断isUserSignin是否为1来进行签到，如果为1，则显示签到失败，反之为0时，调用后端相关接口并传一个userId来签到，最后显示为签到成功



![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/签到成功.jpg)

# 8.今日签到后，再进行签到会提示签到失败

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E7%AD%BE%E5%88%B0%E5%A4%B1%E8%B4%A5.jpg)

# 9.我的首页（发现页面）+最新公告（Vue）

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E9%A6%96%E9%A1%B5.jpg)

# 10.登录用户进行兑换知识书籍

在首页有兑换和下载的知识书籍，如果你还未兑换，并且自己拥有的积分足够时可以兑换相应知识书籍，点击进入详情页，点击兑换来获得该知识书籍。

实现：取出页面绑定对象，调用兑换接口并传两个值：userId、shareId

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/兑换.jpg)

# 11.登录用户兑换成功后，到相应下载地址链接

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/兑换成功后到相应下载地址.jpg)

# 13.使用说明

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E.jpg)

#  14. 投稿

向后端传相应的userId（登录用户）、isOriginal（是否为原创）、title（标题）、author（作者）、price（价格）、summary（简介）、downUrl（下载地址），就简单的实现了投稿，管理员审核、通过这块还未实现

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/%E6%8A%95%E7%A8%BF.jpg)

# 15.投稿成功

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/投稿成功.jpg)

数据库对应投稿数据

![](https://sillyforce.oss-cn-beijing.aliyuncs.com/markdown/数据库对应数据.jpg)



