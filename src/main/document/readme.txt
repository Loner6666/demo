1、修改Maven的D:\MyWork\apache-maven-3.6.3\conf\settings.xml文件

    本地仓库路径： <localRepository>D:/MyWork/localRepository</localRepository>

    添加阿里云镜像：
    	 <mirror>
          <id>aliyun</id>
          <mirrorOf>*</mirrorOf>
          <name>aliyun Maven</name>
          <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        </mirror>


2、绿色版Idea的安装激活：
    安装
    	解压就可以。
    方案一：
    	前提需要将
    	0.0.0.0 account.jetbrains.com     添加到hosts文件中
    第二种方式 需要有网络的情况下才能注册成功
    	且在注册成功的情况下,没有网络只能打开第一次,如果打开多次,有可能会需要重新联网注册
    	进入ide主页面，help-register-license server,然后输入 http://idea.iteblog.com/key.php
    第三种：
    	http://jetbrains-license-server



    配置：
    	调整idea占用磁盘空间：
    	在安装目录：
    		bin/idea.properties  idea.config.path=E:/idea/config
    		idea.system.path=E:/idea/system
    例如：我自己的
    	idea安装路径：D:\MyWork\ideaIU-2017.2.win\bin
    	修改 bin路径下的 idea.properties 文件：
    	idea.config.path=D:/MyWork/ideaIU-2017.2.win/idea/config
    	idea.system.path=D:/MyWork/ideaIU-2017.2.win/idea/system

    在idea64.exe.vmoptions文件最后一行加上jar包路径：（前提是把对应的jar包复制到对应的目录下）
    -javaagent:D:\MyWork\ideaIU-2019.2.3.win\bin\JetbrainsIdesCrack-4.2-release.jar
    或
    -javaagent:D:\MyWork\ideaIU-2019.2.3.win\bin\jetbrains-agent.jar



3、修改Idea的默认配置：

    Maven配置、Git配置、默认字符编码UTF-8、JDK版本1.8

    隐藏后缀名文件：File->Settings->Editor->File Types
        *.cmd;*.gitignore;*.hprof;*.idea;*.iml;*.md;*.mvn;*.pyc;*.pyo;*.rbc;*.yarb;*~;.DS_Store;.git;.hg;.svn;CVS;__pycache__;_svn;vssver.scc;vssver2.scc;

    设置类的备注模板：File->Settings->Editor->File and Code Templates->Includes->File Header
/**
 * @Description：
 * @Author：${USER}
 * @CreateTime：${YEAR}-${MONTH}-${DAY}
 */
    设置方法的备注模板：File->Settings->Editor->File and Code Templates->Includes->ActionScript File Header
 /**
  *
  * @param $param$
  * @return $return$
  */

    Idea安装必备插件：
        Lombok：实体类注解免写getter、setter方法
        free-idea-mybatis是一款增强idea对mybatis支持的插件，主要功能如下：
            生成mapper xml文件
            快速从代码跳转到mapper及从mapper返回代码
            mybatis自动补全及语法错误提示
            集成mybatis generator gui界面
        MyBatis Log Plugin：free-idea-mybatis是一款增强idea对mybatis支持的插件，主要功能如下：
                           生成mapper xml文件
                           快速从代码跳转到mapper及从mapper返回代码
                           mybatis自动补全及语法错误提示
                           集成mybatis generator gui界面
        Alibaba Java Coding Guidelines plugin support:《阿里巴巴 Java 开发规约》的扫描插件
        SonarLint是一个IDE扩展，可以帮助您在编写代码时检测和修复质量问题。和拼写检查器一样，SonarLint也会扭曲缺陷，
        以便在提交代码之前修复它们。您可以直接从IntelliJ IDEA插件库获得它，然后它会在您编写代码时检测新的bug和质量问题
        （Java、Kotlin、Ruby、JavaScript、PHP和Python）。
        如果您的项目是在SonarQube或SonarCloud上分析的，SonarLint可以连接到服务器以检索该项目的适当质量配置文件和设置。运行SonarLint需要Java 8。

        EasyCode-MybatisCodeHelper 插件：
        基于IntelliJ IDEA开发的代码生成插件，支持自定义任意模板（Java，html，js，xml）。
        只要是与数据库相关的代码都可以通过自定义模板来生成。支持数据库类型与java类型映射关系配置。
        支持同时生成生成多张表的代码。每张表有独立的配置信息。完全的个性化定义，规则由你设置。
        该版本用于兼容MybatisCodeHelper插件，方便MybatisCodeHelper插件做代码补全检测等

        CodeGlance 插件: 可以显示代码预览窗格，代码缩略图
