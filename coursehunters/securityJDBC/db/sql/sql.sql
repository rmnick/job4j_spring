create table users (username varchar(50) primary key
					, password varchar(50)
					, enabled smallint not null);

insert into users values ('john', '{noop}test123', 1)
                          ,('mary', '{noop}test123', 1)
						  , ('nick', '{noop}test123', 1);

create table if not exists authorities (username varchar(50) not null references users (username)
										, authority varchar(50) not null
										, constraint unq_authority unique (username, authority));

insert into authorities values ('john', 'ROLE_EMPLOYEE')
, ('mary', 'ROLE_EMPLOYEE')
, ('mary', 'ROLE_MANAGER')
, ('nick', 'ROLE_EMPLOYEE')
, ('nick', 'ROLE_ADMIN');