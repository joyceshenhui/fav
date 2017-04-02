create table tag
(
	tid number primary key,
	tname varchar2(100) not null,
	tcount number check(tcount > 0)
);



create table favorite(
	fid number primary key,
	flabel varchar2(100) not null,
	furl varchar2(255) not null,
	ftags varchar2(100),
	fdesc varchar2(1024)
);

insert into tag
select 1, 'java', 2 from dual union
select 2, 'struts', 1 from dual union
select 3, 'oracle', 1 from dual ;

insert into tag values(4,'服务器',2);
update tag set tcount=1 where tid=4;

insert into favorite 
select 1, 'Apache Struts', 'http://struts.apache.org', 'java,struts', 'struts官方网站' from dual union
select 2, 'Oracle', 'http://www.oracle.com', 'java,oracle', 'oracle官方网站' from dual;

insert into favorite 
select 4, 'Tomcat', 'http://www.tomcat.com', '服务器', '服务器官方网站' from dual;

create sequence seq_favorite start with 3;
create sequence seq_tag start with 4;

select * from tag;
select * from favorite;

delete from FAVORITE where flabel like 'Weibo%';
commit