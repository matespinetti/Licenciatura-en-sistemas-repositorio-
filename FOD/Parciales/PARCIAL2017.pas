
Program PARCIAL2017;

Const 
    n =   15;
    VALORALTO =   32000;

Type 
    regMaestro =   Record
        dniAlumno:   integer;
        codigoCarrera:   integer;
        montoTotal:   integer;
    End;

    regDetalle =   Record
        dniAlumno:   integer;
        codigoCarrera:   integer;
        montoCuota:   integer;
    End;

    maestro =   file Of regMaestro;
    detalle =   file Of regDetalle;
    vectorDetalles =   array[1..n] Of detalle;
    vectorRegistros =   array[1..n] Of regDetalle;


Procedure leer (Var archD: detalle; Var regD: regDetalle);
Begin
    If (Not eof(arch)) Then
        read (archD, regD)
    Else
        regD.dniAlumno := VALORALTO;
End;


Procedure minimo (Var vectorD: vectorDetalles; Var vectorR: vectorRegistros; Var
                  min: regDetalle);

Var 
    i, minIndice:   integer;
Begin
    min.dniAlumno := VALORALTO;
    For i := 1 To n Do
        Begin
            If (vectorR[i].dniAlumno < min.dniAlumno) Then
                Begin
                    min := vectorR[i];
                    minIndice := i;
                End
            Else
                Begin
                    If (vectorR[i].dniAlumno = min.dniAlumno) Then
                        Begin
                            If (vectorR[i].codigoCarrera < min.codigoCarrera)
                                Then
                                Begin
                                    min := vectorR[i];
                                    minIndice := i;
                                End;
                        End;
                End;
        End;


    If (min.dniAlumno <> VALORALTO) Then
        leer (vectorD[minIndice], vectorR[minIndice]);
End;
Procedure incisoA (Var vectorD: vectorDetalles; Var archM: maestro);

Var 
    min:   regDetalle;
    i:   integer;
    vectoR:   vectorRegistros;
    regM, actual:   maestro;

Begin
    For i := 1 To n Do
        Begin
            reset (vectorD[i]);
            leer (vectorD[i], vectorR[i]);
        End;

    reset (archM);
    read (archM, regM);
    minimo(vectorD, vectorR, min);
    While (min.dniAlumno <> VALORALTO) Do
        Begin
            actual.dniAlumno := min.dniAlumno;
            While ((min.dniAlumno<> VALORALTO) And (actual.dniAlumno = min.
                  dniAlumno)) Do
                Begin
                    actual.codigoCarrera := min.codigoCarrera;
                    actual.montoTotal := 0;
                    While ((min.dniAlumno<> VALORALTO) And (actual.dniAlumno =
                          min.dniAlumno)And (actual.codigoCarrera = min.
                          codigoCarrera)) Then
                          Begin
                          actual.montoTotal := actual.montoTotal + min.
                          montoCuota;
                          minimo (vectorD, vectorR, min);
                          End;

                          While ((regM.dniAlumno <> actual.dniAlumno) And (regM.
                          codigoCarrera <> actual.codigoCarrera)) Do
                        Begin
                            read (archM, regM);
                        End;

                    seek (archM, filePos(archM) - 1);
                    regM.montoTotal := regM.montoTotal + actual.montoTotal;
                    write (archM, regM);
                End;
        End;
    For i := 1 To n Do
        Begin
            close (vectorD[i]);
        End;

    close (archM);
End;


Procedure incisoB(Var archM: maestro; Var noPagaron: text);

Var 
    regM:   regMaestro;
Begin
    reset(archM);
    rewrite (noPagaron);
    While (Not eof(archM)) Do
        Begin
            read (archM, regM)
            If (regM.montoTotal = 0) Then
                Begin
                    writeln(noPagaron, regM.dniAlumno, regM.codigoCarrera,
                            'alumno moroso');
                End;
        End;

    close (archM);
    close (noPagaron);
End;
