--<ScriptOptions statementTerminator=";"/>

drop table if exists tb_comment;

delete from tb_comment;

create table tb_comment (
id int(10) unsigned not null auto_increment,
name varchar(32) not null,
content longtext not null,
primary key(id)
) ENGINE=InnoDB default charset=euckr;

select * from tb_comment;

insert into tb_comment(name, content) values('ȫ�浿', '�ȳ��ϼ���');

update tb_comment set name='������';
