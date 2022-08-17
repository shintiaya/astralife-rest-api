-- VERSION PostgreSQL 10.10, compiled by Visual C++ build 1800, 64-bit --

-- CREATE DATABASE --
-- DIJALANKAN SEBELUM APLIKASI DIRUN --
CREATE DATABASE dbastra;
-- END --


-- INSERT DATA DEPARTMENTS --
-- INSERT DATA DAPAT DILAKUKAN SETELAH APLIKASI BERHASIL DIJALANKAN --
INSERT INTO public.departments
(authoriser, authorize_time, created_by, created_time, status, updated_by, updated_time, "version", dept_name, dept_no)
VALUES( '', NULL, '', NULL, 'L', '', NULL, 0, 'Department Pemasaran', '101');
INSERT INTO public.departments
( authoriser, authorize_time, created_by, created_time, status, updated_by, updated_time, "version", dept_name, dept_no)
VALUES( '', NULL, '', NULL, 'L', '', NULL, 0, 'Department Asuransi', '102');
INSERT INTO public.departments
( authoriser, authorize_time, created_by, created_time, status, updated_by, updated_time, "version", dept_name, dept_no)
VALUES( '', NULL, '', NULL, 'L', '', NULL, 0, 'Department Investasi', '103');
INSERT INTO public.departments
( authoriser, authorize_time, created_by, created_time, status, updated_by, updated_time, "version", dept_name, dept_no)
VALUES( '', NULL, '', NULL, 'L', '', NULL, 0, 'Department Sistem Informasi', '104');
-- END --
