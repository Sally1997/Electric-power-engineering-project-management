-- 项目阶段
-- 
CREATE TABLE PSPlan (
    StageNo CHAR(7) NOT NULL primary key,
    PNo CHAR(5) NOT NULL,
    SName VARCHAR(30) NOT NULL,
    PubNo CHAR(12) NOT NULL,
    CharPNo CHAR(12) NOT NULL,
    STime DATE NOT NULL,
    ETime DATE NOT NULL,
      KEY `fk_project_pubno` (`pubno`),
	  KEY `fk_project_charpno` (`charpno`),
	  KEY `fk_project_ptaskno` (`pno`),
    foreign key (PNo) references project(pno),
	CONSTRAINT `fk_psplan_charpno` FOREIGN KEY (`charpno`) REFERENCES `staff` (`staffno`),
	CONSTRAINT `fk_psplan_pubno` FOREIGN KEY (`pubno`) REFERENCES `staff` (`staffno`)
);
-- 项目阶段新建完成