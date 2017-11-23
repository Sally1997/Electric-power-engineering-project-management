-- 任务指标
CREATE TABLE TaskIndexes (
    IndexNo CHAR(11) NOT NULL primary key,
    TaskNo CHAR(10) NOT NULL,
    IndexInfo VARCHAR(100) NOT NULL,-- 指标内容
    AttachPath VARCHAR(100) NULL,-- 附件路径
    foreign key (taskNo) references stagetasks(taskno)
);
insert into taskindexes
values('10001100010','1000110001','I am a taskindex','D:\ProjectDatabase\taskindex\1.txt');

-- 任务指标新建完成