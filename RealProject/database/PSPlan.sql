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

INSERT INTO `realproject`.`psplan` (`StageNo`, `PNo`, `SName`, `PubNo`, `CharPNo`, `STime`, `ETime`) VALUES ('100010', '10001', '第一阶段', '201526010001', '201526010004', '2015-02-03', '2015-12-11');
INSERT INTO `realproject`.`psplan` (`StageNo`, `PNo`, `SName`, `PubNo`, `CharPNo`, `STime`, `ETime`) VALUES ('100011', '10001', '第二阶段', '201526010004', '201526010001', '1997-03-18', '1997-06-11');
INSERT INTO `realproject`.`psplan` (`StageNo`, `PNo`, `SName`, `PubNo`, `CharPNo`, `STime`, `ETime`) VALUES ('100020', '10002', '第一阶段', '201526010003', '201526010002', '2015-02-03', '1997-06-11');

-- 项目阶段新建完成