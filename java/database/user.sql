-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER recipe_app_owner
WITH PASSWORD 'owner';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO recipe_app_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO recipe_app_owner;

CREATE USER recipe_app_user
WITH PASSWORD 'user';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO recipe_app_user;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO recipe_app_user;
