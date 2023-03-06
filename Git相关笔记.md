# Git

## 概念
Git是目前世界上最先进的分布式版本控制系统。

## Git和SVN的区别
Git 不仅仅是个版本控制系统，它也是个内容管理系统(CMS)，工作管理系统等。

Git 与 SVN 区别点：

    1、Git 是分布式的，SVN 不是：这是 Git 和其它非分布式的版本控制系统，例如 SVN，CVS 等，最核心的区别。

    2、Git 把内容按元数据方式存储，而 SVN 是按文件：所有的资源控制系统都是把文件的元信息隐藏在一个类似 .svn、.cvs 等的文件夹里。

    3、Git 分支和 SVN 的分支不同：分支在 SVN 中一点都不特别，其实它就是版本库中的另外一个目录。

    4、Git 没有一个全局的版本号，而 SVN 有：目前为止这是跟 SVN 相比 Git 缺少的最大的一个特征。

    5、Git 的内容完整性要优于 SVN：Git 的内容存储使用的是 SHA-1 哈希算法。这能确保代码内容的完整性，确保在遇到磁盘故障和网络问题时降低对版本库的破坏。

## Git 常用的是以下 6 个命令：
git clone、git push、git add 、git commit、git checkout、git pull，后面我们会详细介绍。

    git init - 初始化仓库。
    git add  - 添加文件到暂存区。
    git commit - 将暂存区内容添加到仓库中。 

## 从远程仓库拉去数据到本地

注册用户名和邮箱
 git config --global user.name "libinha"
 git config --global user.email "704012647@qq.com"

生成密钥并查看
ssh-keygen -t rsa -C "704012647@qq.com"
cat ~/.ssh/id_rsa.pub

创建远程仓库连接
git remote add origin https://github.com/Libinha/Javatest.git

将分支拉到本地
git fetch origin master (master为远程仓库的分支名）

将分支代码拉到本地
git pull origin master (远程分支名称)

## 从本地上传数据到远程仓库

1、首先新建一个文件夹在当前文件夹下初始化一个git仓库
git init

2、将当前工作区的所有文件存放到暂存区
git add . 

3、将暂存区中存放的文件提交到git仓库
git commit -m “我的第一提交”

4、将本地代码库的当前分支与远程的git代码库相关联
git remote add origin 远程仓库地址

5、把当前分支推送到远程的代码库
git push -u origin master

//在 gitbash 命令行中测试是否连接到 github
ssh -T git@github.com

https://github.com
username:704012647@qq.com
password:Libin123456789
