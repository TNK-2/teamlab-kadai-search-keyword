-- 修正SQL文
ALTER TABLE activity ADD INDEX idx_activity(page_id, user_id);

create view pageinf
as
select 
	p.id as id, 
    p.title as title, 
    a.user_id as user_id,
    a.page_id as page_id
from page p 
left join activity a on a.page_id = p.id; 
