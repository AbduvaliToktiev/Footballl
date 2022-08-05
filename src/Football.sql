create table "football".football_teams
(
    id  serial  not null
        constraint football_teams_pkey
            primary key,
    name                 varchar
        constraint football_teams_name_key
            unique,
    place_in_the_ranking integer not null
);

alter table "football".football_teams
    owner to postgres;

create table employees
(
    id               serial  not null
        constraint employees_id_key
            unique,
    fio              varchar not null,
    job_title        varchar,
    football_team_id integer not null
        constraint employees_football_team_id_fkey
            references "football".football_teams,
    salary           integer not null
);

alter table employees
    owner to postgres;

delete
from "football".football_teams ft2
where ft2.id in (select ft.id
                 from "football".football_teams ft
                          left outer join "football".employees e on ft.id = e.football_team_id
                 group by ft.name, ft.id
                 having count(e.job_title) = 0);

delete
from "football".employees e
where  e.id in (select avg(emp.salary)
                from "football".employees emp
                where football_team_id = 1) < (select e.salary
                                               from "football".employees
                                               where id = 66);

select avg(emp.salary)
from "football".employees emp
where football_team_id = 1;

select e.salary
from "football".employees e
where id = 66;