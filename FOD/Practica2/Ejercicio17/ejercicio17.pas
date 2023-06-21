
Program ejercicio17;

Const 
    VALORALTO =   32000;

Type 
    moto =   Record
        codigo:   integer;
        nombre:   string;
        desc:   string;
        modelo:   string;
        marca:   string;
        stock:   integer;
    End;

    regDet =   Record
        codigo:   integer;
        precio:   real;
        fecha:   string;
    End;

    detalle =   file Of regDet;
    vectorDet =   array [1..10] Of detalle;
    vectorReg =   array [1..10] Of regDet;
    maestro =   file Of moto;


Procedure leer (Var archD: detalle; Var regD: regDet);
Begin
    If (Not eof(archD)) Then
        read(archD, regD)
    Else
        regD.codigo := VALORALTO;
End;


Procedure minimo (Var vectorD: vectorDet; Var vectorR: vectorReg; Var min: regD)
;

Var 
    i, indiceMin :   integer;
Begin
    min.codigo := VALORALTO;
    For i := 1 To 10 Do
        Begin
            If (vectorR[i] < min.codigo) Then
                Begin
                    min := vectorR[i];
                    indiceMin := i;
                End;
        End;

    If (min.codigo <> VALORALTO) Then
        leer (vectorD[indiceMin], vectorR[indiceMin]);

End;

Procedure procesar (Var vectorD: vectorDet; Var archM: maestro);

Var 
    vectorR:   vectorReg;
    regM:   moto;
    min:   regDet;
    i:   integer;
    codActual, totalVentas, maxVentas, maxCodigo :   integer;


Begin
    maxVentas := -1;
    For i := 1 To 10 Do
        Begin
            reset (vectorD[i]);
            leer(vectorD[i], vectorR[i]);

        End;
    read (archM, regM );

    minimo (vectorD, vectorR, min);

    While (min.codigo <> VALORALTO) Do
        Begin
            codActual := min.codigo;
            totalVentas := 0;
            While (codActual = min.codigo) Do
                Begin
                    total := total + 1;
                    minimo (vectorD, vectorR, min);
                End;

            If (total > maxVentas) Then
                Begin
                    maxVentas := total;
                    maxCodigo := codActual;
                End;

            While (regM.codigo <> codActual) Do
                Begin
                    read(archM, regM);
                End;
            regM.stock := regM.stock - totalVentas;
            seek (archM, FilePos(archM) - 1);
            write (archM, regM);


        End;


    writeln (maxCodigo);
End;
