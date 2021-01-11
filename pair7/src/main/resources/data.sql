
INSERT INTO users(Id, username, password, enabled, role)
	values(0,'admin', 'pass', true, 'ADMIN');
	
	
INSERT INTO authorities (Id, username, authority)
	values(0, 'admin', 'ROLE_ADMIN');	