# --- Sample dataset

# --- !Ups

insert into Equipe (id,nomEquipe) values (  1,'Ajaccio');
insert into Equipe (id,nomEquipe) values (  2,'Bastia');
insert into Equipe (id,nomEquipe) values (  3,'Bordeaux');
insert into Equipe (id,nomEquipe) values (  4,'Brest');
insert into Equipe (id,nomEquipe) values (  5,'Evian TG');
insert into Equipe (id,nomEquipe) values (  6,'Lille');
insert into Equipe (id,nomEquipe) values (  7,'Lorient');
insert into Equipe (id,nomEquipe) values (  8,'Lyon');
insert into Equipe (id,nomEquipe) values (  9,'Marseille');
insert into Equipe (id,nomEquipe) values (  10,'Montpellier');
insert into Equipe (id,nomEquipe) values (  11,'Nancy');
insert into Equipe (id,nomEquipe) values (  12,'Nice');
insert into Equipe (id,nomEquipe) values (  13,'Paris');
insert into Equipe (id,nomEquipe) values (  14,'Reims');
insert into Equipe (id,nomEquipe) values (  15,'Rennes');
insert into Equipe (id,nomEquipe) values (  16,'Saint-Etienne');
insert into Equipe (id,nomEquipe) values (  17,'Sochaux');
insert into Equipe (id,nomEquipe) values (  18,'Toulouse');
insert into Equipe (id,nomEquipe) values (  19,'Troyes');
insert into Equipe (id,nomEquipe) values (  20,'Valenciennes');

insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (1,10,18,2,0,10);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (2,5,3,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (3,11,4,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (4,12,1,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (5,13,7,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (6,15,8,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (7,16,6,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (8,17,2,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (9,19,20,null,null,null);
insert into Match (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (10,14,9,null,null,null);

insert into Utilisateur (nom,prenom,points,password) values ('toto','toto',0,'toto');

insert into Pronostique (id,match,utilisateur,pronoEquipe1,pronoEquipe2) values (1,1,'toto',3,2);

# --- !Downs

delete from Pronostique;
delete from Match;
delete from Equipe;
delete from Utilisateur;