
Program ejercicio12;

Const 
    VALORALTO =   32000;

Type 
    regDet =   Record
        ano:   integer;
        mes:   integer;
        dia:   integer;
        usuario:   integer;
        tiempoAcceso:   integer;
    End;

    archivo =   file Of regD;



Procedure leer (Var arch: archivo; Var regD: regDet);
Begin
    If (Not eof(arch)) Then
        read (arch, regD)
    Else
        regD.ano := VALORALTO;


End;
Procedure procesar (Var arch: archivo);

Var 
    regD :   regDet;
    anoBuscar, mesActual, anoActual, diaActual, usuarioAcutal, totalUsuario,
    totalDia, totalMes, totalAno :   integer;
Begin
    reset (arch);
    leer (arch, regD);
    writeln ('Ingrese un ano a buscar');
    readln (anoBuscar);
    While ((regD.ano <> VALORALTO) And (regD.ano <> anoBuscar)) Do
        Begin
            leer(arch, regD);
        End;

    If (regD.ano <> VALORALTO) Then
        Begin

            anoActual := regD.ano;
            actual.tiempoAcceso := 0;
            totalAno := 0;
            writeln ('Ano: ' , anoActual);
            While ((regD.ano <> VALORALTO) And (regD.ano = anoActual)) Do
                Begin
                    totalMes := 0;
                    mesActual := regD.mes;
                    WriteLn('   Mes: ', mesActual);
                    While ((regD.ano <> VALORALTO) And (regD.ano = anoActual)
                          And (regD.mes = mesActual)) Do
                        Begin
                            totalDia := 0;
                            diaActual := regD.dia;
                            writeln ('      Dia: ', diaActual);
                            While ((regD.ano <> VALORALTO) And (regD.ano =
                                  anoActual) And (regD.mes = mesActual) And (
                                  regD.dia = diaActual)) Do
                                Begin
                                    totalUsuario := 0;
                                    usuarioActual := regD.usuario;
                                    While ((regD.ano <> VALORALTO) And (regD.ano
                                          = anoActual) And (regD.mes = mesActual
                                          ) And (regD.dia = diaActual) And (regD
                                          .usuario = usuarioAcutal)) Do
                                        Begin
                                            totalUsuario := totalUsuario + regD.
                                                            tiempoAcceso;
                                            totalDia := totalDia + regD.
                                                        tiempoAcceso;
                                            totalMes := totalMes + regD.
                                                        tiempoAcceso;
                                            totalAno := totalAno + regD.
                                                        tiempoAcceso;
                                            leer (arch, regD);
                                        End;
                                    writeln ('          idUsuario: ',
                                             usuarioAcutal,
                                             ', Tiempo total de acceso en dia ',
                                             diaActual, ' mes ', mesActual, ':',
                                             totalUsuario)

                                End;

                            writeln (totalDia);

                        End;
                    writeln (totalMes);
                End;
            writeln(totalAno);

        End

    Else
        writeln ('Ano no encontrado');
End;
