## 本项目实现的最终作用是基于SSH失物招领管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 公告管理
 - 寻物信息管理
 - 招领列表管理
 - 用户信息管理
 - 留言感谢管理
 - 管理员登陆
 - 系统日志管理
### 第2个角色为用户角色，实现了如下功能：
 - 个人中心-查看招领信息
 - 个人信息修改
 - 在线交流模块
 - 寻物信息
 - 招领信息
 - 查看个人寻物记录
 - 用户登录
 - 用户首页
 - 留言感谢墙
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_lostandfound

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [academy](#academy) |  |
| [classes](#classes) |  |
| [expressthanks](#expressthanks) |  |
| [loginlog](#loginlog) |  |
| [lostthings](#lostthings) |  |
| [menuitem](#menuitem) |  |
| [notice](#notice) |  |
| [pickthings](#pickthings) |  |
| [school](#school) |  |
| [student](#student) | 学生表 |
| [systemlog](#systemlog) |  |
| [teacher](#teacher) | 用户表 |
| [user](#user) | 用户表 |

**表名：** <a id="academy">academy</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   int   | 10 |   0    |    N     |  Y   |       | AcademyID自增  |
|  2   | AcademyCode |   varchar   | 8 |   0    |    N     |  N   |       | 二级学院代码  |
|  3   | AcademyName |   varchar   | 255 |   0    |    N     |  N   |       | 二级学院名称  |
|  4   | SchoolCode |   varchar   | 255 |   0    |    N     |  N   |       | 所属学校代码（外键）  |

**表名：** <a id="classes">classes</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   int   | 10 |   0    |    N     |  Y   |       | ClassesID自增  |
|  2   | ClassNo |   varchar   | 255 |   0    |    N     |  N   |       | 班级编号  |
|  3   | Major |   varchar   | 255 |   0    |    N     |  N   |       | 专业  |
|  4   | AcademyCode |   varchar   | 8 |   0    |    N     |  N   |       | 所属二级学院代码(外键）  |

**表名：** <a id="expressthanks">expressthanks</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       | ID  |
|  2   | Title |   varchar   | 255 |   0    |    N     |  N   |       | 感谢标题  |
|  3   | Substance |   text   | 65535 |   0    |    N     |  N   |       | 感谢内容  |
|  4   | Status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  5   | UserName |   varchar   | 255 |   0    |    N     |  N   |       | 感谢人  |
|  6   | LeaveTime |   datetime   | 19 |   0    |    N     |  N   |       | 感谢时间  |

**表名：** <a id="loginlog">loginlog</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       | 登录日志ID  |
|  2   | UserName |   varchar   | 12 |   0    |    N     |  N   |       | 用户名  |
|  3   | OSName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 操作系统  |
|  4   | BrowserName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 浏览器  |
|  5   | LoginIp |   varchar   | 255 |   0    |    N     |  N   |       | 登录IP  |
|  6   | LoginTime |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 登录时间  |
|  7   | UID |   bigint   | 20 |   0    |    N     |  N   |       | 用户表ID外键  |

**表名：** <a id="lostthings">lostthings</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       | LostThingsID自增  |
|  2   | ThingsName |   varchar   | 255 |   0    |    N     |  N   |       | 物品名称  |
|  3   | LostPlace |   varchar   | 255 |   0    |    N     |  N   |       | 丢失地点  |
|  4   | LostTime |   date   | 10 |   0    |    N     |  N   |       | 丢失时间  |
|  5   | ThingsType |   varchar   | 15 |   0    |    N     |  N   |       | 物品类型  |
|  6   | ThingsNo |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 物品编号  |
|  7   | ThingsImg |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 物品图片可null  |
|  8   | ThingsDes |   text   | 65535 |   0    |    N     |  N   |       | 物品描述  |
|  9   | PublishTime |   datetime   | 19 |   0    |    N     |  N   |       | 发布时间  |
|  10   | Status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  11   | UserName |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  12   | UID |   bigint   | 20 |   0    |    N     |  N   |       | 用户表ID外键  |

**表名：** <a id="menuitem">menuitem</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | MenuID |   varchar   | 255 |   0    |    N     |  N   |       | 菜单ID  |
|  3   | MenuItemName |   varchar   | 255 |   0    |    N     |  N   |       | 菜单名称  |
|  4   | MenuItemUrl |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 菜单url地址  |
|  5   | ParentId |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 父菜单ID  |
|  6   | Status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  7   | MenuItemDes |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 菜单描述  |
|  8   | Authority |   int   | 10 |   0    |    N     |  N   |       | 菜单访问权限  |
|  9   | Sort |   int   | 10 |   0    |    Y     |  N   |   NULL    | 菜单排序  |

**表名：** <a id="notice">notice</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | Title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | Substance |   longtext   | 2147483647 |   0    |    N     |  N   |       | ÄÚÈÝ  |
|  4   | Status |   int   | 10 |   0    |    N     |  N   |       | 状态（0显示,1不显示）  |
|  5   | PublishTime |   datetime   | 19 |   0    |    N     |  N   |       | 发布时间  |

**表名：** <a id="pickthings">pickthings</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       | LostThingsID自增  |
|  2   | ThingsName |   varchar   | 255 |   0    |    N     |  N   |       | 物品名称  |
|  3   | PickPlace |   varchar   | 255 |   0    |    N     |  N   |       | 丢失地点  |
|  4   | PickTime |   date   | 10 |   0    |    N     |  N   |       | 丢失时间  |
|  5   | ThingsType |   varchar   | 15 |   0    |    N     |  N   |       | 物品类型  |
|  6   | ThingsNo |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 物品编号  |
|  7   | ThingsImg |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 物品图片  |
|  8   | ThingsDes |   text   | 65535 |   0    |    N     |  N   |       | 物品描述  |
|  9   | StoragePlace |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 暂存地点  |
|  10   | TelPhone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 联系电话  |
|  11   | PublishTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 发布时间  |
|  12   | Status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  13   | UserName |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  14   | UID |   bigint   | 20 |   0    |    N     |  N   |       | 用户表ID外键  |

**表名：** <a id="school">school</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   int   | 10 |   0    |    N     |  Y   |       | SchoolID自增  |
|  2   | SchoolCode |   varchar   | 255 |   0    |    N     |  N   |       | 学校代码  |
|  3   | SchoolName |   varchar   | 255 |   0    |    N     |  N   |       | 学校名称  |

**表名：** <a id="student">student</a>

**说明：** 学生表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | StudentNo |   varchar   | 15 |   0    |    N     |  Y   |       | 学号  |
|  2   | StudentName |   varchar   | 16 |   0    |    N     |  N   |       | 姓名  |
|  3   | ClassNo |   varchar   | 255 |   0    |    N     |  N   |       | 班级  |
|  4   | Sex |   char   | 2 |   0    |    N     |  N   |       | 性别  |
|  5   | Birth |   date   | 10 |   0    |    N     |  N   |       | 生日  |
|  6   | IdCard |   char   | 20 |   0    |    N     |  N   |       | 身份证号码  |
|  7   | TelPhone |   char   | 12 |   0    |    N     |  N   |       | 联系电话  |

**表名：** <a id="systemlog">systemlog</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | Description |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 描述  |
|  3   | ExceptionCode |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 异常代码  |
|  4   | Type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |
|  5   | RequestIp |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 请求人IP  |
|  6   | ExceptionDetail |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 异常详细信息  |
|  7   | Method |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 请求方法  |
|  8   | Params |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 请求参数  |
|  9   | CreateBy |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 操作人  |
|  10   | CreateDate |   datetime   | 19 |   0    |    N     |  N   |       | 操作时间  |

**表名：** <a id="teacher">teacher</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | TeacherNo |   varchar   | 255 |   0    |    N     |  Y   |       | 工号  |
|  2   | TeacherName |   varchar   | 16 |   0    |    N     |  N   |       | 姓名  |
|  3   | Sex |   char   | 2 |   0    |    N     |  N   |       | 性别  |
|  4   | Birth |   date   | 10 |   0    |    N     |  N   |       | 生日  |
|  5   | IdCard |   char   | 20 |   0    |    N     |  N   |       | 身份证号码  |
|  6   | TelPhone |   char   | 12 |   0    |    N     |  N   |       | 联系电话  |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   bigint   | 20 |   0    |    N     |  Y   |       | ID自增  |
|  2   | UserName |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  3   | Password |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |
|  4   | Grade |   varchar   | 255 |   0    |    N     |  N   |       | 年级  |
|  5   | Name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  6   | NickName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 昵称  |
|  7   | TelPhone |   varchar   | 12 |   0    |    N     |  N   |       | 联系电话  |
|  8   | Email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  9   | QQ |   varchar   | 15 |   0    |    Y     |  N   |   NULL    | qq  |
|  10   | State |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  11   | CreateTime |   date   | 10 |   0    |    N     |  N   |       | 创建时间  |
|  12   | IsNew |   int   | 10 |   0    |    N     |  N   |   0    | 原始密码（0）修改后（1）  |
|  13   | LastLoginTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 最后一次登录时间  |

