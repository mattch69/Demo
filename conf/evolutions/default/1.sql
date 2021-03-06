# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table equipe (
  id                        bigint not null,
  nomEquipe                 varchar(255),
  constraint pk_equipe primary key (id))
;

create table match (
  id                        bigint not null,
  Equipe1                   bigint,
  Equipe2                   bigint,
  scoreEquipe1              integer,
  scoreEquipe2              integer,
  vainqueur                 bigint,
  dateMatch                 timestamp,
  constraint pk_match primary key (id))
;

create table pronostique (
  id                        bigint not null,
  match                     bigint,
  utilisateur               varchar(255),
  pronoEquipe1              integer,
  pronoEquipe2              integer,
  constraint pk_pronostique primary key (id))
;

create table utilisateur (
  nom                       varchar(255) not null,
  prenom                    varchar(255),
  points                    integer,
  password                  varchar(255),
  constraint pk_utilisateur primary key (nom))
;

create sequence equipe_seq;

create sequence match_seq;

create sequence pronostique_seq;

create sequence utilisateur_seq;

alter table match add constraint fk_match_equipe1_1 foreign key (Equipe1) references equipe (id) on delete restrict on update restrict;
create index ix_match_equipe1_1 on match (Equipe1);
alter table match add constraint fk_match_equipe2_2 foreign key (Equipe2) references equipe (id) on delete restrict on update restrict;
create index ix_match_equipe2_2 on match (Equipe2);
alter table match add constraint fk_match_vainqueur_3 foreign key (vainqueur) references equipe (id) on delete restrict on update restrict;
create index ix_match_vainqueur_3 on match (vainqueur);
alter table pronostique add constraint fk_pronostique_match_4 foreign key (match) references match (id) on delete restrict on update restrict;
create index ix_pronostique_match_4 on pronostique (match);
alter table pronostique add constraint fk_pronostique_utilisateur_5 foreign key (utilisateur) references utilisateur (nom) on delete restrict on update restrict;
create index ix_pronostique_utilisateur_5 on pronostique (utilisateur);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists equipe;

drop table if exists match;

drop table if exists pronostique;

drop table if exists utilisateur;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists equipe_seq;

drop sequence if exists match_seq;

drop sequence if exists pronostique_seq;

drop sequence if exists utilisateur_seq;

