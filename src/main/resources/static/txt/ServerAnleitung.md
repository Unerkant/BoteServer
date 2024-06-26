/**
* Den 20.06.2024
* Text-layout Paul Richter
*/

                   Allgemeine Einstellungen

************************************************
*  Hilfe Links
************************************************
1.


*************************************************
*   Spring Security Login, kurze Beschreibung
*************************************************
1. Spring Security Login example
2. https://www.javaguides.net/2023/04/spring-security-login-form-example-with-database-authentication.html
3. benötigst Scripten
    a. Database: Table -> role, sind gespeichert nur role_id + ADMIN oder USER(Admin ist=1, User ist=2)
    b.           Table -> user_role(ist eine @JoinTable), sind gespeichert user_id + role_id(von Table -> role)
    c.           Table -> user, sind alle Daten von User enthalten + role, in role werden daten von
                                user_role abgefragt und in role gespechert(per @Joit abfrage)
    d. configuration: SecurityConfig
    e. model: User + Role
    f. repository: UserRepository
    g. service: UserService, implements UserDetailsService(von spring security, muss sein)
    h. home.html + ignore.html
4.  in SecurityConfig: unter formLogin kann man eigenes Login script abruffen 
                       unter logout, wird von spring wieder login geladen
                       <a data-th-href="@{/logout}">Logout</a>
            unter: http .authorizeHttpRequests(.....) werden dei html seiten bestimmt und geladen
5. FAZIT: