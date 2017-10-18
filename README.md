# チームラボ選考課題

このリポジトリで動作するサンプルアプリケーションのキーワード検索機能を、  
可能な限りチューニングして結果が速く表示されるようにしてください  
※ サンプルは何もしないとまともに動作しません

## 検索仕様

<b>page</b> テーブルの <b>title</b> カラムを前方一致でキーワード検索し、

* ユーザid
* ユーザ名
* ページid
* ページタイトル
* 閲覧回数

をユーザidの昇順で10件取得してください

## 制限

* 表示される項目や結果の順番が変わらないこと
* memcached等、キャッシュサーバを用いないこと
* controllerパッケージは修正しないこと
* キーワード「あり/なし」どちらの場合も考慮すること

## 評価方法

* チューニングした結果の検索速度を評価対象とします
    * 公平を期すため弊社で用意した計測用サーバで速度の検証をします
    * 計測用サーバのメモリは<b>3G</b>のものを用意しています

## 提出方法

* github.com にプッシュしてリポジトリのURLを提出してください
    * 【例】https://github.com/team-lab/teamlab-kadai-search-keyword
    * README.md ファイルを作成し、チューニングした内容を説明してください

## サンプルアプリケーションの説明

### プロジェクト構成
```
├── Dockerfile：Dockerビルドファイル
├── README.md
├── bin
├── build
├── build.gradle：Gradleのビルドファイル
├── docker-compose.yml：Docker実行ファイル
├── docker-run-example：Dockerのサンプル実行
├── gradle
├── gradlew
├── gradlew.bat
├── sql：データベースDump
├── src：ソースコード
└── startup.sh:Docker起動時に実行されるシェルスクリプト
```

### 開発環境

* 言語: Java
* ビルド: Gradle
* フレームワーク: Spring Boot
* データベース:　Mysql
* コンテナ: Docker

### データベース構成
* page 150万件
    * ページ情報を格納するテーブルです。
* user 1万件
    * ユーザ情報を格納するテーブルです。
* activity 10万件
    * ユーザの閲覧履歴を格納するテーブルです。

### ローカル環境構築

#### 1. 課題ソースコードクローン

```
git clone https://github.com/team-lab/teamlab-kadai-search-keyword.git
```

#### 2. Docker インストール手順

* Macbook: Docker for Macのインストール
    * 以下のURLより Docker for Mac をダウンロードしてインストールします
    * https://download.docker.com/mac/stable/Docker.dmg
* Window: Docker for Windowのインストール
    * 以下のURLより Docker for Mac をダウンロードしてインストールします
    * https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe
* Docker インストールした後、動作確認方法<br>
 
```
docker --version
docker-compose --version
docker-machine --version
```

エラーが出なければ、Dockerのインストールは成功です！

#### 3. サンプル・アプリケーションの起動

課題ソースコードのディレクトリからdocker-run-exampleのフォルダーに入って、下記コマンドを実行してください

```
docker-compose up -d
```

ブラウザで `http://localhost:8080` 確認

#### 4. Eclipseのインストール

TODO: インストール方法とプロジェクトのインポート方法追記よろ！
