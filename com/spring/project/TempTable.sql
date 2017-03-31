
create table T_XBBNHCJ_Templates(code int,name varchar(20),p_votes int,n_votes int,url varchar(30),price float);
insert into T_XBBNHCJ_Templates values(101,'Flower1',45,5,'http://temp/flower1',2250);
insert into T_XBBNHCJ_Templates values(102,'Retro',55,1,'http://temp/retro',1755);
insert into T_XBBNHCJ_Templates values(103,'Art',71,7,'http://temp/art',1025);
insert into T_XBBNHCJ_Templates values(104,'Punch',44,11,'http://temp/punch',1235);
create table T_XBBNHCJ_CustomerDetail(cust_id int,cust_name varchar(20),mail_id varchar(20),credits int);
insert into T_XBBNHCJ_CustomerDetail values(1111,'Priya','abc@xxx.com',45);
create table T_XBBNHCJ_Customization(id int,temp_id int,title varchar(30),quote varchar(50),contact varchar(100));
alter table T_XBBNHCJ_Customization add count int;
select * from T_XBBNHCJ_Customization;
drop table T_XBBNHCJ_Customization;
create schema user;
select * from T_XBBNHCJ_Templates;

delete from T_XBBNHCJ_Templates;
alter table T_XBBNHCJ_Customization add cust_id int;
insert into T_XBBNHCJ_Customization values(1211,101,'Renu Classics','feel good','xxx,yyy,zzz-390214832',1112);
insert into T_XBBNHCJ_Customization values(1212,103,'Modern Arts','enter fantasy','5-fgh,vbn,ppp-489032',1111);
insert into T_XBBNHCJ_Customization values(1213,102,'Spring minds','knowledge quest','67-fgfh,yere,zzz-3934832',1113);
alter table T_XBBNHCJ_Customization rename column id to custom_id;
select * from T_XBBNHCJ_Customization;
create table T_XBBNHCJ_Purchase(purchase_id int,cust_id int,purchase_date varchar(20),credits_spent int,credits_earned int,total_price int);
alter table T_XBBNHCJ_Purchase alter column total_price float;
insert into T_XBBNHCJ_Purchase values(1,1112,'10-Sep-2016',70,0,750);
insert into T_XBBNHCJ_Purchase values(2,1113,'5-Dec-2015',0,12,600);
insert into T_XBBNHCJ_Purchase values(3,1112,'10-Jan-2017',0,11,550);
alter table T_XBBNHCJ_Customization drop column pwd;
alter table T_XBBNHCJ_Purchase drop column purchase_id;
alter table T_XBBNHCJ_Customer add pwd varchar(50);
delete from T_XBBNHCJ_Customer where name='Priya';
select * from T_XBBNHCJ_CustomUrl;


insert into T_XBBNHCJ_Customer values('Priya','abc@xxx.com',45,'priya');
insert into T_XBBNHCJ_Customer values('Shruthi','xyz@xxx.com',71,'shruthi','1112');

create table T_XBBNHCJ_CustomUrl(id int,temp_id int,custom_url varchar(70));
insert into T_XBBNHCJ_CustomUrl values(901,101,'http://garden/priya');
insert into T_XBBNHCJ_CustomUrl values(902,101,'http://advertisement/priya');
insert into T_XBBNHCJ_CustomUrl values(903,101,'http://garden/catherin');
delete from T_XBBNHCJ_CustomUrl;

alter table T_XBBNHCJ_Customer add customer_id int;
update T_XBBNHCJ_Customer set customer_id='1111' where name='Priya';

delete from T_XBBNHCJ_Customization where CUSTOM_ID=0;
drop table T_XBBNHCJ_Purchase;
alter table T_XBBNHCJ_Purchase drop column purchase_date;
alter table T_XBBNHCJ_Purchase drop column total_price;
alter table T_XBBNHCJ_Purchase add column total_price float;

delete from T_XBBNHCJ_Purchase;

create table T_XBBNHCJ_Registration(id int,name varchar(40),mail_id varchar(50),pwd varchar(40),contact varchar(20));
insert into T_XBBNHCJ_Registration values(11,'Priyanka','acc@ccc.com','priyanka','21323443');
insert into T_XBBNHCJ_Registration values(12,'shruthi','asc@ccc.com','shru','213234443');
insert into T_XBBNHCJ_Registration values(13,'sasi','ssc@ccc.com','sasi','21354443',70);


select * from T_XBBNHCJ_Purchase;

update T_XBBNHCJ_Registration set credits=45 where name='Priyanka';
update T_XBBNHCJ_Registration set credits=75 where name='shruthi';
update T_XBBNHCJ_Registration set credits=50 where name='sasi';

update T_XBBNHCJ_Registration set id=1111 where name='Priyanka';
update T_XBBNHCJ_Registration set id=1112 where name='shruthi';
update T_XBBNHCJ_Registration set id=1113where name='sasi';

delete from T_XBBNHCJ_Registration where id=13;

alter table T_XBBNHCJ_Registration add credits int;

alter table T_XBBNHCJ_Customization drop column id;

select  * from T_XBBNHCJ_Registration;
select  * from T_XBBNHCJ_Customization;
select  * from T_XBBNHCJ_Templates;

delete from T_XBBNHCJ_Registration where id in (15,16,17,14,18,19,20,21,22,23,24,25,26,27,28);
delete from T_XBBNHCJ_CustomUrl where temp_id=111;
delete from T_XBBNHCJ_CustomUrl;
CREATE SEQUENCE customurl_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
update T_XBBNHCJ_Templates set temp_name='Flower1' where temp_id=101;
select * from T_XBBNHCJ_Templates;

drop table T_XBBNHCJ_Bank;
create table T_XBBNHCJ_Bank(name varchar(40),accountNumber varchar(40),cardNumber varchar(40),pin int,amount float);
insert into T_XBBNHCJ_Bank values('Priyanka','1234567890','12345678123',123,45000);
insert into T_XBBNHCJ_Bank values('Sasi','112314890','12345678123',123,45000);
insert into T_XBBNHCJ_Bank values('Maran','123453444490','12345678123',123,45000);
insert into T_XBBNHCJ_Bank values('Shruthika','1233337890','12345678123',123,45000);
