
Program prueba;

Const 
    VALORALTO =   32000;

Type 
    alumno =   Record
        codigo:   integer;
        apellido:   string;
        nombre:   string;
        cursadas :   integer;
        finales:   integer;
    End;

    regDet =   Record
        codAlumno:   integer;
        info:   string;
    End;

    archM =   file Of alumno;
    archD =   file Of regDet;



Procedure leer(Var detalle: archD; Var regD: regDet);
Begin
    If (Not eof(archD)) Then
        read (archD, regDet)
    Else
        regDet.codigo := VALORALTO;
End;
Procedure actulizarMaestro (Var maestro: archM; Var detalle: archD);

Var 
    total, regM :   alumno;
    regD:   regDet;
Begin
    reset(maestro);
    reset(detalle);
    leer (detalle, regD);
    read(maestro, regM);

    While (regD.codigo <> VALORALTO) Do
        Begin
            total.codigo := regD.codAlumno;
            total.cursadas := 0;
            total.finales := 0;
            While ((regD.codigo <> VALORALTO) And (regD.codAlumno = total.codigo
                  )) Do
                Begin
                    If (regD.info = 'Cursada') Then
                        Begin
                            total.cursadas =   total.cursadas + 1;
                        End
                    Else
                        total.finales =   total.finales + 1;

                    leer (detalle, regD);
                End;

            While (regM.codigo <> total.codigo) Do
                Begin
                    read(maestro, regM);
                End;

            regM.cursadas := regM.cursadas + total.cursadas;
            regM.finales := regM.finales + total.finales;

            seek (maestro, FilePos(maestro) - 1);
            write (maestro, archM);
        End;


End;



Procedure listar (Var maestro: archM; Var alumnos: text);

Var 
    a:   alumno;
Begin
    reset(maestro);
    rewrite(alumnos);
    While (Not eof(maestro)) Do
        Begin
            read(maestro, a);
            If (a.cursadas > 4) Then
                Begin
                    writeln (alumnos, a.codigo, a.apellido);
                    writeln (alumnos, a.nombre);
                    writeln (alumnos, a.cursadas, a.finales);
                End;
        End;
    close(maestro);
    close (alumnos);
End;
