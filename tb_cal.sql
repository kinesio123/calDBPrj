CREATE TABLE tb_cal (
   id  int NOT NULL,
   op1  int NOT NULL,
   op  varchar(5) NOT NULL,
   op2  int NOT NULL,
   result  int NOT NULL
);

ALTER TABLE tb_cal ADD PRIMARY KEY (id);

select * from tb_cal;
drop table tb_cal;

Create Sequence seq_log
start with 1
increment by 1
maxvalue 10000000;

truncate table tb_cal;

delete from tb_cal;

drop Sequence seq_log;

