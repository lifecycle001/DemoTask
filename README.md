# BlogTask

Создать блог (только API)  с возможностью получать список постов по дате создания (самые новые), по популярности (количество просмотров и комментариев),  оставлять свои комментарии, а также создавать вложенные комментарии (ветки).

1)	Я хочу получить список постов по дате создания.
2)	Я хочу получить список постов по популярности.
3)	Я хочу получить пост по уникальному идентификатору.
4)	Для получения постов я хочу использовать пагинацию.
5)	Я хочу создать новый пост
6)	Я хочу отсекать посты, которые не проходят валидацию (валидация на усмотрение разработчика)
7)	Я хочу редактировать посты 
8)	Редактирование тоже должно быть защищено валидацией
9)	Я хочу удалять посты 
10)	 Я хочу оставлять комментарии для конкретного поста.
11)	 Я хочу оставлять комментарий под комментарием конкретного поста.
12)	 Я хочу получать комментарии с пагинацией.

Время на выполнение задания - 8 часов. По возможности - тесты приветствуются.

Технологии - стек Spring`а (но реализация - на усмотрение разработчика).

Endpoint list 
["GET /api/posts/pageable",
"POST /api/posts",
"PUT /api/posts/{id}",
"GET /api/posts",
"GET /api/posts/{id}",
"DELETE /api/posts/{id}",
"GET /endpoints",
"GET /error",
"GET /error"]

Pageable to use: 
http://localhost:8080/api/posts/pageable?page=PAGE NUMBER
where page number = just pick a page number.
Deafault page size is 3 => can change it in application.propoerties.
Application starts starts on port(s): 8080 (http) using Tomcat

Spring Data Rest - Sort by multiple properties
sort="xhane property name"

http://localhost:8080/api/posts/pageable?sort=id,desc
or asc

you can change 



