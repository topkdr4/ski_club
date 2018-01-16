/*
Navicat PGSQL Data Transfer

Source Server         : ski_club
Source Server Version : 90604
Source Host           : localhost:5432
Source Database       : ski_club
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90604
File Encoding         : 65001

Date: 2018-01-17 01:13:09
*/


-- ----------------------------
-- Sequence structure for seq_game
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_game";
CREATE SEQUENCE "public"."seq_game"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_sportsman
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_sportsman";
CREATE SEQUENCE "public"."seq_sportsman"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_std
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_std";
CREATE SEQUENCE "public"."seq_std"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_trainer
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_trainer";
CREATE SEQUENCE "public"."seq_trainer"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 61
 CACHE 1;
SELECT setval('"public"."seq_trainer"', 61, true);

-- ----------------------------
-- Table structure for t_age_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_age_types";
CREATE TABLE "public"."t_age_types" (
"id" int4 NOT NULL,
"from" int2,
"to" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_age_types
-- ----------------------------
INSERT INTO "public"."t_age_types" VALUES ('1', '8', '14');
INSERT INTO "public"."t_age_types" VALUES ('2', '15', '18');
INSERT INTO "public"."t_age_types" VALUES ('3', '19', '29');
INSERT INTO "public"."t_age_types" VALUES ('4', '30', '39');
INSERT INTO "public"."t_age_types" VALUES ('5', '40', '49');

-- ----------------------------
-- Table structure for t_games
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_games";
CREATE TABLE "public"."t_games" (
"fk_sportsman_id" int4 NOT NULL,
"jump_range" float8 NOT NULL,
"judge_a" float8,
"judge_b" float8,
"judge_c" float8,
"judge_d" float8,
"judge_e" float8,
"compensation" float8 NOT NULL,
"wind" float8 NOT NULL,
"fk_game" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_games
-- ----------------------------
INSERT INTO "public"."t_games" VALUES ('61', '12', '8', '5', '17', '19', '11', '19', '1', '2');
INSERT INTO "public"."t_games" VALUES ('61', '133', '11', '13', '15', '17', '20', '3.5', '3', '1');
INSERT INTO "public"."t_games" VALUES ('61', '140', '20', '20', '20', '20', '20', '20', '20', '3');
INSERT INTO "public"."t_games" VALUES ('62', '14', '17', '20', '19', '18', '20', '20', '20', '3');
INSERT INTO "public"."t_games" VALUES ('62', '17', '15', '15', '17', '19', '20', '2', '1', '2');
INSERT INTO "public"."t_games" VALUES ('62', '150', '1', '15', '16', '17', '20', '5', '5', '1');
INSERT INTO "public"."t_games" VALUES ('63', '15', '20', '20', '20', '20', '20', '2', '2', '1');
INSERT INTO "public"."t_games" VALUES ('63', '150', '17', '18', '19', '20', '15', '2', '1', '2');
INSERT INTO "public"."t_games" VALUES ('63', '250', '18', '18', '20', '20', '20', '20', '20', '3');

-- ----------------------------
-- Table structure for t_games_list
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_games_list";
CREATE TABLE "public"."t_games_list" (
"id" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"game_date" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_games_list
-- ----------------------------
INSERT INTO "public"."t_games_list" VALUES ('1', 'Чемпионат', null);
INSERT INTO "public"."t_games_list" VALUES ('2', 'Кубок', null);
INSERT INTO "public"."t_games_list" VALUES ('3', 'Первенство', null);

-- ----------------------------
-- Table structure for t_sportsman
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sportsman";
CREATE TABLE "public"."t_sportsman" (
"id" int4 NOT NULL,
"family" varchar(50) COLLATE "default",
"name" varchar(50) COLLATE "default",
"weight" float8,
"height" float8,
"birthDay" date,
"yearOfStart" varchar(32) COLLATE "default",
"qualification" varchar(255) COLLATE "default" NOT NULL,
"sex" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_sportsman
-- ----------------------------
INSERT INTO "public"."t_sportsman" VALUES ('61', 'Решетов', 'Арсений', '180', '180', '1988-01-07', '2005', 'III разряд', 't');
INSERT INTO "public"."t_sportsman" VALUES ('62', 'Ветошкин', 'Александр', '180', '180', '1988-01-07', '2005', 'III разряд', 't');
INSERT INTO "public"."t_sportsman" VALUES ('63', 'Захаров', 'Сергей', '180', '180', '1988-01-07', '2005', 'III разряд', 't');

-- ----------------------------
-- Table structure for t_standarts_directory
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_standarts_directory";
CREATE TABLE "public"."t_standarts_directory" (
"id" int4 NOT NULL,
"sex" bool,
"fk_age_type" int4,
"name" text COLLATE "default",
"requier" float8,
"type" varchar(255) COLLATE "default",
"desc" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_standarts_directory
-- ----------------------------
INSERT INTO "public"."t_standarts_directory" VALUES ('1', 't', '1', 'Отжимание', '30', 'Количество', 'Проводится в спортивном зале, разрешается одна попытка. <br>
            <u><b>Описание теста:</b></u> Сгибание и разгибание рук в упоре лежа выполняется из ИП: упор
            лежа на полу, руки на ширине плеч, кисти вперед, локти разведены не более 45 градусов,
            плечи, туловище и ноги составляют прямую линию. Стопы упираются в пол без опоры
            вместе. Сгибая руки в локтевых суставах необходимо коснуться грудью пола (или платформы
            высотой 5 см), затем, разгибая руки, вернуться в ИП и, зафиксировав его на 0,5 сек.,
            продолжить выполнение упражнения. <br>
            <u><b>Результат:</b></u> Засчитывается количество правильно выполненных сгибаний и
            разгибаний рук, фиксируемых счетом судьи. Разрешается одна попытка. <br>
            <u><b>Ошибки:</b></u><br>
            1) касание пола коленями, бедрами, тазом;<br>
            2) нарушение прямой линии "плечи - туловище - ноги";<br>
            3) отсутствие фиксации на 0,5 сек. ИП;<br>
            4) разновременное разгибание рук. <br>');

-- ----------------------------
-- Table structure for t_standarts_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_standarts_result";
CREATE TABLE "public"."t_standarts_result"()
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_standarts_result
-- ----------------------------

-- ----------------------------
-- Table structure for t_trainer
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_trainer";
CREATE TABLE "public"."t_trainer" (
"id" int4 NOT NULL,
"family" varchar(50) COLLATE "default",
"name" varchar(50) COLLATE "default",
"qualification" varchar(255) COLLATE "default",
"dayOfBirth" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_trainer
-- ----------------------------
INSERT INTO "public"."t_trainer" VALUES ('13', 'Фамилия', 'Имя', 'Тренер-преподаватель высшего уровня квалификации без категории', '1973-10-15');
INSERT INTO "public"."t_trainer" VALUES ('14', '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('16', '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('17', '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('18', '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('22', 'Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('23', 'Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('24', 'Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('25', 'Фамилия', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('27', 'Фамилия', 'Имя', 'ТОп', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('46', 'Фамилия', 'Имя', 'ТОп', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('49', 'Лучшая', 'Имя', 'Высшая', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES ('50', 'Ветошкин', 'Александ', 'Тренер-преподаватель высшего уровня квалификации второй категории', '1994-10-02');
INSERT INTO "public"."t_trainer" VALUES ('51', 'dd', 'ddd', 'Тренер-преподаватель высшего уровня квалификации высшей категории', '2018-01-11');
INSERT INTO "public"."t_trainer" VALUES ('52', 'Юдкина', 'Екатерина', 'Инструктор, инструктор-методист высшего уровня квалификации первой категории', '2018-01-17');
INSERT INTO "public"."t_trainer" VALUES ('53', 'sdfsd', 'fsdfsdfds', 'Тренер-преподаватель высшего уровня квалификации высшей категории', '2018-01-16');
INSERT INTO "public"."t_trainer" VALUES ('60', 'Трататушкин', 'Ололшкин', 'Тренер-преподаватель высшего уровня квалификации высшей категории', '1973-01-12');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Uniques structure for table t_age_types
-- ----------------------------
ALTER TABLE "public"."t_age_types" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table t_age_types
-- ----------------------------
ALTER TABLE "public"."t_age_types" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_games_list
-- ----------------------------
ALTER TABLE "public"."t_games_list" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sportsman
-- ----------------------------
ALTER TABLE "public"."t_sportsman" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_standarts_directory
-- ----------------------------
ALTER TABLE "public"."t_standarts_directory" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_trainer
-- ----------------------------
ALTER TABLE "public"."t_trainer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."t_games"
-- ----------------------------
ALTER TABLE "public"."t_games" ADD FOREIGN KEY ("fk_sportsman_id") REFERENCES "public"."t_sportsman" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_games" ADD FOREIGN KEY ("fk_game") REFERENCES "public"."t_games_list" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
