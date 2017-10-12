# チームラボ課題

キーワード検索の`速度改善`課題です。

### データベース構成
1. page <br>
 ページ情報を格納するテーブルです。
1. user <br>
ユーザ情報を格納するテーブルです。
1. activity <br>
ユーザの閲覧履歴を格納するテーブルです。

### 検索内容
キーワードで該当ページを検索して、そのページの閲覧ユーザ、閲覧数も出るようにしてください。

### 改善方針
1. controller → service → dao の構成にして、controllerは一切触らない
1. キャッシュ使うのは今回はNG
1. その他はチューリングOK

### ローカル環境構築
1. 課題ソースコードクローン<br>
git clone https://github.com/team-lab/teamlab-kadai-search-keyword.git<br>

2. Docker インストール手順:<br>
 ・ Macbook: Docker for Macのインストール<br>
以下のURLより Docker for Mac をダウンロードしてインストールします。<br>
https://download.docker.com/mac/stable/Docker.dmg <br>
<br>
 ・ Window: Docker for Windowのインストール<br>
以下のURLより Docker for Mac をダウンロードしてインストールします。<br>
https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe<br>
<br>
 ・ Docker インストールした後、動作確認方法
 ```
docker --version
docker-compose --version
docker-machine --version
```
エラーが出ないなら、Dockerインストール成功になります！

3. チームラボのサンプルDocker イメージ起動してみる<br>
課題ソースコードのディレクトリからdocker-run-example のフォルダーに入って、下記コマンド実施ください。<br>
`docker-compose up -d`<br>
<br>
ブラウザーで `http://localhost:8080`確認する<br>
<br>
4. 検索速度改善の後、自分のdockerイメージビルドとアプリ起動方法：<br>
・ まず、Docker hub のDockerID (ログインID)作成する<br>
https://hub.docker.com/ に入って、`DockerID`作成ください。<br>
<br>
・ Docker設定ファイル変更<br>
`プロジェクトのディレクトリ`に移動して
` build.gradle & docker-compose.yml` ファイルの中に自分の`DockerId`で変更する。<br>
<br>
・ Docker イメージ作成して、イメージ起動する<br>
`プロジェクトのディレクトリ`に移動して、以下のコマンドを実行<br>
#Mac: `./gradlew build buildDocker`<br>
#Window: `gradlew build buildDocker`<br>
`docker-compose up -d`<br>
<br>
・自分のイメージアップロード<br>
以下のコマンドを実行<br>
```docker login``` => DockerId & pass入力する<br>
<br>
自分の`DockerId`で変更してから、コマンド実行<br>
```docker push DockerId/teamlab-spring-boot-docker```


## 課題提出
・Docker Hubのリンク<br>
【例】https://hub.docker.com/r/kadai/teamlab-spring-boot-docker/
<br>
・自分のgithubのリンク<br>
【例】https://github.com/team-lab/teamlab-kadai-search-keyword
