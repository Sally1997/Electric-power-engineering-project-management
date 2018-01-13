==============================================================
 Table FeeAudit                                              
==============================================================
create table FeeAudit 
(
   FAuditNo             char(14)                       not null,
   PNo                  char(5)                        not null,
   SubmitterNo          char(12)                       not null,
   AuditorNo            char(12)                       not null,
   AuditAdv             varchar(104)                   not null,
   AuditTime            date                           not null,
   AuditState           varchar(5)                     not null,
   Fee                  decimal(10,2)                  not null,
   OFeeReason           varchar(104)                   null,
   constraint PK_FEEAUDIT primary key (FAuditNo),
   foreign key (PNo) references project(pno),
   foreign key (AuditorNo) references staff(staffno),
   foreign key (SubmitterNo) references staff(staffno)
);
-- 费用审核新建完成