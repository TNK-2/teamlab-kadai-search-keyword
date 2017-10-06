 # チームラボ課題
 ## キーワード検索の速度改善課題
 ・controller → service → dao の構成にして、controllerは一切触らない <br>
 ・キャッシュ使うのは今回はNG <br>
 ・投入SQL

 ## ローカル環境構築
1, jar ファイル作成　<br>

./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar　<br>

2, Docker でString boot アプリ + MYSQL 実行　<br>

docker-compose up --build　<br>

3, URL確認　<br>

http://192.168.99.100:8080/page?keyword=a　<br>

 ## 提出物
・docker image　<br>
・自分のgithub　<br>
