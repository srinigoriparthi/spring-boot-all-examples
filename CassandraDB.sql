create keyspace persondb with replication={'class':'SimpleStrategy', 'replication_factor':1};


use persondb;
create table person(
                       id text,
                       firstName text,
                       lastName text,
                       phone text,
                       email text,
                       address text,
                       primary key(id)
);

insert into person (id,firstName,lastName,phone,email,address) values ('1','Srinivasa Rao', 'Goriparthi','+1 302-287-6058', 'srini.goriparthi@gmail.com','USA');

--insert into person (id,firstName,lastName,phone,email,address,creatDt) values ('1','Srinivasa Rao', 'Goriparthi','+1 302-287-6058', 'srini.goriparthi@gmail.com','USA', toTimeStamp(toDate(now())));

select * from person;
select * from persondb.person where id='1';


delete from persondb.person where id='1';
drop table persondb.person;