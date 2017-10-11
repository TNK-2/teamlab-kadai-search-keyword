 # チームラボ課題
 ## キーワード検索の速度改善課題
 アプリ・各テーブル説明 ....
 ・controller → service → dao の構成にして、controllerは一切触らない <br>
 ・キャッシュ使うのは今回はNG <br>
 ・その他はチューリングOK <br>

 ## ローカル環境構築
1, 課題ソースコードクローン<br>
git clone https://github.com/team-lab/teamlab-kadai-search-keyword.git<br>

2, Docker インストール手順:<br>
・Macbook: Docker for Macのインストール<br>
以下のURLより Docker for Mac をダウンロードしてインストールします。<br>
https://download.docker.com/mac/stable/Docker.dmg<br>
<br>
・Window: Docker for Windowのインストール<br>
以下のURLより Docker for Mac をダウンロードしてインストールします。<br>
https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe<br>
<br>
<br>
Docker インストールした後動作確認してみます。<br>
「docker --version」<br>
「docker-compose --version」<br>
「docker-machine --version」<br>
<br>
＊エラーが出ないなら、Dockerインストール成功になります！<br>
<br>
3, チームラボのサンプルDocker イメージ起動してみる<br>
課題ソースコードのディレクトリからdocker-run-example のフォルダーに入って、下記cmd実施ください。<br>
<br>
・「docker-compose up -d」<br>
・ブラウザーでhttp://localhost:8080　確認する<br>
<br>
4, 検索速度改善の後、アプリのイメージ作成＆アプリ起動方法：<br>
a, まず、Docker hub のログインID準備する<br>
https://hub.docker.com/ に入って、Docker ID作成ください。<br>
<br>
b, Docker設定ファイル変更<br>
<br>
#プロジェクトのディレクトリに移動して<br>
・ build.gradle & docker-compose.yml ファイルの中に自分のDockerIdで変更する。<br>
<br>
 docker イメージ作成して、イメージ起動する<br>
・「./gradlew build buildDocker」<br>
・「docker-compose up -d」<br>
<br>
c, アプリのイメージアップロード<br>
・「docker login」 => dockerId & pass入力する<br>
・「docker push dockerid/teamlab-spring-boot-docker」<br>


 ## 提出物
・docker hubのリンク　<br>
例：https://hub.docker.com/r/kadai/teamlab-spring-boot-docker/
・自分のgithubのリンク　<br>
例：
