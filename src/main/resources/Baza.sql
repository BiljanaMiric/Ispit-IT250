drop table if exists AUTOMOBIL;

drop table if exists KORISNIK;

drop table if exists MARKA;

drop table if exists MODEL;

drop table if exists SERVIS;

/*==============================================================*/
/* Table: AUTOMOBIL                                             */
/*==============================================================*/
create table AUTOMOBIL
(
   AUTOMOBIL_ID         int not null auto_increment,
   MARKA_ID             int,
   KORISNIK_ID          int not null,
   AUTOMOBIL_DATUM_UNOSA date not null,
   primary key (AUTOMOBIL_ID)
);

/*==============================================================*/
/* Table: KORISNIK                                              */
/*==============================================================*/
create table KORISNIK
(
   KORISNIK_ID          int not null auto_increment,
   KORISNIK_IME         varchar(1024),
   KORISNIK_PREZIME     varchar(1024),
   KORISNIK_USERNAME    varchar(256) not null,
   KORISNIK_PASSWORD    varchar(512) not null,
   KORISNIK_ROLA        varchar(20),
   primary key (KORISNIK_ID)
);

/*==============================================================*/
/* Table: MARKA                                                 */
/*==============================================================*/
create table MARKA
(
   MARKA_ID             int not null auto_increment,
   MARKA_IME            varchar(256) not null,
   primary key (MARKA_ID)
);

/*==============================================================*/
/* Table: MODEL                                                 */
/*==============================================================*/
create table MODEL
(
   MODEL_ID             int not null auto_increment,
   MARKA_ID             int,
   MODEL_IME            varchar(253) not null,
   MODEL_KUBLIKAZA      int not null,
   MODEL_GODINA         int not null,
   MODEL_OPREMA         varchar(2048),
   primary key (MODEL_ID)
);

/*==============================================================*/
/* Table: SERVIS                                                */
/*==============================================================*/
create table SERVIS
(
   SERVIS_ID            int not null auto_increment,
   AUTOMOBIL_ID         int not null,
   SERVIS_DATUMSERVISA  date,
   SERVIS_DATUMKRAJASERVISA date,
   KILOMETRAZA          int,
   CENA                 decimal(8,4),
   primary key (SERVIS_ID)
);

alter table AUTOMOBIL add constraint FK_AUTMOBIL_IMA_MARKU foreign key (MARKA_ID)
      references MARKA (MARKA_ID) on delete restrict on update restrict;

alter table AUTOMOBIL add constraint FK_KORISNIK_MOZE_BITI_VLASNIK_AUTOMOBILA foreign key (KORISNIK_ID)
      references KORISNIK (KORISNIK_ID) on delete restrict on update restrict;

alter table MODEL add constraint FK_SVAKI_MODEL_IMA_MARKU foreign key (MARKA_ID)
      references MARKA (MARKA_ID) on delete restrict on update restrict;

alter table SERVIS add constraint FK_SVAKI_SERVIS_JE_NAD_AUTOMOBILOM foreign key (AUTOMOBIL_ID)
      references AUTOMOBIL (AUTOMOBIL_ID) on delete restrict on update restrict;
