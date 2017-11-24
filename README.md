# チームラボ選考課題(11/24時点)

このリポジトリで動作するサンプルアプリケーションのキーワード検索機能を、  
可能な限りチューニングして結果が速く表示されるようにしてください  
※ サンプルは何もしないとまともに動作しません

## 今回の変更点  
ユーザ閲覧履歴画面の情報取得、表示ロジックの修正  
データの取得を、「ユーザーあり」「ユーザーなし」ページに２回に分けた。  
１．「ユーザーなし」情報を取得し、出力用リストに格納。取得した情報の件数がそのままヒット件数に加算される。  
２．「ユーザーあり」情報を取得し、出力用リストに格納。取得したユーザー一人につき、１HITとみなす。  
  
以下、詳細  
pom.xml : spring-jdbcの追加  
src/main/java/teamlab/AppConf.java : spring-jdbc用設定  
src/main/java/teamlab/model/entity/Pageinf.java : view pageinf 用エンティティクラス  
src/main/java/teamlab/model/service/PageService.java : 上記１．２  
src/main/java/teamlab/utils/SearchList.java : 検索ヒット件数を保持させる機能を付与したリスト。  
src/sql/alter.sql : ビューの作成。  
