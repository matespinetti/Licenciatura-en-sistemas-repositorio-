
Program ej4;

Type 
    reg_flor =   Record
        nombre:   String[45];
        codigo:   integer;
    End;
    tArchFlores:   file Of reg_flor;
