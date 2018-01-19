/*
 Navicat Premium Data Transfer

 Source Server         : ski_club
 Source Server Type    : PostgreSQL
 Source Server Version : 90604
 Source Host           : localhost:5432
 Source Catalog        : ski_club
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90604
 File Encoding         : 65001

 Date: 19/01/2018 12:03:28
*/


-- ----------------------------
-- Sequence structure for seq_game
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_game";
CREATE SEQUENCE "public"."seq_game" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_game_info
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_game_info";
CREATE SEQUENCE "public"."seq_game_info" 
INCREMENT 1
MINVALUE  10
MAXVALUE 9223372036854775807
START 10
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_result
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_result";
CREATE SEQUENCE "public"."seq_result" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_sportsman
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_sportsman";
CREATE SEQUENCE "public"."seq_sportsman" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_std
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_std";
CREATE SEQUENCE "public"."seq_std" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_trainer
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_trainer";
CREATE SEQUENCE "public"."seq_trainer" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for t_age_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_age_types";
CREATE TABLE "public"."t_age_types" (
  "id" int4 NOT NULL,
  "from" int2,
  "to" int2
)
;

-- ----------------------------
-- Records of t_age_types
-- ----------------------------
INSERT INTO "public"."t_age_types" VALUES (1, 8, 14);
INSERT INTO "public"."t_age_types" VALUES (2, 15, 18);
INSERT INTO "public"."t_age_types" VALUES (3, 19, 29);
INSERT INTO "public"."t_age_types" VALUES (4, 30, 39);
INSERT INTO "public"."t_age_types" VALUES (5, 40, 49);

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
  "fk_game" int4,
  "id" int4
)
;

-- ----------------------------
-- Records of t_games
-- ----------------------------
INSERT INTO "public"."t_games" VALUES (61, 133, 11, 13, 15, 17, 20, 3.5, 3, 1, 1);
INSERT INTO "public"."t_games" VALUES (63, 15, 20, 20, 20, 20, 20, 2, 2, 1, 3);
INSERT INTO "public"."t_games" VALUES (62, 150, 1, 15, 16, 17, 20, 5, 5, 1, 2);
INSERT INTO "public"."t_games" VALUES (61, 12, 8, 5, 17, 19, 11, 19, 1, 2, 4);
INSERT INTO "public"."t_games" VALUES (62, 17, 15, 15, 17, 19, 20, 2, 1, 2, 5);
INSERT INTO "public"."t_games" VALUES (63, 150, 17, 18, 19, 20, 15, 2, 1, 2, 6);
INSERT INTO "public"."t_games" VALUES (61, 140, 20, 20, 20, 20, 20, 20, 20, 3, 7);
INSERT INTO "public"."t_games" VALUES (63, 250, 18, 18, 20, 20, 20, 20, 20, 3, 8);
INSERT INTO "public"."t_games" VALUES (62, 14, 17, 20, 19, 18, 20, 20, 20, 3, 9);

-- ----------------------------
-- Table structure for t_games_list
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_games_list";
CREATE TABLE "public"."t_games_list" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "game_date" date
)
;

-- ----------------------------
-- Records of t_games_list
-- ----------------------------
INSERT INTO "public"."t_games_list" VALUES (1, 'Чемпионат', '2018-01-17');
INSERT INTO "public"."t_games_list" VALUES (2, 'Кубок', '2018-01-09');
INSERT INTO "public"."t_games_list" VALUES (3, 'Первенство', '2017-12-25');

-- ----------------------------
-- Table structure for t_sportsman
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sportsman";
CREATE TABLE "public"."t_sportsman" (
  "id" int4 NOT NULL,
  "family" varchar(50) COLLATE "pg_catalog"."default",
  "name" varchar(50) COLLATE "pg_catalog"."default",
  "weight" float8,
  "height" float8,
  "birthDay" date,
  "yearOfStart" varchar(32) COLLATE "pg_catalog"."default",
  "qualification" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "sex" bool
)
;

-- ----------------------------
-- Records of t_sportsman
-- ----------------------------
INSERT INTO "public"."t_sportsman" VALUES (62, 'Ветошкин', 'Александр', 180, 180, '1988-01-07', '2005', 'III разряд', 't');
INSERT INTO "public"."t_sportsman" VALUES (63, 'Захаров', 'Сергей', 180, 180, '1988-01-07', '2005', 'III разряд', 't');
INSERT INTO "public"."t_sportsman" VALUES (61, 'Решетов', 'Арсений', 180, 180, '2018-01-10', '2005', 'III разряд', 't');

-- ----------------------------
-- Table structure for t_standarts_directory
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_standarts_directory";
CREATE TABLE "public"."t_standarts_directory" (
  "id" int4 NOT NULL,
  "sex" bool,
  "fk_age_type" int4,
  "name" text COLLATE "pg_catalog"."default",
  "requier" float8,
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "desc" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of t_standarts_directory
-- ----------------------------
INSERT INTO "public"."t_standarts_directory" VALUES (5, 'f', 1, 'Бег', 4, 'Время', '1 километр');
INSERT INTO "public"."t_standarts_directory" VALUES (6, 'f', 2, 'Бег', 15, 'Время', '4 километра');
INSERT INTO "public"."t_standarts_directory" VALUES (1, 't', 4, 'Отжимание', 30, 'Количество', 'Проводится в спортивном зале, разрешается одна попытка. <br>
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
INSERT INTO "public"."t_standarts_directory" VALUES (4, 't', 4, 'Подтягивание', 5, 'Количество', 'Подтягивания - это упражнение, чаще всего выполняемое на турнике; рабочие группы мышц: комплекс мышц рук (главным образом,предплечья, бицепсы) и спины (широчайшие). Чем шире хват руками за перекладину, тем больше нагрузка ложится на широчайшие мышцы спины; чем уже хват – тем больше нагрузка ложится на бицепсы. Если подтягиваться, касаясь перекладины затылком, то широчайшие мышцы растягиваются в ширину. А если подтягиваться, касаясь подбородком, то широчайшие растягиваются ещё и в толщину. При узком хвате, ладонями к себе, дополнительную нагрузку получает нижняя часть широчайших, находящаяся в районе талии.');

-- ----------------------------
-- Table structure for t_standarts_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_standarts_result";
CREATE TABLE "public"."t_standarts_result" (
  "fk_trainer" int4,
  "fk_sportsman" int4,
  "fk_standard" int4,
  "result" float8,
  "success" bool,
  "date" date,
  "id" int4 NOT NULL
)
;

-- ----------------------------
-- Records of t_standarts_result
-- ----------------------------
INSERT INTO "public"."t_standarts_result" VALUES (23, 63, 1, 12, 't', '2018-01-17', 1);
INSERT INTO "public"."t_standarts_result" VALUES (NULL, 62, 1, 12, 't', '2018-01-17', 2);

-- ----------------------------
-- Table structure for t_trainer
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_trainer";
CREATE TABLE "public"."t_trainer" (
  "id" int4 NOT NULL,
  "family" varchar(50) COLLATE "pg_catalog"."default",
  "name" varchar(50) COLLATE "pg_catalog"."default",
  "qualification" varchar(255) COLLATE "pg_catalog"."default",
  "dayOfBirth" date
)
;

-- ----------------------------
-- Records of t_trainer
-- ----------------------------
INSERT INTO "public"."t_trainer" VALUES (17, '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (18, '"Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (22, 'Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (23, 'Фамилия"', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (25, 'Фамилия', '"Имя"', '"ТОп"', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (27, 'Фамилия', 'Имя', 'ТОп', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (46, 'Фамилия', 'Имя', 'ТОп', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (49, 'Лучшая', 'Имя', 'Высшая', '2018-01-24');
INSERT INTO "public"."t_trainer" VALUES (50, 'Ветошкин', 'Александ', 'Тренер-преподаватель высшего уровня квалификации второй категории', '1994-10-02');
INSERT INTO "public"."t_trainer" VALUES (52, 'Юдкина', 'Екатерина', 'Инструктор, инструктор-методист высшего уровня квалификации первой категории', '2018-01-17');
INSERT INTO "public"."t_trainer" VALUES (53, 'sdfsd', 'fsdfsdfds', 'Тренер-преподаватель высшего уровня квалификации высшей категории', '2018-01-16');
INSERT INTO "public"."t_trainer" VALUES (60, 'Трататушкин', 'Ололшкин', 'Тренер-преподаватель высшего уровня квалификации высшей категории', '1973-01-12');
INSERT INTO "public"."t_trainer" VALUES (13, 'Фамилия', 'Имя', 'Тренер-преподаватель высшего уровня квалификации без категории', '1973-10-15');

-- ----------------------------
-- Function structure for get_compensation_record
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_compensation_record"("p_sex" bool);
CREATE OR REPLACE FUNCTION "public"."get_compensation_record"("p_sex" bool)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select  
			DISTINCT
			t_sportsman.id,
			t_sportsman.family,
			t_games.compensation,
			t_games_list.game_date
		from t_sportsman, t_games, t_games_list
			where t_sportsman."id" = t_games.fk_sportsman_id
			and t_games.compensation = (select max(compensation) from t_games where t_sportsman."id" = t_games.fk_sportsman_id limit 1)
			and sex = p_sex
			and t_games_list.id = t_games.fk_game
		order by compensation desc
		limit 10;

	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_fk_std
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_fk_std"("p_ages" int4);
CREATE OR REPLACE FUNCTION "public"."get_fk_std"("p_ages" int4)
  RETURNS "pg_catalog"."int4" AS $BODY$DECLARE
	res int4;

BEGIN
	select id from t_age_types where t_age_types."from" <= p_ages and t_age_types."to" >= p_ages limit 1 into res;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_game_result
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_game_result"();
CREATE OR REPLACE FUNCTION "public"."get_game_result"()
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_trainer;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_games
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_games"("p_date" date);
CREATE OR REPLACE FUNCTION "public"."get_games"("p_date" date)
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_games_list where t_games_list.game_date = p_date;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_judge_record
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_judge_record"("p_sex" bool);
CREATE OR REPLACE FUNCTION "public"."get_judge_record"("p_sex" bool)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select
			t_sportsman.id, 
			t_sportsman.family,
			max(
					t_games.judge_a + t_games.judge_b + t_games.judge_c + t_games.judge_d + t_games.judge_e
					- GREATEST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
					- LEAST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
				) score
		from t_sportsman, t_games
			where t_sportsman.id = t_games.fk_sportsman_id
			and sex = TRUE
			group by family, t_sportsman.id, t_games.fk_sportsman_id
			order by score desc limit 10;

	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_jump_range_record
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_jump_range_record"("p_sex" bool);
CREATE OR REPLACE FUNCTION "public"."get_jump_range_record"("p_sex" bool)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select  
			DISTINCT
			t_sportsman.id,
			t_sportsman.family,
			t_games.jump_range,
			t_games_list.game_date
		from t_sportsman, t_games, t_games_list
			where t_sportsman."id" = t_games.fk_sportsman_id
			and t_games.jump_range = (select max(jump_range) from t_games where t_sportsman."id" = t_games.fk_sportsman_id limit 1)
			and t_sportsman.sex = p_sex
			and t_games.fk_game = t_games_list.id
		order by jump_range desc
		limit 10;

	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_places
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_places"("p_id" int4);
CREATE OR REPLACE FUNCTION "public"."get_places"("p_id" int4)
  RETURNS "pg_catalog"."_int4" AS $BODY$
DECLARE
    rec  record;
		rec2 record;
		l_places int[] := ARRAY[ 0, 0, 0 ];
		ind int4;
BEGIN
    FOR rec IN (SELECT t_games_list.id FROM t_games_list)
    LOOP 
				ind:= 1;
				for rec2 in (select  
											family,
											id, 
											t_games.judge_a + t_games.judge_b + t_games.judge_c + t_games.judge_d + t_games.judge_e
											+ t_games.jump_range + t_games.compensation + t_games.wind
											- LEAST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
											- GREATEST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
											as score
										from t_sportsman, t_games where t_games.fk_game = rec.id and t_games.fk_sportsman_id = t_sportsman.id order by score desc limit 3)
				LOOP
					if rec2.id = p_id then
						if ind = 1 THEN
							l_places[1]:= l_places[1] + 1;
						elseif ind = 2 THEN
							l_places[2]:= l_places[2] + 1;
						elseif ind = 3 THEN
							l_places[3]:= l_places[3] + 1;
						end if;
					end if;
					ind:= ind + 1;
				END LOOP;
				
    END LOOP;
	
	  return l_places;
END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsman_info
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsman_info"("p_sportsman_id" int4);
CREATE OR REPLACE FUNCTION "public"."get_sportsman_info"("p_sportsman_id" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_sportsman where id = p_sportsman_id;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsmans_count
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsmans_count"();
CREATE OR REPLACE FUNCTION "public"."get_sportsmans_count"()
  RETURNS "pg_catalog"."int4" AS $BODY$

DECLARE
	trainer_count int;

BEGIN
	select "count"(*) from t_sportsman into trainer_count;
	return trainer_count;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsmans_game
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsmans_game"("p_game_id" int4);
CREATE OR REPLACE FUNCTION "public"."get_sportsmans_game"("p_game_id" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$ DECLARE
	res refcursor;
BEGIN
	OPEN res FOR SELECT
	t_sportsman."family",
	t_games.* 
FROM
	t_games,
	t_sportsman 
WHERE
	t_sportsman.ID = t_games.fk_sportsman_id 
	AND t_games.fk_game = p_game_id;
RETURN res;

END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsmans_page
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsmans_page"("p_from" int4, "p_to" int4);
CREATE OR REPLACE FUNCTION "public"."get_sportsmans_page"("p_from" int4, "p_to" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for SELECT "id", "family", "name", "weight", "height", "birthDay", "yearOfStart", "qualification", "sex"
	FROM (SELECT ROW_NUMBER() OVER (ORDER BY id) AS Row, *
			 FROM t_sportsman ) us 
	WHERE Row > p_from and Row < p_to;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsmens
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsmens"();
CREATE OR REPLACE FUNCTION "public"."get_sportsmens"()
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_sportsman;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sportsmens_category
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sportsmens_category"("p_sex" bool, "p_age" int4);
CREATE OR REPLACE FUNCTION "public"."get_sportsmens_category"("p_sex" bool, "p_age" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for 
		SELECT
			* 
		FROM
			t_sportsman 
		where
			get_fk_std(date_part('year', age( CURRENT_DATE, t_sportsman."birthDay" ))::int) = get_fk_std(p_age)
			and sex = p_sex;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_standard
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_standard"("p_sex" bool, "p_ages" int4);
CREATE OR REPLACE FUNCTION "public"."get_standard"("p_sex" bool, "p_ages" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select 
			id,
			name, 
			requier, 
			type, 
			"desc" 
		from t_standarts_directory 
			where t_standarts_directory.fk_age_type = get_fk_std(p_ages)
			and p_sex = sex;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_standard_result
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_standard_result"("p_id_std" int4, "p_date" date);
CREATE OR REPLACE FUNCTION "public"."get_standard_result"("p_id_std" int4, "p_date" date)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select 
			t_sportsman.*, 
			t_standarts_result.fk_trainer, t_standarts_result.result, t_standarts_result.success, t_standarts_result."date", t_standarts_result.id result_id
		from t_sportsman, t_standarts_result 
			where 
			t_standarts_result.fk_standard = p_id_std and 
			t_standarts_result.date = p_date and
			t_sportsman.id = t_standarts_result.fk_sportsman;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_sum_record
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_sum_record"("p_sex" bool);
CREATE OR REPLACE FUNCTION "public"."get_sum_record"("p_sex" bool)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select  
			id, 
		  family,
			max(
					t_games.judge_a + t_games.judge_b + t_games.judge_c + t_games.judge_d + t_games.judge_e
					- GREATEST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
					- LEAST(t_games.judge_a, t_games.judge_b, t_games.judge_c, t_games.judge_d, t_games.judge_e)
					+ t_games.jump_range + t_games.compensation + t_games.wind
				) score
		from t_sportsman, t_games
			where t_sportsman.id = t_games.fk_sportsman_id
			and sex = p_sex
			group by family, id, t_games.fk_sportsman_id
			order by score desc limit 10;

	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_trainer_info
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_trainer_info"("p_trainer_id" int4);
CREATE OR REPLACE FUNCTION "public"."get_trainer_info"("p_trainer_id" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_trainer where id = p_trainer_id;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_trainers
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_trainers"();
CREATE OR REPLACE FUNCTION "public"."get_trainers"()
  RETURNS "pg_catalog"."refcursor" AS $BODY$

DECLARE
	res refcursor;

BEGIN
	open res for select * from t_trainer;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_trainers_count
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_trainers_count"();
CREATE OR REPLACE FUNCTION "public"."get_trainers_count"()
  RETURNS "pg_catalog"."int4" AS $BODY$

DECLARE
	trainer_count int;

BEGIN
	select "count"(*) from t_trainer into trainer_count;
	return trainer_count;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_trainers_page
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_trainers_page"("p_from" int4, "p_to" int4);
CREATE OR REPLACE FUNCTION "public"."get_trainers_page"("p_from" int4, "p_to" int4)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for SELECT "id", "family", "name", "qualification", "dayOfBirth"
	FROM (SELECT ROW_NUMBER() OVER (ORDER BY id) AS Row, *
			 FROM t_trainer ) us 
	WHERE Row > p_from and Row < p_to;
	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for get_wind_record
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."get_wind_record"("p_sex" bool);
CREATE OR REPLACE FUNCTION "public"."get_wind_record"("p_sex" bool)
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE
	res refcursor;

BEGIN
	open res for 
		select  
			DISTINCT
			t_sportsman.id,
			t_sportsman.family,
			t_games.wind,
			t_games_list.game_date
		from t_sportsman, t_games, t_games_list
			where t_sportsman."id" = t_games.fk_sportsman_id
			and t_games.wind = (select max(wind) from t_games where t_sportsman."id" = t_games.fk_sportsman_id limit 1)
			and sex = p_sex
			and t_games.fk_game = t_games_list.id
		order by wind desc
		limit 10;

	return res;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for remove_result
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."remove_result"("p_result_id" int4);
CREATE OR REPLACE FUNCTION "public"."remove_result"("p_result_id" int4)
  RETURNS "pg_catalog"."void" AS $BODY$DECLARE

BEGIN
	delete from t_standarts_result where t_standarts_result."id" = p_result_id;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for remove_trainer
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."remove_trainer"("p_trainer_id" int4);
CREATE OR REPLACE FUNCTION "public"."remove_trainer"("p_trainer_id" int4)
  RETURNS "pg_catalog"."void" AS $BODY$DECLARE

BEGIN
	UPDATE t_standarts_result
		SET
			fk_trainer = null
	WHERE t_standarts_result.fk_trainer = p_trainer_id;
	
	delete from t_trainer where t_trainer."id" = p_trainer_id;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for save_sportsman
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."save_sportsman"("js" json);
CREATE OR REPLACE FUNCTION "public"."save_sportsman"("js" json)
  RETURNS "pg_catalog"."int4" AS $BODY$DECLARE	
	future_uid int4;

BEGIN

	if (js->>'id')::text is NULL then 
		/*
			Добавление нового
		*/		
		SELECT nextval('seq_sportsman') INTO future_uid;
		
		INSERT INTO "public"."t_sportsman"("id", "family", "name", "weight", "height", "birthDay", "yearOfStart", "qualification", "sex")
		VALUES (
				future_uid, 
				(js->>'family')::text,
				(js->>'name')::text,
				(js->>'weight')::float,
				(js->>'height')::float,
				(js->>'birthDay')::text::date,
				(js->>'yearOfStart')::int,
				(js->>'qualification')::text,
				(js->>'sex')::boolean
		);
		return future_uid; 
	end if;

	/*
		Обновление данных Спортсмена
	*/

	future_uid = (js->>'id')::INT;

	UPDATE "public"."t_sportsman"
		SET
			"family"        = (js->>'family')::text,
			"name"          = (js->>'name')::text,
			"weight" 				= (js->>'height')::float,
			"height"   			= (js->>'height')::float,
			"birthDay"      = (js->>'birthDay')::text::date,
			"yearOfStart"   = (js->>'yearOfStart')::int,
			"qualification" = (js->>'qualification')::text,
			"sex"           = (js->>'sex')::boolean
	WHERE id = future_uid;

	return future_uid;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for save_standart
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."save_standart"("js" json, "p_sex" bool, "p_age" int4);
CREATE OR REPLACE FUNCTION "public"."save_standart"("js" json, "p_sex" bool, "p_age" int4)
  RETURNS "pg_catalog"."int4" AS $BODY$DECLARE
	future_uid int4;
	age int4;
BEGIN

	age = get_fk_std(p_age);
	

	if (js->>'id')::text is NULL then 
		/*
			Добавление нового
		*/		
		SELECT nextval('seq_std') INTO future_uid;
		
		INSERT INTO "public"."t_standarts_directory"("id", "sex", "fk_age_type", "name", "requier", "type", "desc")
		VALUES (
				future_uid, 
				p_sex, 
				age,
				(js->>'name')::text,
				(js->>'requier')::float,
				(js->>'type')::text,
				(js->>'desc')::text
		);
		return future_uid; 
	end if;

	/*
		Обновление данных тренера
	*/

	future_uid = (js->>'id')::INT;

	UPDATE "public"."t_standarts_directory"
		SET
			"sex"         = p_sex,
			"fk_age_type" = age,
			"name"        = (js->>'name')::text,
			"requier"     = (js->>'requier')::float,
			"type"        = (js->>'type')::text,
			"desc"        = (js->>'desc')::text
	WHERE id = future_uid;

	return future_uid;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for save_standrard_result
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."save_standrard_result"("p_trainer_id" int4, "p_sportsman_id" int4, "p_std_id" int4, "p_result" float8, "p_success" bool, "p_date" date, "p_result_id" int4);
CREATE OR REPLACE FUNCTION "public"."save_standrard_result"("p_trainer_id" int4, "p_sportsman_id" int4, "p_std_id" int4, "p_result" float8, "p_success" bool, "p_date" date, "p_result_id" int4)
  RETURNS "pg_catalog"."void" AS $BODY$DECLARE
	future_uid int4;
BEGIN

if p_trainer_id = 0 then
	p_trainer_id = null;
end if;

if p_result_id = 0 then
	SELECT nextval('seq_trainer') INTO future_uid;
	insert into t_standarts_result(fk_trainer, fk_sportsman, fk_standard, result, success, "date", id)
	values(p_trainer_id, p_sportsman_id, p_std_id, p_result, p_success, p_date, future_uid);
	return;
end if;

	UPDATE t_standarts_result
	set
		fk_trainer = p_trainer_id,
		fk_sportsman = p_sportsman_id,
		fk_standard = p_std_id,
		result = p_result,
		success = p_success,
		"date" = p_date
	where id = p_result_id;

END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for save_trainer
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."save_trainer"("js" json);
CREATE OR REPLACE FUNCTION "public"."save_trainer"("js" json)
  RETURNS "pg_catalog"."int4" AS $BODY$DECLARE
	future_uid int4;

BEGIN

	if (js->>'id')::text is NULL then 
		/*
			Добавление нового
		*/		
		SELECT nextval('seq_trainer') INTO future_uid;
		
		INSERT INTO "public"."t_trainer"("id", "family", "name", "qualification", "dayOfBirth")
		VALUES (
				future_uid, 
				(js->>'family')::text, 
				(js->>'name')::text,
				(js->>'qualification')::text,
				(js->>'dayOfBirth')::text::date
		);
		return future_uid; 
	end if;

	/*
		Обновление данных тренера
	*/

	future_uid = (js->>'id')::INT;

	UPDATE "public"."t_trainer"
		SET
			"family"        = (js->>'family')::text,
			"name"          = (js->>'name')::text,
			"qualification" = (js->>'qualification')::text,
			"dayOfBirth"    = (js->>'dayOfBirth')::text::date
	WHERE id = future_uid;

	return future_uid;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_game"', 2, false);
SELECT setval('"public"."seq_game_info"', 11, false);
SELECT setval('"public"."seq_result"', 4, false);
SELECT setval('"public"."seq_sportsman"', 2, false);
SELECT setval('"public"."seq_std"', 7, true);
SELECT setval('"public"."seq_trainer"', 64, true);

-- ----------------------------
-- Uniques structure for table t_age_types
-- ----------------------------
ALTER TABLE "public"."t_age_types" ADD CONSTRAINT "uq_id" UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table t_age_types
-- ----------------------------
ALTER TABLE "public"."t_age_types" ADD CONSTRAINT "t_age_types_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_games_list
-- ----------------------------
ALTER TABLE "public"."t_games_list" ADD CONSTRAINT "t_games_list_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sportsman
-- ----------------------------
ALTER TABLE "public"."t_sportsman" ADD CONSTRAINT "t_sportsman_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_standarts_directory
-- ----------------------------
ALTER TABLE "public"."t_standarts_directory" ADD CONSTRAINT "t_standarts_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_standarts_result
-- ----------------------------
ALTER TABLE "public"."t_standarts_result" ADD CONSTRAINT "t_standarts_result_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_trainer
-- ----------------------------
ALTER TABLE "public"."t_trainer" ADD CONSTRAINT "t_trainer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table t_games
-- ----------------------------
ALTER TABLE "public"."t_games" ADD CONSTRAINT "fk_game" FOREIGN KEY ("fk_game") REFERENCES "public"."t_games_list" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_games" ADD CONSTRAINT "fk_sportm" FOREIGN KEY ("fk_sportsman_id") REFERENCES "public"."t_sportsman" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_standarts_result
-- ----------------------------
ALTER TABLE "public"."t_standarts_result" ADD CONSTRAINT "fk_sp" FOREIGN KEY ("fk_sportsman") REFERENCES "public"."t_sportsman" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_standarts_result" ADD CONSTRAINT "fk_std" FOREIGN KEY ("fk_standard") REFERENCES "public"."t_standarts_directory" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_standarts_result" ADD CONSTRAINT "fk_tr" FOREIGN KEY ("fk_trainer") REFERENCES "public"."t_trainer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
